package com.scaler.parkinglot.services;

import com.scaler.parkinglot.dtos.CreateInvoiceRequest;
import com.scaler.parkinglot.exceptions.PaymentFailedException;
import com.scaler.parkinglot.exceptions.TicketNotFoundException;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.InvoiceRepository;
import com.scaler.parkinglot.strategies.paycalculation.PayCalculationStrategy;
import com.scaler.parkinglot.strategies.paycalculation.PayCalculationStrategyFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {

    // create checkout flow
    private TicketService ticketService;
    private InvoiceRepository invoiceRepository;
    private PaymentService paymentService;
    private ParkingSpotService parkingSpotService;
    public Invoice checkout(CreateInvoiceRequest request) {

        Ticket ticket = ticketService.getTicket(request.getTicketId());
        if(ticket == null) {
            throw new TicketNotFoundException(request.getTicketId());
        }
        //get payment
        Double amount = getPayableAmount(ticket);
        Payment payment = paymentService.pay(amount, request.getTicketId(), request.getMode());
        validate(payment);
        //update spot
        ParkingSpot parkingSpot = ticket.getSpot();
        parkingSpot.setStatus(SpotStatus.AVAILABLE);
        parkingSpotService.update(parkingSpot);

        //create invoice
        Invoice invoice = Invoice.builder()
                .amount(amount)
                .payments(List.of(payment))
                .exitTime(LocalDateTime.now())
                .ticketId(request.getTicketId())
                .build();

        return invoiceRepository.save(invoice);
    }

    private void validate(Payment payment) {
        if(payment.getStatus() != PaymentStatus.SUCCESS) {
            throw new PaymentFailedException();
        }
    }

    private Double getPayableAmount(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        double minutes = (double)ChronoUnit.MINUTES.between(entryTime, LocalDateTime.now());
        Double hours = minutes/60;
        hours = Math.ceil(hours);
        if(hours >= 1) {
            hours -= 1;
        }
        Double amount = PayCalculationStrategyFactory
                .getPayCalculationStrategy(ticket.getVehicle().getType())
                .calculatePay(hours);

        return amount;
    }

    public Invoice findOrCreate(Long ticketId) {
        Invoice invoice = invoiceRepository.getInvoiceByTicketId(ticketId);
        if(invoice == null) {
            invoice = Invoice.builder()
                    .ticketId(ticketId)
                    .build();
        }
        return invoice;
    }
    //request dto
    //validation
    //update entity - slot
    //fee calculation

}

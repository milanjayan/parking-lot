package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Payment;
import com.scaler.parkinglot.models.PaymentMode;
import com.scaler.parkinglot.models.PaymentStatus;
import com.scaler.parkinglot.repositories.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;

    public Payment pay(Double amount, Long ticketId, PaymentMode mode) {
        Payment payment = Payment.builder()
                .status(PaymentStatus.SUCCESS)
                .time(LocalDateTime.now())
                .amount(amount)
                .ticketId(ticketId)
                .mode(mode)
                .build();
        return paymentRepository.save(payment);
    }
}

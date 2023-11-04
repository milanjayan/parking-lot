package com.scaler.parkinglot.services;

import com.scaler.parkinglot.dtos.CreateTicketRequest;
import com.scaler.parkinglot.exceptions.SpotNotAvailableException;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TicketService {

    private TicketRepository ticketRepository;
    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;
    private EntryGateService entryGateService;
    private ParkingOperatorService parkingOperatorService;
    public Ticket create(CreateTicketRequest request) {
        //check if the spot is available for vehicle type
        ParkingSpot parkingSpot = parkingSpotService.allocateParkingSpot(request.getParkingLotId(), request.getVehicleType());
        if(parkingSpot == null) {
            throw new SpotNotAvailableException(request.getVehicleType());
        }
        //update spot
        parkingSpot.setStatus(SpotStatus.OCCUPIED);
        //update database
        ParkingSpot updatedSpot = parkingSpotService.update(parkingSpot);

        //get vehicle
        Vehicle vehicle = vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType());

        Gate entryGate = entryGateService.getEntryGateById(request.getEntryGateId());
        ParkingOperator issuer = parkingOperatorService.getOperatorById(request.getIssuerId());

        //create ticket
        Ticket ticket = Ticket.builder()
                .vehicle(vehicle)
                .entryTime(LocalDateTime.now())  //better to get from front end
                .spot(updatedSpot)
                .issuedBy(issuer)
                .entryGate(entryGate)
                .build();

        return ticketRepository.save(ticket);
    }

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.getById(ticketId);
    }
}

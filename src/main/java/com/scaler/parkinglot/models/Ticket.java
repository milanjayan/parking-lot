package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@SuperBuilder
public class Ticket extends BaseModel {
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot spot;
    private ParkingOperator issuedBy;
    private Gate entryGate;
}

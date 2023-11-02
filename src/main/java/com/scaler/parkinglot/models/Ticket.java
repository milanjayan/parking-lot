package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Getter
@SuperBuilder
public class Ticket extends BaseModel {
    private User user;
    private Date entryTime;
    private ParkingSpot spot;
    private Gate entryGate;
}

package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
public class Ticket extends BaseModel {
    private User user;
    private Date entryTime;
    private Spot spot;
    private Gate entryGate;
}

package com.scaler.parkinglot.models;

import lombok.Getter;

import java.util.Date;

@Getter
public class Payment {
    private Date time;
    private Double amount;
    private Ticket ticket;
    private PaymentMode mode;
    private PaymentStatus status;
}

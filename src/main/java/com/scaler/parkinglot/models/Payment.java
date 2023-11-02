package com.scaler.parkinglot.models;

import java.util.Date;

public class Payment {
    private Date time;
    private Double amount;
    private Ticket ticket;
    private PaymentMode mode;
    private PaymentStatus status;
}

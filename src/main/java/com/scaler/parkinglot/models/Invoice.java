package com.scaler.parkinglot.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class Invoice {
    private Date date;
    private Date exitTime;
    private Ticket ticket;
    private Double amount;
    private List<Payment> payments = new ArrayList<>();
}

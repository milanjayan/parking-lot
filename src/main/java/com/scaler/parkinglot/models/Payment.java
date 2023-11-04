package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@SuperBuilder
public class Payment extends BaseModel {
    private LocalDateTime time;
    private Double amount;
    private Long ticketId;
    private PaymentMode mode;
    private PaymentStatus status;
}

package com.scaler.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@SuperBuilder
@Setter
public class Invoice extends BaseModel {
    private LocalDateTime exitTime;
    private Long ticketId;
    private Double amount;
    private List<Payment> payments = new ArrayList<>();
}

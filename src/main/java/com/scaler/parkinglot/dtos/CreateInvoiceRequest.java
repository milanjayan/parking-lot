package com.scaler.parkinglot.dtos;


import com.scaler.parkinglot.models.PaymentMode;
import lombok.Getter;

@Getter
public class CreateInvoiceRequest {
    private Long ticketId;
    private PaymentMode mode;
}

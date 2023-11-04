package com.scaler.parkinglot.exceptions;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException() {
        super("Payment has failed");
    }
}

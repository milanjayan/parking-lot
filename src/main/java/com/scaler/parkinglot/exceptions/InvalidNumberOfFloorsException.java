package com.scaler.parkinglot.exceptions;

public class InvalidNumberOfFloorsException extends RuntimeException {
    public InvalidNumberOfFloorsException() {
        super("Number of floors is invalid");
    }
}

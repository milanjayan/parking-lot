package com.scaler.parkinglot.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long ticketId) {
        super("Ticket with id: "+ticketId+" not found");
    }
}

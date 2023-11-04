package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {
    private List<Invoice> invoices = new ArrayList<>();

    public Invoice save(Invoice invoice) {
        invoices.add(invoice);
        return invoice;
    }

    public Invoice getInvoiceByTicketId(Long ticketId) {
        for(Invoice invoice : invoices) {
            if(invoice.getTicketId() == ticketId) {
                return invoice;
            }
        }
        return null;
    }
}

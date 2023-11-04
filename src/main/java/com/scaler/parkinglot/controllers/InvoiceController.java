package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.CreateInvoiceRequest;
import com.scaler.parkinglot.models.Invoice;
import com.scaler.parkinglot.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invoice")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

    @PostMapping
    public Invoice createInvoice(@RequestBody CreateInvoiceRequest request) {
        return invoiceService.checkout(request);
    }
}

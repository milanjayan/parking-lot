package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    public Payment save(Payment payment) {
        payments.add(payment);
        return payment;
    }

}

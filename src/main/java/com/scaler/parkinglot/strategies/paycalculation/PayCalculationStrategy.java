package com.scaler.parkinglot.strategies.paycalculation;

import com.scaler.parkinglot.models.Ticket;

import java.time.LocalDateTime;

public interface PayCalculationStrategy {
    Double calculatePay(Double hours);
}

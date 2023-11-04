package com.scaler.parkinglot.strategies.paycalculation;

import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.models.TicketPrice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SmallVehiclePayCalculationStrategy implements PayCalculationStrategy {
    @Override
    public Double calculatePay(Double hours) {
        return TicketPrice.small + ((hours-1) * TicketPrice.extraSmall);
    }
}

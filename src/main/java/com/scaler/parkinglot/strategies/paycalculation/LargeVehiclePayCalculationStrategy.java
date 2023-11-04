package com.scaler.parkinglot.strategies.paycalculation;

import com.scaler.parkinglot.models.TicketPrice;

public class LargeVehiclePayCalculationStrategy implements PayCalculationStrategy {
    @Override
    public Double calculatePay(Double hours) {
        return TicketPrice.large + ((hours-1) * TicketPrice.extraLarge);
    }
}

package com.scaler.parkinglot.strategies.paycalculation;

import com.scaler.parkinglot.models.TicketPrice;

public class MediumVehiclePayCalculationStrategy implements PayCalculationStrategy {
    @Override
    public Double calculatePay(Double hours) {
        return TicketPrice.medium + ((hours-1) * TicketPrice.extraMedium);
    }
}

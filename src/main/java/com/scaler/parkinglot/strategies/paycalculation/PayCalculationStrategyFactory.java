package com.scaler.parkinglot.strategies.paycalculation;

import com.scaler.parkinglot.exceptions.InvalidVehicleTypeException;
import com.scaler.parkinglot.models.VehicleType;
import com.sun.jdi.InvalidTypeException;

public class PayCalculationStrategyFactory {
    public static PayCalculationStrategy getPayCalculationStrategy(VehicleType type) {
        switch(type) {
            case SMALL : return new SmallVehiclePayCalculationStrategy();
            case MEDIUM: return new MediumVehiclePayCalculationStrategy();
            case LARGE: return new LargeVehiclePayCalculationStrategy();
            default: throw new InvalidVehicleTypeException(type);
        }
    }
}

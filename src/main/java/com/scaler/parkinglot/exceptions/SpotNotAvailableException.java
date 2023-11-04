package com.scaler.parkinglot.exceptions;

import com.scaler.parkinglot.models.VehicleType;

public class SpotNotAvailableException extends RuntimeException {
    public SpotNotAvailableException(VehicleType vehicleType) {
        super("Spot not available for vehicle type: "+vehicleType);
    }
}

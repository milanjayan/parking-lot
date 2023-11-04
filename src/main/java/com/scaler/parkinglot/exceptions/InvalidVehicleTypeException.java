package com.scaler.parkinglot.exceptions;

import com.scaler.parkinglot.models.VehicleType;

public class InvalidVehicleTypeException extends RuntimeException {
    public InvalidVehicleTypeException(VehicleType type) {
        super("Invalid vehicle type " + type);
    }
}

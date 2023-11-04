package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Vehicle extends BaseModel {
    private String number;
    private VehicleType type;
}

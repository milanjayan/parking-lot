package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Spot extends BaseModel {
    private long spotId;
    private long floorId;
    private VehicleType type;
    private SpotStatus status;
}

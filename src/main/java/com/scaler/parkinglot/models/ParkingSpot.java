package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ParkingSpot extends BaseModel {
    private Long spotId;
    private Long floorId;
    private VehicleType type;
    private SpotStatus status;
}

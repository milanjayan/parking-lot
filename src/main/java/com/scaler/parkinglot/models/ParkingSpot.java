package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private Long spotId;
    private Long floorId;
    private VehicleType type;
    private SpotStatus status;
}

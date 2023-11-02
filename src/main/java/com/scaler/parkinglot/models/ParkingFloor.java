package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
public class ParkingFloor extends BaseModel {
    private Long floorId;
    private List<ParkingSpot> spots = new ArrayList<>();
    private PaymentBooth booth;
    private DisplayBoard displayBoard;
}

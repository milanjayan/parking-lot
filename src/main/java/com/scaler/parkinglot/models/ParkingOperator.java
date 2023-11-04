package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ParkingOperator extends BaseModel {
    private String name;
    private int age;
    private Long number;
}

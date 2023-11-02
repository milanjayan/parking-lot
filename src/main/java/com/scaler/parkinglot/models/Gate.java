package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Gate extends BaseModel {
    private Long gateId;
    private Operator operator;
}

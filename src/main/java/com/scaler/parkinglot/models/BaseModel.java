package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Getter
public abstract class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}

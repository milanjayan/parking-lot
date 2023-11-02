package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
public abstract class BaseModel {
    private int id;
    private Date createdAt;
    private Date updatedAt;
}

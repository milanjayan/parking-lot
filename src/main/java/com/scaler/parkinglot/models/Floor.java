package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
public class Floor extends BaseModel {
    private int number;
    private List<Spot> spots = new ArrayList<>();
    private List<PaymentBooth> booths = new ArrayList<>();
    private DisplayBoard displayBoard;
}

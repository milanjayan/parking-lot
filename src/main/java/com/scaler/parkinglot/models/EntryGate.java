package com.scaler.parkinglot.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class EntryGate extends Gate{
    private DisplayBoard displayBoard;
}

package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Gate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryGateRepository {
    private List<Gate> entryGates = new ArrayList<>();

    public Gate save(Gate entryGate) {
        entryGates.add(entryGate);
        return entryGate;
    }

    public Gate getById(Long entryGateId) {
        for(Gate gate: entryGates) {
            if(gate.getGateId() == entryGateId) {
                return gate;
            }
        }
        return null;
    }

}

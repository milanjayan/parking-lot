package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.repositories.EntryGateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntryGateService {
    private EntryGateRepository entryGateRepository;

    public Gate create(Gate gate) {
        entryGateRepository.save(gate);
        return gate;
    }

    public Gate getEntryGateById(Long entryGateId) {
        return entryGateRepository.getById(entryGateId);
    }
}

package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingOperator;
import com.scaler.parkinglot.repositories.ParkingOperatorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingOperatorService {
    private ParkingOperatorRepository parkingOperatorRepository;

    public ParkingOperator create(ParkingOperator operator) {
        parkingOperatorRepository.save(operator);
        return operator;
    }

    public ParkingOperator getOperatorById(Long operatorId) {
        return parkingOperatorRepository.getById(operatorId);
    }

}

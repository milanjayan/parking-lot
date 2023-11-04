package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.ParkingOperator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingOperatorRepository {
    private List<ParkingOperator> parkingOperators = new ArrayList<>();

    public ParkingOperator save(ParkingOperator operator) {
        parkingOperators.add(operator);
        return operator;
    }

    public ParkingOperator getById(Long operatorId) {
        for(ParkingOperator operator: parkingOperators) {
            if(operator.getId() == operatorId) {
                return operator;
            }
        }
        return null;
    }
}

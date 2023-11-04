package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        Vehicle vehicle = vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
        if(vehicle == null) {
            vehicle = Vehicle.builder()
                    .number(vehicleNumber)
                    .type(vehicleType)
                    .build();
            vehicleRepository.save(vehicle);
        }
        return vehicle;
    }
}

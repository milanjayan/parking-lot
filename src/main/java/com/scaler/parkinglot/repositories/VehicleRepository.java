package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    public Vehicle getVehicleByVehicleNumber(String vehicleNumber) {
        for(Vehicle vehicle : vehicles) {
            if(vehicle.getNumber() == vehicleNumber) {
                return vehicle;
            }
        }
        return null;
    }
}

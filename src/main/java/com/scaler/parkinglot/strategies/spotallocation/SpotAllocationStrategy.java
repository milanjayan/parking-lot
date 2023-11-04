package com.scaler.parkinglot.strategies.spotallocation;

import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
public abstract class SpotAllocationStrategy {

    protected ParkingSpotRepository parkingSpotRepository;
    public abstract ParkingSpot allocateSpot(Long floorId, VehicleType vehicleType);
}

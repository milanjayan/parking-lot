package com.scaler.parkinglot.strategies.spotallocation;

import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


public class FirstFreeSpaceStrategy extends SpotAllocationStrategy {

    public FirstFreeSpaceStrategy(ParkingSpotRepository parkingSpotRepository) {
        super(parkingSpotRepository);
    }

    @Override
    public ParkingSpot allocateSpot(Long floorId, VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndAvailability(vehicleType);
    }
}

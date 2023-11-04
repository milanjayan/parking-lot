package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.SpotSelectionType;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import com.scaler.parkinglot.strategies.spotallocation.SpotAllocationStrategy;
import com.scaler.parkinglot.strategies.spotallocation.SpotAllocationStrategyFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpot create(ParkingSpot parkingSpot) {
        return null;
    }

    public ParkingSpot update(ParkingSpot parkingSpot) {
        return parkingSpotRepository.update(parkingSpot);
    }

    public ParkingSpot allocateParkingSpot(Long floorId, VehicleType vehicleType) {
        SpotAllocationStrategyFactory factory = new SpotAllocationStrategyFactory(parkingSpotRepository);
        return factory.getSpotAllocationStrategy(SpotSelectionType.FIRST_FREE_SPOT)
                .allocateSpot(floorId, vehicleType);
    }
}

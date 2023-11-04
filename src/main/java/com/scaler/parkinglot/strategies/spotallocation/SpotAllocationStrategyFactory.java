package com.scaler.parkinglot.strategies.spotallocation;

import com.scaler.parkinglot.models.SpotSelectionType;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
public class SpotAllocationStrategyFactory {

    private ParkingSpotRepository parkingSpotRepository;

    public SpotAllocationStrategy getSpotAllocationStrategy(SpotSelectionType type) {
        switch(type) {
            case FIRST_FREE_SPOT: return new FirstFreeSpaceStrategy(parkingSpotRepository);
            case FLOOR_BASED: return new FloorBasedStrategy(parkingSpotRepository);
            default: return null;
        }
    }
}

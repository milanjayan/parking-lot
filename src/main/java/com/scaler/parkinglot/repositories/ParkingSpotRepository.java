package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.SpotStatus;
import com.scaler.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot update(ParkingSpot parkingSpot) {
        for(ParkingSpot spot : parkingSpots) {
            if(parkingSpot.getSpotId() == spot.getSpotId()) {
                //since dummy respo, same object is passed so already updated
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot findOneByVehicleTypeAndAvailability(VehicleType vehicleType) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.getStatus() == SpotStatus.AVAILABLE && spot.getType() == vehicleType) {
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot findOneByFloorIdVehicleTypeAndAvailability(Long floorId, VehicleType vehicleType) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.getFloorId() == floorId && spot.getType() == vehicleType) {
                return spot;
            }
        }
        return null;
    }

}

package com.scaler.parkinglot.controllers;


// Responsibility
// 1. Request validation
// 2. Data transformation

import com.scaler.parkinglot.dtos.CreateParkingLotRequest;
import com.scaler.parkinglot.exceptions.InvalidNumberOfFloorsException;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.services.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/parking-lot")
@AllArgsConstructor
public class ParkingLotController {

    private ParkingLotService parkingLotService;

    //Crate
    // POST /api/v1/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = request.toParkingLot();
        return parkingLotService.create(parkingLot);
    }

    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors() == null) {
            throw new InvalidNumberOfFloorsException();
        }
    }

    //Read
    // GET /api/v1/parking-lot/{id}
    @GetMapping("/{id}")
    public ParkingLot getParkingLot(@PathVariable("id") Long id) {
        return ParkingLot.builder().id(id).build();
    }
    //Update
    // PUT /api/v1/parking-lot/{id}

    //Delete
    // DELETE /api/v1/parking-lot/{id}

}

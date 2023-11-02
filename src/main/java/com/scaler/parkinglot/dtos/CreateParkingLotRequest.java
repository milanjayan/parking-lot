package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.*;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloors;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;

    public ParkingLot toParkingLot() {
        List<ParkingFloor> floors = new ArrayList<>();
        IntStream.range(0, this.numberOfFloors).forEach(floor -> {
                    List<ParkingSpot> spots = new ArrayList<>();
                    IntStream.range(0, this.numberOfSpotsPerFloors).forEach(spot ->
                            spots.add(ParkingSpot.builder()
                                    .spotId(Long.valueOf(spot))
                                    .floorId(Long.valueOf(floor))
                                    .status(SpotStatus.AVAILABLE)
                                    .build()
                            ));
                    ParkingFloor parkingFloor = ParkingFloor.builder()
                            .floorId(Long.valueOf(floor))
                            .spots(spots)
                            .booth(PaymentBooth.builder().boothId(Long.valueOf(floor)).build())
                            .displayBoard(DisplayBoard.builder().build())
                            .build();
                    floors.add(parkingFloor);
                });

        DisplayBoard displayBoard = DisplayBoard.builder().build();
        List<Gate> entryGates = new ArrayList<>();
        IntStream.range(0, this.numberOfEntryGates).forEach(gate -> {
            Gate entryGate = EntryGate.builder()
                    .gateId(Long.valueOf(gate))
                    .displayBoard(displayBoard)
                    .build();
            entryGates.add(entryGate);
        });
        List<Gate> exitGates = new ArrayList<>();
        IntStream.range(0, this.numberOfExitGates).forEach(gate -> {
            Gate exitGate = ExitGate.builder().build();
            exitGates.add(exitGate);
        });

        return ParkingLot.builder()
                .name(this.name)
                .address(this.address)
                .floors(floors)
                .entryGates(entryGates)
                .exitGates(exitGates)
                .displayBoard(displayBoard)
                .build();
    }
}

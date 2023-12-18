package com.example.busstationgfl.entities.bus;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum BusType {
    Minibus(8),
    DoubleDecker(24),
    MotorCoach(10);

    private final int numberOfSeats;

}

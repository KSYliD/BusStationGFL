package com.example.busstationgfl.dtos.journey.bus;

import com.example.busstationgfl.dtos.journey.JourneyDto;
import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.bus.Status;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatDto {
    private int number;
    private Status status;
    private UserDto userContacts;
    private String date;
    private BusDto bus;
    private JourneyDto journey;
}

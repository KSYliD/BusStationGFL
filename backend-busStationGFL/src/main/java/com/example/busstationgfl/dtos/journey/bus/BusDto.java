package com.example.busstationgfl.dtos.journey.bus;

import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.bus.BusType;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusDto {
    private long id;
    private UserDto driver;
    private String licensePlate;
    private BusType busType;
}

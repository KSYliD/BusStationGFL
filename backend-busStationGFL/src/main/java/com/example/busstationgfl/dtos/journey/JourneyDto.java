package com.example.busstationgfl.dtos.journey;

import com.example.busstationgfl.dtos.journey.bus.BusDto;
import com.example.busstationgfl.entities.journey.Route;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDto {
    private long id;
    private Route route;
    private BusDto bus;

}

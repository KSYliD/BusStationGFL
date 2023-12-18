package com.example.busstationgfl.dtos.requests;

import com.example.busstationgfl.dtos.journey.JourneyDto;
import com.example.busstationgfl.dtos.journey.bus.BusDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateSeatsRequestDto {
    private String date;
    private BusDto bus;
    private JourneyDto journeyDto;
}

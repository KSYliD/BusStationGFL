package com.example.busstationgfl.dtos.requests;

import com.example.busstationgfl.dtos.journey.JourneyDto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDTO {
    private JourneyDto journey;
    private long userSeats;
}

package com.example.busstationgfl.dtos.journey;

import com.example.busstationgfl.dtos.journey.bus.SeatDto;
import com.example.busstationgfl.dtos.user.UserDto;
import com.example.busstationgfl.entities.TicketStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDto {
    private long id;
    private UserDto user;
    private JourneyDto journey;
    private SeatDto seatDto;
    private TicketStatus ticketStatus;

}

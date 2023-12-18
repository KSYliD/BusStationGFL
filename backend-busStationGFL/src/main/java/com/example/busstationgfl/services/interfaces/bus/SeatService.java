package com.example.busstationgfl.services.interfaces.bus;

import com.example.busstationgfl.dtos.journey.bus.SeatDto;
import com.example.busstationgfl.dtos.requests.BuyTicketRequestDto;
import com.example.busstationgfl.dtos.requests.GenerateSeatsRequestDto;
import com.example.busstationgfl.dtos.requests.ReturnTicketRequestDto;
import com.example.busstationgfl.entities.bus.Status;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface SeatService {
    List<SeatDto> findSeatsByBusId(long id);
    List<SeatDto> findAllByBusIdAndJourneyId(long id, long journeyId);
    SeatDto buyTheSeat(BuyTicketRequestDto buyRequestDto, UserDetails userDetails);
    SeatDto returnTheTicket(ReturnTicketRequestDto returnTheTicketRequest);
    int countSeatByStatusAndBusIdAndJourneyId(Status status, long id, long journeyId);
    SeatDto save(SeatDto seat);
    List<SeatDto> generateSeats(GenerateSeatsRequestDto generateSeatsRequestDto);
}

package com.example.busstationgfl.mappers;

import com.example.busstationgfl.dtos.journey.bus.SeatDto;
import com.example.busstationgfl.entities.bus.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    Seat dtoToSeat(SeatDto seatDto);
    SeatDto seatToDto(Seat seat);
}

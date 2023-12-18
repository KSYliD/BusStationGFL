package com.example.busstationgfl.mappers;

import com.example.busstationgfl.dtos.journey.TicketDto;
import com.example.busstationgfl.entities.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    @Mapping(source = "seat", target = "seatDto")
    TicketDto ticketToDto(Ticket ticket);
}

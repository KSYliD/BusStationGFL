package com.example.busstationgfl.services.interfaces;

import com.example.busstationgfl.dtos.journey.TicketDto;
import com.example.busstationgfl.dtos.requests.TicketRequestDTO;
import com.example.busstationgfl.entities.TicketStatus;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface TicketService {
    TicketDto save(TicketRequestDTO ticketRequestDTO , UserDetails userDetails);
    List<TicketDto> findAllByUserIdAndTicketStatus(UserDetails userDetails, TicketStatus ticketStatus);
    TicketDto findById(long id);
}

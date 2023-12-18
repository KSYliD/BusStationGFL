package com.example.busstationgfl.services.classes;

import com.example.busstationgfl.dtos.journey.TicketDto;
import com.example.busstationgfl.dtos.requests.TicketRequestDTO;
import com.example.busstationgfl.entities.Ticket;
import com.example.busstationgfl.entities.TicketStatus;
import com.example.busstationgfl.entities.bus.Seat;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.mappers.JourneyMapper;
import com.example.busstationgfl.mappers.TicketMapper;
import com.example.busstationgfl.repositories.JourneyRepository;
import com.example.busstationgfl.repositories.SeatRepository;
import com.example.busstationgfl.repositories.TicketRepository;
import com.example.busstationgfl.repositories.UserRepository;
import com.example.busstationgfl.services.interfaces.TicketService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class TicketServiceImpl implements TicketService {
    private final TicketMapper ticketMapper;

    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    private SeatRepository seatRepository;
    private JourneyRepository journeyRepository;
    private JourneyMapper journeyMapper;

    @Override
    public TicketDto save(TicketRequestDTO ticketRequestDTO , UserDetails userDetails) {
        Ticket ticket = new Ticket();
        User user = userRepository.findByEmail(userDetails.getUsername());
        Seat seat = seatRepository
                .findByNumberAndBus_IdAndJourney_Id(
                        ticketRequestDTO.getUserSeats(),
                        journeyRepository.findById(ticketRequestDTO.getJourney().getId()).getBus().getId(),
                        ticketRequestDTO.getJourney().getId()
                );
        ticket.setUser(user);
        ticket.setJourney(journeyMapper.DtoToJourney(ticketRequestDTO.getJourney()));
        ticket.setSeat(seat);
        ticket.setTicketStatus(TicketStatus.Actual);
        return ticketMapper.ticketToDto(ticketRepository.save(ticket));
    }
    @Override
    public List<TicketDto> findAllByUserIdAndTicketStatus(UserDetails userDetails, TicketStatus ticketStatus){
        long id = userRepository.findByEmail(userDetails.getUsername()).getId();
        return ticketRepository.findAllByUserIdAndTicketStatus(id, ticketStatus)
                .stream()
                .map(ticketMapper::ticketToDto)
                .collect(Collectors.toList());
    }
    @Override
    public TicketDto findById(long id){
        return ticketMapper.ticketToDto(ticketRepository.findById(id));
    }
}

package com.example.busstationgfl.services.classes.bus;

import com.example.busstationgfl.dtos.journey.bus.SeatDto;
import com.example.busstationgfl.dtos.requests.BuyTicketRequestDto;
import com.example.busstationgfl.dtos.requests.GenerateSeatsRequestDto;
import com.example.busstationgfl.dtos.requests.ReturnTicketRequestDto;
import com.example.busstationgfl.entities.Ticket;
import com.example.busstationgfl.entities.TicketStatus;
import com.example.busstationgfl.entities.bus.Status;
import com.example.busstationgfl.entities.bus.Seat;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.mappers.SeatMapper;
import com.example.busstationgfl.repositories.JourneyRepository;
import com.example.busstationgfl.repositories.SeatRepository;
import com.example.busstationgfl.repositories.TicketRepository;
import com.example.busstationgfl.repositories.UserRepository;
import com.example.busstationgfl.services.interfaces.bus.SeatService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class SeatServiceImpl implements SeatService {
    private SeatRepository seatRepository;
    private UserRepository userRepository;
    private JourneyRepository journeyRepository;
    private TicketRepository ticketRepository;
    private final SeatMapper seatMapper;

    @Override
    public List<SeatDto> findSeatsByBusId(long id) {
        return seatRepository.findAllByBus_Id(id).stream().map(seatMapper::seatToDto).collect(Collectors.toList());
    }

    @Override
    public List<SeatDto> findAllByBusIdAndJourneyId(long id, long journeyId) {
        return seatRepository.findAllByBusIdAndJourneyId(id, journeyId).stream().map(seatMapper::seatToDto).collect(Collectors.toList());
    }

    @Override
    public SeatDto buyTheSeat(BuyTicketRequestDto buyRequestDto, UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername());
        Seat seat = seatRepository
                .findByNumberAndBus_IdAndJourney_Id(
                        buyRequestDto.getNumber(),
                        journeyRepository.findById(buyRequestDto.getJourneyId()).getBus().getId(),
                        buyRequestDto.getJourneyId()
                );
        seat.setUserContacts(user);
        seat.setStatus(Status.SOLD);
        seatRepository.save(seat);
        return seatMapper.seatToDto(seat);
    }

    @Override
    public SeatDto returnTheTicket(ReturnTicketRequestDto returnTheTicketRequest) {
        Seat seat = seatRepository
                .findByNumberAndBus_IdAndJourney_Id(
                        returnTheTicketRequest.getNumber(),
                        journeyRepository.findById(returnTheTicketRequest.getJourneyId()).getBus().getId(),
                        returnTheTicketRequest.getJourneyId()
                );
        seat.setUserContacts(null);
        seat.setStatus(Status.FREE);
        seatRepository.save(seat);

        Ticket ticket = ticketRepository
                .findByJourneyIdAndSeatIdAndTicketStatus(
                        returnTheTicketRequest.getJourneyId(),
                        seat.getId(),
                        TicketStatus.Actual);

        ticket.setTicketStatus(TicketStatus.Returned);
        ticketRepository.save(ticket);
        return seatMapper.seatToDto(seat);
    }

    @Override
    public int countSeatByStatusAndBusIdAndJourneyId(Status status, long id, long journeyId) {
        return seatRepository.countSeatByStatusAndBusIdAndJourneyId(status, id, journeyId);
    }

    @Override
    public SeatDto save(SeatDto seat) {
        return seatMapper.seatToDto(seatRepository.save(seatMapper.dtoToSeat(seat)));
    }

    @Override
    public List<SeatDto> generateSeats(GenerateSeatsRequestDto generateSeatsRequestDto) {
        List<SeatDto> seats = new ArrayList<>();
        log.info(generateSeatsRequestDto.getBus().getBusType());
        log.info(generateSeatsRequestDto.getBus().getBusType().getNumberOfSeats());
        for (int i = 1; i <= generateSeatsRequestDto.getBus().getBusType().getNumberOfSeats(); i++) {
            SeatDto seat = SeatDto.builder()
                    .number(i)
                    .status(Status.FREE)
                    .date(generateSeatsRequestDto.getDate())
                    .bus(generateSeatsRequestDto.getBus())
                    .journey(generateSeatsRequestDto.getJourneyDto())
                    .build();

            seats.add(seat);
            save(seat);
        }
        log.info(seats);
        return seats;
    }
}

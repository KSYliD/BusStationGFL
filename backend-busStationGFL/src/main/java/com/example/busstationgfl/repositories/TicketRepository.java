package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.Ticket;
import com.example.busstationgfl.entities.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUserIdAndTicketStatus(long id, TicketStatus ticketStatus);
    Ticket findById(long id);
    Ticket findByJourneyIdAndSeatIdAndTicketStatus(long journeyId, long seatId, TicketStatus ticketStatus);
}

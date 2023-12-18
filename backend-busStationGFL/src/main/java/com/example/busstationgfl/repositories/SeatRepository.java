package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.bus.Status;
import com.example.busstationgfl.entities.bus.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByBus_Id(long id);
    List<Seat> findAllByBusIdAndJourneyId(long id, long journeyId);
    Seat findById(long id);
    Seat save(Seat seat);
    Seat findByNumberAndBus_IdAndJourney_Id(long number, long busId, long journeyId);
    int countSeatByStatusAndBusIdAndJourneyId(Status status, long id, long journeyId);
}

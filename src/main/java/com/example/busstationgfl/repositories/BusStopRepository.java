package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.journey.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}

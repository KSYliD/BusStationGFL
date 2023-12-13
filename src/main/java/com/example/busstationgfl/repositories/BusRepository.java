package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.journey.bus.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

}

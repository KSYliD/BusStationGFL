package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.journey.Journey;
import com.example.busstationgfl.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
    List<Journey> getJourneysByBus_Driver(User driver);

    Journey save(Journey journey);

    void deleteJourneyById(Long id);

    Journey findById(long id);
}


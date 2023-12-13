package com.example.busstationgfl.services.journey;

import java.util.List;

import com.example.busstationgfl.entities.journey.BusStop;
import com.example.busstationgfl.entities.journey.City;
import com.example.busstationgfl.entities.journey.Journey;
import com.example.busstationgfl.entities.user.User;

public interface JourneyService {
    Journey getJourneysByBusStops(BusStop busStop);
    Journey getJourneyById(long id);
    List<Journey> getJourneysByBusStopsCity(City city);
    List<Journey> getJourneysByBus_Driver(User driver);
    Journey save(Journey journey);
    void deleteJourneyById(Long id);
}


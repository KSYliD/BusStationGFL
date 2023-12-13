package com.example.busstationgfl.services.journey;


import com.example.busstationgfl.entities.journey.BusStop;
import com.example.busstationgfl.entities.journey.City;
import com.example.busstationgfl.entities.journey.Journey;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.repositories.JourneyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneyServiceImpl implements JourneyService {
    JourneyRepository journeyRepository;

    @Override
    public Journey getJourneysByBusStops(BusStop busStop) {
//        return journeyRepository.getJourneysByBusStops(busStop);
        return null;
    }

    @Override
    public Journey getJourneyById(long id) {
        return journeyRepository.getJourneyById(id);
    }

    @Override
    public List<Journey> getJourneysByBusStopsCity(City city) {
//        return journeyRepository.getJourneysByBusStopsCity(city);
        return null;
    }

    @Override
    public List<Journey> getJourneysByBus_Driver(User driver) {
        return journeyRepository.getJourneysByBus_Driver(driver);
    }

    @Override
    public Journey save(Journey journey) {
        return journeyRepository.save(journey);
    }

    @Override
    public void deleteJourneyById(Long id) {
        journeyRepository.deleteJourneyById(id);
    }
}

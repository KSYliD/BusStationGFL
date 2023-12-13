package com.example.busstationgfl.controllers;

import com.example.busstationgfl.entities.journey.BusStop;
import com.example.busstationgfl.entities.journey.City;
import com.example.busstationgfl.entities.journey.Journey;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.services.journey.JourneyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journey")
public class JourneyController {
    JourneyService journeyService;

    @GetMapping("/{busStop}")
    Journey getJourneysByBusStops(@PathVariable BusStop busStop) {
//        return journeyService.getJourneysByBusStops(busStop);
        return null;
    }

    @GetMapping("/{id}")
    Journey getJourneyById(@PathVariable long id) {
        return journeyService.getJourneyById(id);
    }

    @GetMapping("/{city}")
    List<Journey> getJourneysByBusStopsCity(@PathVariable City city) {
//        return journeyService.getJourneysByBusStopsCity(city);
        return null;
    }

    @GetMapping("/{driver}")
    List<Journey> getJourneysByBus_Driver(@PathVariable User driver) {
        return journeyService.getJourneysByBus_Driver(driver);
    }

    @PostMapping
    Journey saveJourney(@RequestBody Journey journey) {
        return journeyService.save(journey);
    }

    @DeleteMapping("/{id}")
    void deleteJourneyById(@PathVariable Long id) {
        journeyService.deleteJourneyById(id);
    }

}

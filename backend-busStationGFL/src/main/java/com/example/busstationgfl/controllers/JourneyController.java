package com.example.busstationgfl.controllers;

import com.example.busstationgfl.dtos.journey.JourneyDto;
import com.example.busstationgfl.services.interfaces.journey.JourneyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/journeys")
public class JourneyController {
    private JourneyService journeyService;

    @GetMapping
    List<JourneyDto> findAll() {
        return journeyService.findAll();
    }

    @GetMapping("/{id}")
    JourneyDto getJourneyById(@PathVariable("id") Long id) {
        return journeyService.getJourneyById(id);
    }

    @PostMapping
    JourneyDto saveJourney(@RequestBody JourneyDto journey) {
        return journeyService.save(journey);
    }

    @DeleteMapping("/{id}")
    void deleteJourneyById(@PathVariable("id") Long id) {
        journeyService.deleteJourneyById(id);
    }

}

package com.example.busstationgfl.services.interfaces.journey;

import java.util.List;

import com.example.busstationgfl.dtos.journey.JourneyDto;

public interface JourneyService {
    JourneyDto getJourneyById(long id);
    JourneyDto save(JourneyDto journey);
    void deleteJourneyById(Long id);
    List<JourneyDto> findAll();
}


package com.example.busstationgfl.services.interfaces.journey;

import com.example.busstationgfl.entities.journey.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
}
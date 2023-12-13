package com.example.busstationgfl.services.journey;

import com.example.busstationgfl.entities.journey.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
    City findByName(String name);
}
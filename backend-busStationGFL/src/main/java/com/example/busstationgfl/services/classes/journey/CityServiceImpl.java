package com.example.busstationgfl.services.classes.journey;

import com.example.busstationgfl.entities.journey.City;
import com.example.busstationgfl.repositories.CityRepository;
import com.example.busstationgfl.services.interfaces.journey.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}

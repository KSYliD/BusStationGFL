package com.example.busstationgfl.controllers;

import com.example.busstationgfl.entities.journey.City;
import com.example.busstationgfl.services.interfaces.journey.CityService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
@Log4j2
public class CityController {
    private CityService cityService;

    @GetMapping
    List<City> findAll(){
        return cityService.findAll();
    }
}

package com.example.busstationgfl.controllers;

import com.example.busstationgfl.dtos.journey.bus.BusDto;
import com.example.busstationgfl.entities.bus.BusType;
import com.example.busstationgfl.services.interfaces.bus.BusService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/buses")
@Log4j2
public class BusController {

    private BusService busService;

    @GetMapping
    List<BusDto> findAll() {
        return busService.findAll();
    }

    @GetMapping("/{id}")
    BusDto findById(@PathVariable("id") long id) {
        return busService.findById(id);
    }

    @GetMapping("/types")
    List<BusType> bysTypes() {
        return busService.bysTypes();
    }

    @PostMapping
    BusDto save(@RequestBody BusDto bus) {
        return busService.save(bus);
    }
}


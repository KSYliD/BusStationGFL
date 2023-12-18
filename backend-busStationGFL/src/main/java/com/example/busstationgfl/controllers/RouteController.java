package com.example.busstationgfl.controllers;

import com.example.busstationgfl.entities.journey.Route;
import com.example.busstationgfl.services.interfaces.journey.RouteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/routes")
@Log4j2
public class RouteController {
    private RouteService routeService;

    @GetMapping
    List<Route> findAll(){
        return routeService.findAll();
    }

    @PostMapping()
    void save(@RequestBody Route route){
        routeService.save(route);
    }

}

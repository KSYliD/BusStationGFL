package com.example.busstationgfl.services.journey;

import com.example.busstationgfl.entities.journey.Route;

import java.util.List;

public interface RouteService {
    List<Route> findAll();
    void save(Route route);
}

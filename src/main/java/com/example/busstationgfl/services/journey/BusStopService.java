package com.example.busstationgfl.services.journey;

import com.example.busstationgfl.entities.journey.BusStop;

import java.util.List;

public interface BusStopService {
    void save(BusStop busStop);
    List<BusStop> find();
}

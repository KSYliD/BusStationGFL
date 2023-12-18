package com.example.busstationgfl.services.interfaces.bus;

import com.example.busstationgfl.dtos.journey.bus.BusDto;
import com.example.busstationgfl.entities.bus.BusType;

import java.util.List;

public interface BusService {
    List<BusDto> findAll();
    BusDto findById(long id);
    BusDto save(BusDto bus);
    List<BusType> bysTypes();
}

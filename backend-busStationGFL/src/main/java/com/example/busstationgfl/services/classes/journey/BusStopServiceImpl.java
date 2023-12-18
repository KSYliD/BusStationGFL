package com.example.busstationgfl.services.classes.journey;

import com.example.busstationgfl.entities.journey.BusStop;
import com.example.busstationgfl.repositories.BusStopRepository;
import com.example.busstationgfl.services.interfaces.journey.BusStopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BusStopServiceImpl implements BusStopService {

    private BusStopRepository busStopRepository;

    @Override
    public void save(BusStop busStop) {
        busStopRepository.save(busStop);
    }

}

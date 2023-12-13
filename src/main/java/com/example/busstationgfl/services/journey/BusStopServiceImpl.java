package com.example.busstationgfl.services.journey;

import com.example.busstationgfl.entities.journey.BusStop;
import com.example.busstationgfl.repositories.BusStopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusStopServiceImpl implements BusStopService{

    private BusStopRepository busStopRepository;

    @Override
    public void save(BusStop busStop) {
        busStopRepository.save(busStop);
    }

    @Override
    public List<BusStop> find() {
        return null;
    }
}

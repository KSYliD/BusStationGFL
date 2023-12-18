package com.example.busstationgfl.services.classes.journey;

import com.example.busstationgfl.entities.journey.Route;
import com.example.busstationgfl.repositories.BusStopRepository;
import com.example.busstationgfl.repositories.CityRepository;
import com.example.busstationgfl.repositories.RouteRepository;
import com.example.busstationgfl.services.interfaces.journey.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {
    private RouteRepository routeRepository;
    private BusStopRepository busStopRepository;
    private CityRepository cityRepository;

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public void save(Route route) {//TODO: unique route num
        for (int i = 0; i < route.getStops().size(); i++) {
            route.getStops().get(i).setCity(cityRepository.findByName(route.getStops().get(i).getCity().getName()));
        }
        busStopRepository.saveAll(route.getStops());
        routeRepository.save(route);
    }
}

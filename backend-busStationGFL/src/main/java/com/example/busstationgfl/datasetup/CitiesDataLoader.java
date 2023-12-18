package com.example.busstationgfl.datasetup;

import com.example.busstationgfl.entities.journey.City;
import com.example.busstationgfl.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class CitiesDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final CityRepository cityRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createCitiesIfNotFound();
    }


    public void createCitiesIfNotFound() {
        List<City> cities = getCities();
        cities.stream()
                .filter(city -> !cityRepository.existsByName(city.getName()))
                .forEach(cityRepository::save);
    }

    private List<City> getCities() {
        return List.of(
                new City("Kyiv"),
                new City("Lviv"),
                new City("Shepetivka"),
                new City("Mykolaiv"),
                new City("Ternopil`"),
                new City("Chernivtsi"),
                new City("Donetsk")
        );
    }
}

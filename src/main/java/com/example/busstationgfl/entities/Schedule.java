package com.example.busstationgfl.entities;

import com.example.busstationgfl.entities.journey.Journey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private long id;
    private List<Journey> journeyList;

}

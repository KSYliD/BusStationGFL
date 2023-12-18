package com.example.busstationgfl.entities.journey;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    @ManyToMany
    private List<BusStop> stops;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id = " + id + " number = "+ number +" stops = " + stops;
    }
}


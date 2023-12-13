package com.example.busstationgfl.entities.journey;

import com.example.busstationgfl.entities.journey.bus.Bus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Entity
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

}

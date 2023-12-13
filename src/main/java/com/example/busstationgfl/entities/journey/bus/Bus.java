package com.example.busstationgfl.entities.journey.bus;

import com.example.busstationgfl.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "seats_id")
    private Seats seats;
    @ManyToOne
    @JoinColumn(name = "driver_id") //TODO: @Transient?
    private User driver;

}

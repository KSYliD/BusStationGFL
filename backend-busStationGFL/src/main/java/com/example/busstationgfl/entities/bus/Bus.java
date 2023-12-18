package com.example.busstationgfl.entities.bus;

import com.example.busstationgfl.entities.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private User driver;
    private String licensePlate;
    @Enumerated(EnumType.STRING)
    private BusType busType;
}

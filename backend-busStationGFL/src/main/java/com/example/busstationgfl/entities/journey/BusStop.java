package com.example.busstationgfl.entities.journey;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BusStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String address;
    private String time;

}

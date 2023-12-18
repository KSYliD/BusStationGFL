package com.example.busstationgfl.entities.bus;

import com.example.busstationgfl.entities.journey.Journey;
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
@Builder
@ToString
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_contacts_id")
    private User userContacts;
    private String date;
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
    @ManyToOne
    @JoinColumn(name = "journey_id")
    private Journey journey;
}

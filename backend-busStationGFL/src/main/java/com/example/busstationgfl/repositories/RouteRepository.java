package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.journey.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}

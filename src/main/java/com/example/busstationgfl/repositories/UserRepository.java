package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(long id);
    List<User> findAll();
    User save(User user);
    void deleteById(long id);
    @Query
    Optional<User> findByEmail(String email);
}

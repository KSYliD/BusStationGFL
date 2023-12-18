package com.example.busstationgfl.repositories;

import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(long id);
    List<User> findAll();
    User save(User user);
    void deleteById(long id);
    User findByEmail(String email);
    List<User> findAllByRole(Role role);
    boolean existsByEmail(String email);
}

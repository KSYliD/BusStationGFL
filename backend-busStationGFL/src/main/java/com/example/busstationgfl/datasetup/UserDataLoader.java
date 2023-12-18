package com.example.busstationgfl.datasetup;

import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.repositories.RoleRepository;
import com.example.busstationgfl.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Log4j2
public class UserDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createCitiesIfNotFound();
    }


    public void createCitiesIfNotFound() {
        List<User> users = getUsers();
        users.stream()
                .filter(user -> !userRepository.existsByEmail(user.getEmail()))
                .forEach(userRepository::save);
    }

    private List<User> getUsers() {
        Set<Role> adminRole = new HashSet<>();
        adminRole.add(roleRepository.findByName("Admin"));
        Set<Role> driverRole = new HashSet<>();
        driverRole.add(roleRepository.findByName("Driver"));
        Set<Role> userRole = new HashSet<>();
        userRole.add(roleRepository.findByName("User"));
        return List.of(
                User.builder()
                        .firstName("Admin")
                        .secondName("Admin")
                        .email("admin@gmail.com")
                        .role(adminRole)
                        .phoneNumber("+380(68)240 5408")
                        .password(passwordEncoder.encode("12345678"))
                        .build(),
                User.builder()
                        .firstName("Driver")
                        .secondName("Driver")
                        .email("driver@gmail.com")
                        .role(driverRole)
                        .phoneNumber("+380(68)240 5408")
                        .password(passwordEncoder.encode("12345678"))
                        .build(),
                User.builder()
                        .firstName("User")
                        .secondName("User")
                        .email("user@gmail.com")
                        .role(userRole)
                        .phoneNumber("+380(68)240 5408")
                        .password(passwordEncoder.encode("12345678"))
                        .build(),
                User.builder()
                        .firstName("Stiven")
                        .secondName("Kovi")
                        .email("qwe@gmail.com")
                        .role(driverRole)
                        .phoneNumber("+380(68)240 5408")
                        .password(passwordEncoder.encode("12345678"))
                        .build(),
                User.builder()
                        .firstName("Ben")
                        .secondName("Hof")
                        .email("mail@gmail.com")
                        .role(driverRole)
                        .phoneNumber("+380(68)240 5408")
                        .password(passwordEncoder.encode("12345678"))
                        .build()

        );
    }
}

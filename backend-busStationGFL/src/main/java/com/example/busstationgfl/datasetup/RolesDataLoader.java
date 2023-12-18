package com.example.busstationgfl.datasetup;

import com.example.busstationgfl.repositories.RoleRepository;
import com.example.busstationgfl.entities.user.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class RolesDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createRolesIfNotFound();
    }


    public void createRolesIfNotFound() {
        List<Role> roles = getSampleRoles();
        roles.stream()
                .filter(role -> !roleRepository.existsByName(role.getName()))
                .forEach(roleRepository::save);
    }

    private List<Role> getSampleRoles() {
        return List.of(
                new Role("Admin"),
                new Role("Driver"),
                new Role("User")
        );
    }
}

package com.example.busstationgfl.services.classes.user;

import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.repositories.RoleRepository;
import com.example.busstationgfl.services.interfaces.user.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;


    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}

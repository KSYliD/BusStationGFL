package com.example.busstationgfl.services.interfaces.user;

import com.example.busstationgfl.entities.user.Role;

public interface RoleService {
    Role findByName(String name);

}

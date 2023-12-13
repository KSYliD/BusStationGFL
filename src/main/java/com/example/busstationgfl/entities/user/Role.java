package com.example.busstationgfl.entities.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

@Getter
public enum Role implements GrantedAuthority {
    User, Admin, Driver;

    @Override
    public String getAuthority() {
        return Arrays.toString(Role.values());
    }
}

package com.example.busstationgfl.services.classes;


import com.example.busstationgfl.dtos.auth.AuthenticationRequest;
import com.example.busstationgfl.dtos.auth.AuthenticationResponse;
import com.example.busstationgfl.dtos.requests.RegisterRequest;
import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.exception.FailedToAccessException;
import com.example.busstationgfl.mappers.UserMapper;
import com.example.busstationgfl.repositories.RoleRepository;
import com.example.busstationgfl.repositories.UserRepository;
import com.example.busstationgfl.services.interfaces.AuthenticationService;
import com.example.busstationgfl.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final ValidationUtils validationUtils;
    private final RoleRepository roleRepository;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        validationUtils.validate(request);
        User user = userMapper.registerRequestToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("User"));
        user.setRole(roles);
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse auth(AuthenticationRequest request) {
        validationUtils.validate(request);
        User user = userRepository.findByEmail(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new FailedToAccessException("Password does not match");
        }
        new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(user)
                .build();
    }
}

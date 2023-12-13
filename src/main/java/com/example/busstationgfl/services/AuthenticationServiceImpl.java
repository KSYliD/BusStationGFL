package com.example.busstationgfl.services;


import com.example.busstationgfl.dtos.AuthenticationRequest;
import com.example.busstationgfl.dtos.AuthenticationResponse;
import com.example.busstationgfl.dtos.RegisterRequest;
import com.example.busstationgfl.entities.user.Role;
import com.example.busstationgfl.entities.user.User;
import com.example.busstationgfl.exception.FailedToAccessException;
import com.example.busstationgfl.mappers.UserMapper;
import com.example.busstationgfl.repositories.UserRepository;
import com.example.busstationgfl.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final ValidationUtils validationUtils;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        validationUtils.validate(request);
        User user = userMapper.registerRequestToUser(request);
        user.setRole(Role.User);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse auth(AuthenticationRequest request) {
        validationUtils.validate(request);
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new FailedToAccessException("UserDto not found by email"));
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
                .build();
    }
}

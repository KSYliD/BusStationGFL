package com.example.busstationgfl.services;


import com.example.busstationgfl.dtos.AuthenticationRequest;
import com.example.busstationgfl.dtos.AuthenticationResponse;
import com.example.busstationgfl.dtos.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse auth(AuthenticationRequest request);
}

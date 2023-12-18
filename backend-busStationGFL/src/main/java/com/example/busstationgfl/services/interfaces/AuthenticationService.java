package com.example.busstationgfl.services.interfaces;


import com.example.busstationgfl.dtos.auth.AuthenticationRequest;
import com.example.busstationgfl.dtos.auth.AuthenticationResponse;
import com.example.busstationgfl.dtos.requests.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse auth(AuthenticationRequest request);
}

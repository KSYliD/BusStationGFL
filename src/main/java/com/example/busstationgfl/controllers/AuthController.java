package com.example.busstationgfl.controllers;


import com.example.busstationgfl.dtos.AuthenticationRequest;
import com.example.busstationgfl.dtos.AuthenticationResponse;
import com.example.busstationgfl.dtos.RegisterRequest;
import com.example.busstationgfl.services.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;


    @PostMapping("/register")
    @SecurityRequirements()
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    @SecurityRequirements()
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.auth(request));
    }
}

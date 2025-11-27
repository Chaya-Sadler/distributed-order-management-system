package com.chayasadler.authservice.controller;


import com.chayasadler.authservice.model.AuthRequest;
import com.chayasadler.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody AuthRequest authRequest) {

       return authService.registerCustomer(authRequest);

    }

}

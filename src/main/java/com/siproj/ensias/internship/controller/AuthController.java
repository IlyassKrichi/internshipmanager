package com.siproj.ensias.internship.controller;

// AuthController.java

import com.siproj.ensias.internship.Dto.AuthRequest;
import com.siproj.ensias.internship.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        boolean isAuthenticated = authService.authenticateEtudiant(authRequest.getEmail(), authRequest.getPassword());
        System.out.println(authRequest.getEmail());
        System.out.println(authRequest.getPassword());

        if (isAuthenticated) {
            System.out.println("OK");
            return ResponseEntity.ok("{\"success\":true}");

        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}

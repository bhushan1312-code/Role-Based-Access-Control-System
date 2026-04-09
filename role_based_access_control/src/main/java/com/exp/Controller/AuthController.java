package com.exp.Controller;

import com.exp.Dto.LoginRequest;
import com.exp.Dto.RegisterRequest;
import com.exp.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        service.register(registerRequest);
        return ResponseEntity.ok("User Registered Successfully");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = service.login(loginRequest);
        return ResponseEntity.ok(token);
    }
}
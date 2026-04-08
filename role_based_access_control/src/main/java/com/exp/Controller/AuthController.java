package com.exp.Controller;


import com.exp.Dto.LoginRequest;
import com.exp.Dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exp.Service.AuthService;
import com.exp.UserEntity.User;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        service.register(registerRequest);
        return "User Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest  loginRequest) {
        service.login(loginRequest);
        return "User Login";
    }




}

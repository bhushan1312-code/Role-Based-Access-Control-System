package com.exp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class TestController {

    @Autowired
    private PasswordEncoder encoder;

        @GetMapping("/public")
        public String publicApi() {
            return "Public API";
        }

        @PreAuthorize("hasRole('USER')")
        @GetMapping("/user")
        public String userApi() {
            return "User API";
        }

        @PreAuthorize("hasRole('ADMIN')")
        @GetMapping("/admin")
        public String adminApi() {
            return "Admin API";
        }
    }



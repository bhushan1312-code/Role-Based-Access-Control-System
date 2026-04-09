package com.exp.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

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
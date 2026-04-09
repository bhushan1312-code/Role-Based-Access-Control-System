package com.exp.Service;

import com.exp.Dao.UserRepository;
import com.exp.Dto.LoginRequest;
import com.exp.Dto.RegisterRequest;
import com.exp.Security.JwtUtil;
import com.exp.UserEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder encoder;



    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder();


    public void register(RegisterRequest registerRequest) {

        User user = new User();
        user.setName(registerRequest.name);
        user.setEmail(registerRequest.email);
        user.setPassword(encoder.encode(registerRequest.password));
        user.setRole(registerRequest.role);


        userRepository.save(user);

    }


    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(loginRequest.password, user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail(), user.getRole());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}



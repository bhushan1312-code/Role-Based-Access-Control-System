package com.exp.Security;


import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import java.util.Date;

@Component

public class JwtUtil {

        private String SECRET = "mysecretkey";
        public String generateToken(String email, String role) {

            return Jwts.builder()
                    .setSubject(email)
                    .claim("role", role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                    .signWith(SignatureAlgorithm.HS256, SECRET)
                    .compact();
        }

        public String extractEmail(String token) {
            return Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        }
    }

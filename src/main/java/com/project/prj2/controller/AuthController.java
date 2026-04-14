package com.project.prj2.controller;

import com.project.prj2.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username) {
        String role = username.equals("admin") ? "ADMIN" : "USER";
        return jwtUtil.generateToken(username, role);
    }
}
package com.example.demo.feature.authentication;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        System.out.println("ddddddddddddddd = " + request);
        return authService.register(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return authService.login(request.getUsername(), request.getPassword());
    }

    @Data
    public static class AuthRequest {
        private String username;
        private String password;
    }
}
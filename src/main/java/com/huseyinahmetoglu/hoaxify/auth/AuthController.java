package com.huseyinahmetoglu.hoaxify.auth;

import com.huseyinahmetoglu.hoaxify.user.User;
import com.huseyinahmetoglu.hoaxify.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/api/1.0/auth")
    ResponseEntity<?> handleAuthentication(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }
}

package com.huseyinahmetoglu.hoaxify.auth;

import com.huseyinahmetoglu.hoaxify.error.ApiError;
import com.huseyinahmetoglu.hoaxify.user.User;
import com.huseyinahmetoglu.hoaxify.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/api/1.0/auth")
    ResponseEntity<?> handleAuthentication(@RequestHeader(name = "Authorization", required = false) String authorization) {
        if (authorization == null) {
            ApiError apiError = new ApiError(401, "Unauthorized request!", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }
        String base64encoded = authorization.split("Basic ")[1];
        String decoded = new String(Base64.getDecoder().decode(base64encoded));
        String[] parts = decoded.split(":");
        String username = parts[0];
        String password = parts[1];
        User inDB = userRepository.findByUsername(username);
        if (inDB == null) {
            ApiError apiError = new ApiError(401, "Unauthorized request!", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }
        String hashedPassword = inDB.getPassword();
        if (!passwordEncoder.matches(password, hashedPassword)) {
            ApiError apiError = new ApiError(401, "Unauthorized request!", "/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
        }
        return ResponseEntity.ok().build();
    }
}

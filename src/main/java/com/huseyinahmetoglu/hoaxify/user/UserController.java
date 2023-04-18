package com.huseyinahmetoglu.hoaxify.user;

import com.huseyinahmetoglu.hoaxify.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/1.0/users")
    public GenericResponse create(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User created!");
    }

}

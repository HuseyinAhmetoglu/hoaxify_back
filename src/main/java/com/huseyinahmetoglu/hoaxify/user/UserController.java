package com.huseyinahmetoglu.hoaxify.user;

import com.huseyinahmetoglu.hoaxify.shared.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/1.0/users")
    public GenericResponse create(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User created!");
    }

    @GetMapping("/api/1.0/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}

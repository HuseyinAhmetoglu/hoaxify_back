package com.huseyinahmetoglu.hoaxify.controller;

import com.huseyinahmetoglu.hoaxify.entity.User;
import com.huseyinahmetoglu.hoaxify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/1.0/users")
    public void create(@RequestBody User user) {
        userService.save(user);
    }
}

package com.huseyinahmetoglu.hoaxify.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/api/1.0/users")
    public void create(@RequestBody String body) {
        logger.info(body);
    }
}

package com.huseyinahmetoglu.hoaxify.service;


import com.huseyinahmetoglu.hoaxify.entity.User;
import com.huseyinahmetoglu.hoaxify.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}

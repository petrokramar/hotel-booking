package com.hotelbooking.service.impl;

import com.hotelbooking.entity.User;
import com.hotelbooking.exceptions.DataNotFoundException;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) repository.findAll();
        return users;
    }

    @Override
    public User getUser(String username) {
        User user = repository.findOne(username);
        return Optional.ofNullable(user).orElseThrow(() ->
                new DataNotFoundException(String.format("User username= %s not found", username)));
    }
}

package com.example.hubertspring.service;

import com.example.hubertspring.controller.mapper.UserMapper;
import com.example.hubertspring.entity.UserEntity;
import com.example.hubertspring.model.Todo;
import com.example.hubertspring.model.User;
import com.example.hubertspring.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;
    private UserMapper userMapper;

    public UserEntity registerUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    public Optional<User> getOne(Long id) {
        return userRepo.findById(id)
                .map(userMapper::toModel);
    }

    public void deleteUserById(Long userId) {
        userRepo.deleteById(userId);
    }

    public Optional<List<Todo>> getTodos(Long userId) {
        return getOne(userId)
                .map(User::getTodos);
    }

    public Optional<User> getUser(Long userId) {
        return userRepo.findById(userId)
                .map(userMapper::toModel);
    }
}

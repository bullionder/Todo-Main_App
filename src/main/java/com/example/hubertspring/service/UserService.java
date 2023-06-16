package com.example.hubertspring.service;

import com.example.hubertspring.api.controller.mapper.UserMapper;
import com.example.hubertspring.api.dto.UserDto;
import com.example.hubertspring.entity.UserEntity;
import com.example.hubertspring.model.Todo;
import com.example.hubertspring.model.User;
import com.example.hubertspring.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserEntity registerUser(UserDto userDto) {
        return userRepo.save(userMapper.toEntity(userDto));
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

package com.example.hubertspring.api.controller;

import com.example.hubertspring.api.dto.UserDto;
import com.example.hubertspring.entity.UserEntity;
import com.example.hubertspring.model.Todo;
import com.example.hubertspring.model.User;
import com.example.hubertspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/get-todos/{userId}")
    public Optional<List<Todo>> getTodos(@PathVariable Long userId) {
        return userService.getTodos(userId);
    }

    @GetMapping("/get-one/{userId}")
    public Optional<User> getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
}

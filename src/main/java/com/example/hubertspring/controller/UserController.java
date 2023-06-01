package com.example.hubertspring.controller;

import com.example.hubertspring.entity.UserEntity;
import com.example.hubertspring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserEntity userEntity) {
        try {
            return ResponseEntity.ok(userService.registerUser(userEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request exception.");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User deleted.");
    }

    @GetMapping("/get-todos/{userId}")
    public ResponseEntity getTodos(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getTodos(userId));
    }

    @GetMapping("/get-one/{userId}")
    public ResponseEntity getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}

package com.example.hubertspring.controller.mapper;

import com.example.hubertspring.entity.UserEntity;
import com.example.hubertspring.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final TodoMapper todoMapper;

    public User toModel(UserEntity userEntity) {
        return User.builder()
                    .id(userEntity.getUserId())
                    .username(userEntity.getUsername())
                    .todos(userEntity.getTodos()
                                    .stream()
                                    .map(todoMapper::toModel)
                                    .collect(Collectors.toList()))
                    .build();
    }
}

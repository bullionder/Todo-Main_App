package com.example.hubertspring.api.controller.mapper;

import com.example.hubertspring.api.dto.TodoDto;
import com.example.hubertspring.api.dto.UserDto;
import com.example.hubertspring.entity.TodoEntity;
import com.example.hubertspring.entity.UserEntity;
import com.example.hubertspring.model.Todo;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TodoMapper {
    public Todo toModel(TodoEntity todoEntity) {
        return Todo.builder()
                .id(todoEntity.getId())
                .title(todoEntity.getTodoTitle())
                .completed(todoEntity.isCompleted())
                .description(todoEntity.getDescription())
                .build();
    }

    public TodoEntity toEntity(TodoDto todoDto) {
        return TodoEntity.builder()
                .todoTitle(todoDto.getTodoTitle())
                .description(todoDto.getTodoDescription())
                .completed(false)
                .build();
    }
}

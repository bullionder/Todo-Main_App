package com.example.hubertspring.controller.mapper;

import com.example.hubertspring.entity.TodoEntity;
import com.example.hubertspring.model.Todo;
import org.springframework.stereotype.Component;

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
}

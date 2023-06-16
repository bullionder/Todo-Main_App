package com.example.hubertspring.service;

import com.example.hubertspring.api.controller.mapper.TodoMapper;
import com.example.hubertspring.api.dto.TodoDto;
import com.example.hubertspring.entity.TodoEntity;
import com.example.hubertspring.model.Todo;
import com.example.hubertspring.repository.TodoRepo;
import com.example.hubertspring.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoMapper todoMapper;
    private final TodoRepo todoRepo;
    private final UserRepo userRepo;


    public Optional<Todo> createTodo(TodoDto todoDto, Long userId) {
        TodoEntity todoEntity = todoMapper.toEntity(todoDto);
        return userRepo.findById(userId)
                .map(user -> {
                    todoEntity.setUser(user);
                    return todoEntity;
                })
                .map(todoRepo::save)
                .map(todoMapper::toModel);
    }

    public Optional<Todo> completeTodo(Long id) {
        return todoRepo.findById(id)
                .map(TodoEntity::completeTodo)
                .map(todoMapper::toModel);
    }

    public String deleteTodoByItsTitle(Long userId, String todoTitle) {
        if (!userRepo.existsById(userId) || todoRepo.findByTodoTitle(todoTitle) == null) {
            throw new IllegalArgumentException("Todo not found.");
        }
        todoRepo.deleteByTodoTitleAndUserId(userId, todoTitle);
        return todoTitle;
    }

    public void deleteAllTodos(Long userId) {
        todoRepo.deleteAllWithUserId(userId);
    }

    public void deleteTodoById(Long todoId) {
        todoRepo.deleteById(todoId);
    }
}

package com.example.hubertspring.api.controller;

import com.example.hubertspring.api.dto.TodoDto;
import com.example.hubertspring.entity.TodoEntity;
import com.example.hubertspring.model.Todo;
import com.example.hubertspring.service.TodoService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/create-todo/{userId}")
    public Optional<Todo> createTodo(@RequestBody TodoDto todoDto,
                                     @PathVariable Long userId) {
        return todoService.createTodo(todoDto, userId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete-all")
    public void deleteAllTodos(@ApiParam(name = "userId", value = "Id of user to delete all todos") @RequestParam Long userId) {
        todoService.deleteAllTodos(userId);
    }

    @PutMapping("/complete-todo/{todoId}")
    public ResponseEntity<Todo> completeTodo(@PathVariable Long todoId) {
        return ResponseEntity.of(todoService.completeTodo(todoId));
    }

    @DeleteMapping
    public void deleteTodo(@ApiParam(name = "todoId", value = "Id of todo to be deleted") @RequestParam Long todoId) {
        todoService.deleteTodoById(todoId);
    }
}

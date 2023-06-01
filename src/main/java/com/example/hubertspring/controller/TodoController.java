package com.example.hubertspring.controller;

import com.example.hubertspring.entity.TodoEntity;
import com.example.hubertspring.model.Todo;
import com.example.hubertspring.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping("/create-todo/{userId}")
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @PathVariable Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request exception.");
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity deleteAllTodos(@RequestParam Long userId) {
        try {
            todoService.deleteAllTodos(userId);
            return ResponseEntity.ok("Todos deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request exception.");
        }
    }

    //todo to be deleted
    @PostMapping("/delete/{userId}")
    public ResponseEntity deleteTodo(@RequestBody TodoEntity todoEntity,
                                     @PathVariable Long userId) {
        try {
            return ResponseEntity.ok(todoService.deleteTodoByItsTitle(userId, todoEntity.getTodoTitle()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request exception.");
        }
    }
    @PutMapping("/complete-todo/{todoId}")
    public ResponseEntity<Todo> completeTodo(@PathVariable Long todoId) {
        return ResponseEntity.of(todoService.completeTodo(todoId));
    }

    @DeleteMapping()
    public ResponseEntity deleteTodo(@RequestParam Long todoId) {
        try {
            todoService.deleteTodoById(todoId);
            return ResponseEntity.ok("Todo deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request exception.");
        }
    }
}

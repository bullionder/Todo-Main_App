package com.example.hubertspring.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class User {
    private String username;
    private Long id;
    private List<Todo> todos;
}

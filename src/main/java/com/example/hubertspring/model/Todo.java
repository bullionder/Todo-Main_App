package com.example.hubertspring.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
    private String description;
}

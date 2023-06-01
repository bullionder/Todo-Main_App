package com.example.hubertspring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todoTitle;
    private boolean completed;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TodoEntity completeTodo() {
        this.completed = true;
        return this;
    }
}

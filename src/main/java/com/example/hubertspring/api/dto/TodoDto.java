package com.example.hubertspring.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TodoDto implements Serializable {
    private String todoTitle;
    private String todoDescription;
}
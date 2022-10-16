package com.example.cupcat.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class Model {
    private int id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int status = 1;
}

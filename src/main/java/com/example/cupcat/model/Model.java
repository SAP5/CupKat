package com.example.cupcat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    private int id;
    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();
    private int status = 1;

    public void setCreated_at() {
        this.created_at = LocalDateTime.now();
    }

    public void setUpdated_at(){
        this.updated_at = LocalDateTime.now();
    }

    public void setStatus(){
        this.status = 1;
    }

    public void setId(int id) {
        this.id = id;
    }
}

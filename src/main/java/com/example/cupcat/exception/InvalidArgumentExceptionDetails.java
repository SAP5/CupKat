package com.example.cupcat.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class InvalidArgumentExceptionDetails {
    private String title;
    private String message;
    private int status;
    private String fields;
    private String fieldsMessage;
    private LocalDateTime timestamp;
}

package com.example.cupcat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Objeto não encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistingException.class)
    public ResponseEntity<ExceptionDetails> handlerAlreadyExistingException(AlreadyExistingException ex){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Dados já cadastrados")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<InvalidArgumentExceptionDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        return buildInvalidArgumentException(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<InvalidArgumentExceptionDetails> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FieldError> errors = ex.getConstraintViolations().stream()
                .map(constraintViolation -> new FieldError(constraintViolation.getRootBeanClass().getName(),
                        constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()))
                .collect(Collectors.toList());

        return buildInvalidArgumentException(errors);
    }

    private ResponseEntity<InvalidArgumentExceptionDetails> buildInvalidArgumentException(List<FieldError> errors){
        return new ResponseEntity<>(InvalidArgumentExceptionDetails.builder()
                .title("Parametros inválidos")
                .message("Os campos estão inválidos")
                .status(HttpStatus.BAD_REQUEST.value())
                .fields(errors.stream()
                        .map(err-> err.getField())
                        .collect(Collectors.joining(", ")))
                .fieldsMessage(errors.stream()
                        .map(err -> err.getDefaultMessage())
                        .collect(Collectors.joining(", ")))
                .timestamp(LocalDateTime.now())
                .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}

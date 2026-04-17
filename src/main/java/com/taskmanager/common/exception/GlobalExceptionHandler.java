package com.taskmanager.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskStateException.class)
    public ResponseEntity<ErrorResponse> handleTaskState(TaskStateException ex) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                400,
                "TASK_STATE_ERROR",
                ex.getMessage()
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(TaskNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                404,
                "NOT_FOUND",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
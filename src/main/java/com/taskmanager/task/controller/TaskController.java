package com.taskmanager.task.controller;

import com.taskmanager.task.dto.CreateTaskRequest;
import com.taskmanager.task.dto.TaskResponse;
import com.taskmanager.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody CreateTaskRequest request
    ) {
        return ResponseEntity.ok(taskService.createTask(request));
    }

    @GetMapping
    public ResponseEntity<Page<TaskResponse>> getTasks(
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable
    ) {
        return ResponseEntity.ok(taskService.getTasks(pageable));
    }
}
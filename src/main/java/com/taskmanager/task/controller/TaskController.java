package com.taskmanager.task.controller;

import com.taskmanager.task.domain.TaskStatus;
import com.taskmanager.task.dto.CreateTaskRequest;
import com.taskmanager.task.dto.TaskResponse;
import com.taskmanager.task.dto.UpdateTaskRequest;
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
            @RequestParam(required = false) String title,
            @RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false) Long assignedUserId,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                taskService.getTasks(title, status, assignedUserId, pageable)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @RequestBody UpdateTaskRequest request
    ) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }
}
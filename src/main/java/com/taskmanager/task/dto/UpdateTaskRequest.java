package com.taskmanager.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskRequest {

    private String title;
    private String description;
    private Long assignedUserId;

    // getters/setters
}
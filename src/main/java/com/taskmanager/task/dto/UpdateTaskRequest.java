package com.taskmanager.task.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskRequest {

    @Size(min = 3, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    private Long assignedUserId;
}
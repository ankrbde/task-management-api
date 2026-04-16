package com.taskmanager.task.dto;

import lombok.Getter;

@Getter
public class TaskResponse {

    private Long id;
    private String title;
    private String description;

    public TaskResponse(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // getters
}
package com.taskmanager.task.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;

    String description;

    @Enumerated(EnumType.STRING)
    TaskStatus status;

    long assignedUserId;

    private LocalDateTime createdAt;
}

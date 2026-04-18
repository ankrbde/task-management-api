package com.taskmanager.task.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String title;

    String description;

    @Enumerated(EnumType.STRING)
    TaskStatus status;

    long assignedUserId;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = TaskStatus.TODO;
        }
        createdAt = LocalDateTime.now();
    }
}

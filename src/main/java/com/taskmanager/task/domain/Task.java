package com.taskmanager.task.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;

    String description;

    @Enumerated(EnumType.STRING)
    TaskStatus status;

    long assignedUserId;
}

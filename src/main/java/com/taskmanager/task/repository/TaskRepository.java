package com.taskmanager.task.repository;

import com.taskmanager.task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

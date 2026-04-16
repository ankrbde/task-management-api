package com.taskmanager.task.service;

import com.taskmanager.task.domain.Task;
import com.taskmanager.task.domain.TaskStatus;
import com.taskmanager.task.dto.CreateTaskRequest;
import com.taskmanager.task.dto.TaskResponse;
import com.taskmanager.task.repository.TaskRepository;
import com.taskmanager.task.repository.TaskSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(CreateTaskRequest request) {

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(TaskStatus.TODO);
        task.setCreatedAt(LocalDateTime.now());

        Task saved = taskRepository.save(task);

        return new TaskResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getDescription()
        );
    }


    public Page<TaskResponse> getTasks(
            String title,
            TaskStatus status,
            Long assignedUserId,
            Pageable pageable
    ) {

        Specification<Task> spec = Specification
                .where(TaskSpecification.hasTitle(title))
                .and(TaskSpecification.hasStatus(status))
                .and(TaskSpecification.hasAssignedUser(assignedUserId));

        return taskRepository.findAll(spec, pageable)
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription()
                ));
    }
}
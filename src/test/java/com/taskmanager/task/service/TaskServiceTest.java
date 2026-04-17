package com.taskmanager.task.service;

import com.taskmanager.common.exception.TaskNotFoundException;
import com.taskmanager.common.exception.TaskStateException;
import com.taskmanager.task.domain.Task;
import com.taskmanager.task.domain.TaskStatus;
import com.taskmanager.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private final TaskRepository repository = Mockito.mock(TaskRepository.class);
    private final TaskService service = new TaskService(repository);

    @Test
    void shouldThrowExceptionWhenTransitionFromDone() {

        Task task = new Task();
        task.setId(1L);
        task.setStatus(TaskStatus.DONE);

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(task));

        assertThrows(TaskStateException.class, () ->
                service.updateStatus(1L, TaskStatus.IN_PROGRESS)
        );
    }

    @Test
    void shouldAllowTransitionFromTodoToInProgress() {

        TaskRepository repository = Mockito.mock(TaskRepository.class);
        TaskService service = new TaskService(repository);

        Task task = new Task();
        task.setId(1L);
        task.setStatus(TaskStatus.TODO);

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(task));

        Mockito.when(repository.save(Mockito.any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        service.updateStatus(1L, TaskStatus.IN_PROGRESS);

        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }

    @Test
    void shouldThrowWhenTaskNotFound() {

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () ->
                service.updateStatus(1L, TaskStatus.IN_PROGRESS)
        );
    }
}
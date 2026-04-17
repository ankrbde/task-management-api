package com.taskmanager.task.service;

import com.taskmanager.task.domain.Task;
import com.taskmanager.task.domain.TaskStatus;
import com.taskmanager.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldThrowExceptionWhenTransitionFromDone() {

        TaskRepository repository = Mockito.mock(TaskRepository.class);
        TaskService service = new TaskService(repository);

        Task task = new Task();
        task.setId(1L);
        task.setStatus(TaskStatus.DONE);

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(task));

        assertThrows(RuntimeException.class, () ->
                service.updateStatus(1L, TaskStatus.IN_PROGRESS)
        );
    }
}
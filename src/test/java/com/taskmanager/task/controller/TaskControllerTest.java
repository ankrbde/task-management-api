package com.taskmanager.task.controller;

import com.taskmanager.common.exception.TaskNotFoundException;
import com.taskmanager.task.dto.TaskResponse;
import com.taskmanager.task.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
@AutoConfigureMockMvc(addFilters = false)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void shouldReturnTaskById() throws Exception {

        when(taskService.getTaskById(1L))
                .thenReturn(new TaskResponse(1L, "Test Task", "Test Desc"));

        mockMvc.perform(get("/api/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Test Task"))
                .andExpect(jsonPath("$.description").value("Test Desc"));
    }

    @Test
    void shouldReturn404WhenTaskNotFound() throws Exception {

        when(taskService.getTaskById(1L))
                .thenThrow(new TaskNotFoundException("Task not found"));

        mockMvc.perform(get("/api/tasks/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("NOT_FOUND"));
    }
}
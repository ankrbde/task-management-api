package com.taskmanager.common.service;

import com.taskmanager.common.dto.HealthResponse;
import org.springframework.stereotype.Service;

@Service
public class HealthService {
    public String getStatus() {
        return "UP";
    }
    public HealthResponse getHealth() {
        return new HealthResponse("UP");
    }
}

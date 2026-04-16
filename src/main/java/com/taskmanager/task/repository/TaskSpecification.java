package com.taskmanager.task.repository;

import com.taskmanager.task.domain.Task;
import com.taskmanager.task.domain.TaskStatus;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

    public static Specification<Task> hasTitle(String title) {
        return (root, query, cb) ->
                title == null ? null :
                        cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Task> hasStatus(TaskStatus status) {
        return (root, query, cb) ->
                status == null ? null :
                        cb.equal(root.get("status"), status);
    }

    public static Specification<Task> hasAssignedUser(Long userId) {
        return (root, query, cb) ->
                userId == null ? null :
                        cb.equal(root.get("assignedUserId"), userId);
    }
}
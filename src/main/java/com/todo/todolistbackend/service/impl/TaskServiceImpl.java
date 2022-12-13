package com.todo.todolistbackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.todo.todolistbackend.domain.model.Task;
import com.todo.todolistbackend.domain.model.TaskRepository;
import com.todo.todolistbackend.service.TaskService;

public class TaskServiceImpl extends BaseCrudService<Task, TaskRepository> implements TaskService {
    @Autowired
        public TaskServiceImpl(TaskRepository repository) {
            super(repository);
        }
}

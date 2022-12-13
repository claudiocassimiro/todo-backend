package com.todo.todolistbackend.domain.model;

import com.todo.todolistbackend.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "tasks")
public class Task extends BaseEntity {
    
    private String todo;
    @Column(length = 500)
    private String description;
    private Boolean isFinished;

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }
}

package com.todo.todolistbackend.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todolistbackend.domain.BaseEntity;
import com.todo.todolistbackend.service.CrudService;
import com.todo.todolistbackend.service.exception.BusinessException;
import com.todo.todolistbackend.service.exception.NoContentException;

public class BaseCrudService<E extends BaseEntity, T extends JpaRepository<E, Long>> implements CrudService<E> {
    protected T repository;

    public BaseCrudService(T repository) {
        this.repository = repository; 
    }

    @Override
    public void insert(E entity) {
        this.repository.save(entity);
    }

    @Override
    public List<E> findAll() {
        return this.repository.findAll();
    }

    @Override
    public E findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new NoContentException());
    }

    @Override
    public void update(Long id, E entity) {
        E entityId = this.findById(id);

        if (entityId.getId().equals(entity.getId())) {
            this.repository.save(entity);
        } else {
            throw new BusinessException("The ids for update should be equals.");
        }
    }

    @Override
    public void delete(Long id) {
        E entityId = this.findById(id);
        this.repository.delete(entityId);
    }
}

package com.app.xplore.service.impl;

import com.app.xplore.model.BaseEntity;
import com.app.xplore.repository.BaseRepository;
import com.app.xplore.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {

    protected abstract BaseRepository<T, ID> getRepository();

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public T update(ID id, T entity) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        // Ensure the ID is set to the entity being updated
        entity.setId(id);
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        getRepository().deleteById(id);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return getRepository().count();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(ID id) {
        return getRepository().existsById(id);
    }
}

package com.app.xplore.service;

import com.app.xplore.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity, ID extends Serializable> {
    List<T> findAll();
    
    Page<T> findAll(Pageable pageable);
    
    Optional<T> findById(ID id);
    
    T save(T entity);
    
    T update(ID id, T entity);
    
    void delete(ID id);
    
    void delete(T entity);
    
    long count();
    
    boolean exists(ID id);
}

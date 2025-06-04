package com.app.xplore.repository;

import com.app.xplore.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
    // Common repository methods can be added here
    // For example:
    // List<T> findAllActive();
    // void softDelete(ID id);
}

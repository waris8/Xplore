package com.app.xplore.service;

import com.app.xplore.models.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ArtistService extends BaseService<Artist, String> {
    // Add any artist-specific methods here
    Optional<Artist> findByEmail(String email);
    Page<Artist> findByNameContaining(String name, Pageable pageable);
}

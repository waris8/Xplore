package com.app.xplore.repository;

import com.app.xplore.model.events.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends BaseRepository<Artist, String> {
    Optional<Artist> findByEmail(String email);
    Page<Artist> findByNameContaining(String name, Pageable pageable);
}

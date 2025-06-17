package com.app.xplore.service.impl;

import com.app.xplore.models.Artist;
import com.app.xplore.repository.ArtistRepository;
import com.app.xplore.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl extends BaseServiceImpl<Artist, String> implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    protected BaseRepository<Artist, String> getRepository() {
        return artistRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Artist> findByEmail(String email) {
        return artistRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Artist> findByNameContaining(String name, Pageable pageable) {
        return artistRepository.findByNameContaining(name, pageable);
    }
}

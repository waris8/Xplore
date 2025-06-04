package com.app.xplore.controller;

import com.app.xplore.dto.request.ArtistRequest;
import com.app.xplore.dto.response.ArtistResponse;
import com.app.xplore.mapper.ArtistMapper;
import com.app.xplore.models.Artist;
import com.app.xplore.service.ArtistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/artists")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @PostMapping
    public ResponseEntity<ArtistResponse> createArtist(@Valid @RequestBody ArtistRequest request) {
        Artist artist = artistMapper.toEntity(request);
        Artist savedArtist = artistService.save(artist);
        ArtistResponse response = artistMapper.toResponse(savedArtist);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedArtist.getArtistId())
                .toUri();
                
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> getArtistById(@PathVariable String id) {
        return artistService.findById(id)
                .map(artistMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<ArtistResponse>> getAllArtists(Pageable pageable) {
        Page<ArtistResponse> artists = artistService.findAll(pageable)
                .map(artistMapper::toResponse);
        return ResponseEntity.ok(artists);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistResponse> updateArtist(
            @PathVariable String id,
            @Valid @RequestBody ArtistRequest request) {
        return artistService.findById(id)
                .map(artist -> {
                    artistMapper.updateEntityFromRequest(request, artist);
                    Artist updatedArtist = artistService.save(artist);
                    return ResponseEntity.ok(artistMapper.toResponse(updatedArtist));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable String id) {
        artistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

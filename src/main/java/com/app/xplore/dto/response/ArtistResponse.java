package com.app.xplore.dto.response;

import com.app.xplore.models.Gender;

import java.time.LocalDateTime;

public record ArtistResponse(
    String artistId,
    String name,
    String profession,
    String bio,
    Gender gender,
    String contactInfo,
    boolean isActive,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}

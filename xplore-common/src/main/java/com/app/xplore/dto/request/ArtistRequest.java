package com.app.xplore.dto.request;

import com.app.xplore.models.Gender;

public record ArtistRequest(
    String name,
    String profession,
    String bio,
    Gender gender,
    String contactInfo
) {}

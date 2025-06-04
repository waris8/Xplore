package com.app.xplore.dto.response;

import java.time.LocalDateTime;

public record PhotoResponse(
    String photoId,
    String url,
    String description,
    String userId,
    LocalDateTime uploadedAt
) {}

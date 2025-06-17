package com.app.xplore.dto.response;

public record LikeResponse(
    String likeId,
    String userId,
    String parentId
) {}

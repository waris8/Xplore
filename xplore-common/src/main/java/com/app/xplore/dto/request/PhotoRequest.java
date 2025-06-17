package com.app.xplore.dto.request;

public record PhotoRequest(
    String url,
    String description,
    String userId
) {}

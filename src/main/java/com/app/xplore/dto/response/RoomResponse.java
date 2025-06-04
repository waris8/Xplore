package com.app.xplore.dto.response;

import com.app.xplore.models.Gender;
import com.app.xplore.models.rooms.RoomType;

import java.time.LocalDateTime;

public record RoomResponse(
    String roomId,
    String roomName,
    String roomDescription,
    RoomType roomType,
    String roomIconUrl,
    Integer roomMinimumAge,
    Gender roomGender,
    boolean active,
    LocalDateTime roomCreatedDate,
    LocalDateTime roomExpiryDate
) {}

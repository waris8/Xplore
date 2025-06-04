package com.app.xplore.dto.request;

import com.app.xplore.models.Gender;
import com.app.xplore.models.events.EventType;

import java.time.LocalDateTime;
import java.util.List;

public record EventRequest(
    String eventName,
    String eventDescription,
    String eventVenueId,
    LocalDateTime eventDate,
    EventType eventType,
    List<String> eventImages,
    Integer eventMinimumAge,
    Gender eventGender,
    boolean active,
    Integer capacity,
    boolean isAvailable,
    String roomId
) {}

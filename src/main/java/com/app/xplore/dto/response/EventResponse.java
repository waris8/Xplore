package com.app.xplore.dto.response;

import com.app.xplore.models.Gender;
import com.app.xplore.models.events.EventType;

import java.time.LocalDateTime;
import java.util.List;

public record EventResponse(
    String eventId,
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
    Integer availableSeats,
    boolean isAvailable,
    String roomId,
    LocalDateTime eventCreatedDate,
    LocalDateTime eventUpdatedDate
) {}

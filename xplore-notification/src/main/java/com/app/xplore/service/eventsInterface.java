package com.app.xplore.service.events;

import com.app.xplore.models.events.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface eventsInterface {
    // Create
    Event createEvent(Event event);

    // Read
    Optional<Event> getEventById(String eventId);

    Page<Event> getAllEvents(Pageable pageable);

    List<Event> getEventsByType(String eventType);

    List<Event> getEventsByVenue(String venueId);

    List<Event> getActiveEvents();

    List<Event> getAvailableEvents();

    // Update
    Event updateEvent(String eventId, Event event);

    Event updateEventStatus(String eventId, boolean isActive);

    Event updateEventAvailability(String eventId, boolean isAvailable);

    Event updateEventCapacity(String eventId, Integer newCapacity);

    Event updateEventSeats(String eventId, Integer newAvailableSeats);

    // Delete
    void deleteEvent(String eventId);

    void deleteAllEvents();
}

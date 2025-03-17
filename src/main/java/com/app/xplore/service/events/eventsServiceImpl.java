package com.app.xplore.service.events;

import com.app.xplore.models.events.Event;
import com.app.xplore.models.events.EventType;
import com.app.xplore.repository.events.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class eventsServiceImpl implements eventsInterface {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        event.setEventCreatedDate(LocalDateTime.now());
        event.setEventUpdatedDate(LocalDateTime.now());
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEventById(String eventId) {
        return eventRepository.findById(eventId);
    }

    @Override
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    public List<Event> getEventsByType(String eventType) {
        return eventRepository.findByEventType(EventType.valueOf(eventType));
    }

    @Override
    public List<Event> getEventsByVenue(String venueId) {
        return eventRepository.findByEventVenue_AddressId(venueId);
    }

    @Override
    public List<Event> getActiveEvents() {
        return eventRepository.findByActiveTrue();
    }

    @Override
    public List<Event> getAvailableEvents() {
        return eventRepository.findByIsAvailableTrue();
    }

    @Override
    public Event updateEvent(String eventId, Event event) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();
            updatedEvent.setEventName(event.getEventName());
            updatedEvent.setEventDescription(event.getEventDescription());
            updatedEvent.setEventVenue(event.getEventVenue());
            updatedEvent.setEventDate(event.getEventDate());
            updatedEvent.setEventType(event.getEventType());
            updatedEvent.setEventImages(event.getEventImages());
            updatedEvent.setEventMinimumAge(event.getEventMinimumAge());
            updatedEvent.setEventGender(event.getEventGender());
            updatedEvent.setActive(event.isActive());
            updatedEvent.setCapacity(event.getCapacity());
            updatedEvent.setAvailableSeats(event.getAvailableSeats());
            updatedEvent.setAvailable(event.isAvailable());
            updatedEvent.setEventMetadata(event.getEventMetadata());
            updatedEvent.setRoomId(event.getRoomId());
            updatedEvent.setEventUpdatedDate(LocalDateTime.now());
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    @Override
    public Event updateEventStatus(String eventId, boolean isActive) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();
            updatedEvent.setActive(isActive);
            updatedEvent.setEventUpdatedDate(LocalDateTime.now());
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    @Override
    public Event updateEventAvailability(String eventId, boolean isAvailable) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();
            updatedEvent.setAvailable(isAvailable);
            updatedEvent.setEventUpdatedDate(LocalDateTime.now());
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    @Override
    public Event updateEventCapacity(String eventId, Integer newCapacity) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();
            updatedEvent.setCapacity(newCapacity);
            updatedEvent.setEventUpdatedDate(LocalDateTime.now());
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    @Override
    public Event updateEventSeats(String eventId, Integer newAvailableSeats) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();
            updatedEvent.setAvailableSeats(newAvailableSeats);
            updatedEvent.setEventUpdatedDate(LocalDateTime.now());
            return eventRepository.save(updatedEvent);
        }
        return null;
    }

    @Override
    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }
}
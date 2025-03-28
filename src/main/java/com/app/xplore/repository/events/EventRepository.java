package com.app.xplore.repository.events;

import com.app.xplore.models.events.Event;
import com.app.xplore.models.events.EventType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findByEventType(EventType eventType);

    List<Event> findByEventVenue_AddressId(String venueId);

    List<Event> findByActiveTrue();

    List<Event> findByIsAvailableTrue();
}
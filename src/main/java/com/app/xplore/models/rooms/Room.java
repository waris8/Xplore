package com.app.xplore.models.rooms;

import com.app.xplore.models.Gender;
import com.app.xplore.models.events.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roomId;
    private String roomName;
    private String roomDescription;
    @CreatedDate
    private LocalDateTime roomCreatedDate;
    private LocalDateTime roomExpiryDate;
    private RoomType roomType;
    private String roomIconUrl;
    private Integer roomMinimumAge;
    private Gender roomGender;
    private boolean active;
    private Integer capacity;
    private Integer members;
    private Map<String, String> roomMetadata;
    private String roomCreatedBy;
    private String eventId;
    private boolean isPrivate;

    // Default constructor
    public Room() {
    }

    // Constructor to create a room from an event
    public Room(Event event, String creatorId) {
        this.roomName = event.getEventName();
        this.roomDescription = event.getEventDescription();
        this.roomCreatedDate = LocalDateTime.now();
        this.roomExpiryDate = event.getEventDate();
        this.roomType = RoomType.EVENT; // Assuming EVENT is a valid RoomType
        this.roomMinimumAge = event.getEventMinimumAge();
        this.roomGender = event.getEventGender();
        this.active = event.isActive();
        this.capacity = event.getCapacity();
        this.members = event.getAvailableSeats();
        this.roomMetadata = event.getEventMetadata();
        this.roomCreatedBy = creatorId;
        this.eventId = event.getEventId();
        this.isPrivate = false; // Default to public room
    }
}

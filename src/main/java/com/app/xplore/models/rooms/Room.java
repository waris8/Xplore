package com.app.xplore.models.rooms;

import com.app.xplore.models.Gender;
import com.app.xplore.models.events.Event;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
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
//    private Map<String, String> roomMetadata;
    private String roomCreatedBy;
    private String eventId;
    private boolean isPrivate;

    // Constructor to create a room from an event
    public Room(Event event, String creatorId) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        if (creatorId == null || creatorId.trim().isEmpty()) {
            throw new IllegalArgumentException("Creator ID cannot be null or empty");
        }

        this.roomName = event.getEventName();
        this.roomDescription = event.getEventDescription();
        this.roomCreatedDate = LocalDateTime.now();
        this.roomExpiryDate = event.getEventDate();
        this.roomType = RoomType.EVENT;
        this.roomMinimumAge = event.getEventMinimumAge();
        this.roomGender = event.getEventGender();
        this.active = event.isActive();
        this.capacity = event.getCapacity();
        this.members = event.getAvailableSeats();
//        this.roomMetadata = event.getEventMetadata();
        this.roomCreatedBy = creatorId;
        this.eventId = event.getEventId();
        this.isPrivate = false;
    }
}

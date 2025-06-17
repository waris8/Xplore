package com.app.xplore.models.rooms;

import com.app.xplore.models.BaseEntity;
import com.app.xplore.models.Gender;
import com.app.xplore.models.User;
import com.app.xplore.models.events.Event;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id")
    private String roomId;

    @Column(nullable = false)
    private String roomName;

    @Column(columnDefinition = "TEXT")
    private String roomDescription;

    @Column(name = "created_date", nullable = false, updatable = false, insertable = false)
    private LocalDateTime roomCreatedDate;

    @Column(name = "expiry_date")
    private LocalDateTime roomExpiryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    private String roomIconUrl;

    @Column(name = "minimum_age")
    private Integer roomMinimumAge;

    @Enumerated(EnumType.STRING)
    private Gender roomGender;

    private boolean active = true;

    private Integer capacity;

    @Column(columnDefinition = "integer default 1")
    private Integer members = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "is_private")
    private boolean isPrivate = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "room_members",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> membersList = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    // Constructor to create a room from an event
    public Room(Event event, User creator) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }

        this.roomName = event.getEventName();
        this.roomDescription = event.getEventDescription();
        this.event = event;
        this.createdBy = creator;
        this.membersList.add(creator);
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

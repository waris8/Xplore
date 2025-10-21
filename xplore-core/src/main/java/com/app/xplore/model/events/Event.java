package com.app.xplore.model.events;

import com.app.xplore.model.ILocatable;
import com.app.xplore.model.ISoftDeletable;
import com.app.xplore.model.Address;
import com.app.xplore.model.BaseEntity;
import com.app.xplore.model.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event extends BaseEntity implements ILocatable, ISoftDeletable {

    private boolean deleted;
    private double latitude;
    private double longitude;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "event_description", columnDefinition = "TEXT")
    private String eventDescription;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venue_address_id")
    private Address eventVenue;

    @Column(name = "event_date", nullable = false)
    private LocalDateTime eventDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType eventType;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "event_images", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "image_url")
    private List<String> eventImages = new ArrayList<>();

    @Column(name = "minimum_age")
    private Integer eventMinimumAge;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_gender")
    private Gender eventGender;

    @Column(nullable = false)
    private Integer capacity;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable = true;

    @Column(name = "room_id")
    private String roomId;

    @Column(name = "event_created_date", nullable = false, updatable = false, insertable = false)
    private LocalDateTime eventCreatedDate;

    @Column(name = "event_updated_date", insertable = false)
    private LocalDateTime eventUpdatedDate;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_artists",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Set<Artist> artists = new HashSet<>();

    // Business methods
    public void bookSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be positive");
        }
        if (availableSeats < numberOfSeats) {
            throw new IllegalStateException("Not enough available seats");
        }
        this.availableSeats -= numberOfSeats;
        if (this.availableSeats == 0) {
            this.isAvailable = false;
        }
    }

    public void releaseSeats(int numberOfSeats) {
        if (numberOfSeats <= 0) {
            throw new IllegalArgumentException("Number of seats must be positive");
        }
        if (availableSeats + numberOfSeats > capacity) {
            throw new IllegalStateException("Cannot release more seats than capacity");
        }
        this.availableSeats += numberOfSeats;
        if (!this.isAvailable && this.availableSeats > 0) {
            this.isAvailable = true;
        }
    }
}

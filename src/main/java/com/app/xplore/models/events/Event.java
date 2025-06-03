package com.app.xplore.models.events;

import com.app.xplore.models.Address;
import com.app.xplore.models.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String eventId;
    private String eventName;
    private String eventDescription;
    @OneToOne
    private Address eventVenue;
    private LocalDateTime eventDate;
    private EventType eventType;
    private List<String> eventImages;
    private Integer eventMinimumAge;
    private Gender eventGender;
    private boolean active;
    private Integer capacity;
    private Integer availableSeats;
    private boolean isAvailable;
    private String roomId;
    @CreationTimestamp
    private LocalDateTime eventCreatedDate;
    @UpdateTimestamp
    private LocalDateTime eventUpdatedDate;

}

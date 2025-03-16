package com.app.xplore.models.events;

import com.app.xplore.models.Address;
import com.app.xplore.models.Gender;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class Event {
    private String eventId;
    private String eventName;
    private String eventDescription;
    private Address eventVenue;
    private LocalDateTime eventDate;
//    private String eventCreatedBy;
    private List<String> eventImages;
    private int eventMinimumAge;
    private Gender eventGender;
    private boolean active;
    private Integer capacity;
    private Integer availableSeats;
    private boolean isAvailable;
    private Map<String, String> eventMetadata;
    private String spaceId;

}

//eventName- string
//eventDescription - text
//eventVenue - Location
//eventDate - date
//eventCreatedBy - id
//list<images> eventImage
//eventMinimumAge - int
//eventGender - ENUM
//list<artist> - artist
//isEventAvailable = boolean
//Capacity = int
//seatAvailable = boolean
//List<metadata> metadata
//eventLike =
//spaceId = string

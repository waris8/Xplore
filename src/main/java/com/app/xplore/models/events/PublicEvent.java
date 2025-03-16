package com.app.xplore.models.events;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PublicEvent extends Event{
    private List<Artist> artists;
    private double price;
    private Organiser organiser;

    public PublicEvent() {
        this.setEventType(EventType.PUBLIC);
    }
}

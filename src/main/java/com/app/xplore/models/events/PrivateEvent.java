package com.app.xplore.models.events;

import com.app.xplore.models.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateEvent extends Event{
    private User organiser;

    public PrivateEvent() {
        this.setEventType(EventType.PRIVATE);
    }
}

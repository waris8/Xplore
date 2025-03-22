//package com.app.xplore.models.events;
//
//import com.app.xplore.models.User;
//import jakarta.persistence.DiscriminatorValue;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Entity
//@DiscriminatorValue("PRIVATE")
//public class PrivateEvent extends Event{
//    @ManyToOne
//    private User organiser;
//
//    public PrivateEvent() {
//        this.setEventType(EventType.PRIVATE);
//    }
//}

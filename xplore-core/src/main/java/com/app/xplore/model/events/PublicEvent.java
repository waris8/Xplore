//package com.app.xplore.models.events;
//
//import jakarta.persistence.DiscriminatorValue;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ManyToOne;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.util.List;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Entity
//@DiscriminatorValue("PUBLIC")
//public class PublicEvent extends Event{
//    private List<Artist> artists;
//    private double price;
//    @ManyToOne
//    private Organiser organiser;
//
//    public PublicEvent() {
//        this.setEventType(EventType.PUBLIC);
//    }
//}

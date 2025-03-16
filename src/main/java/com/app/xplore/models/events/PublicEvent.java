package com.app.xplore.models.events;

import lombok.Data;

import java.util.List;

@Data
public class PublicEvent extends Event{
    private List<Artist> artists;
    private double price;
    private Organiser organiser;
}

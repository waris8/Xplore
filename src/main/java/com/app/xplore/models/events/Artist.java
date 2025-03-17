package com.app.xplore.models.events;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String artistId;
    private String name;
    private String profession;
}

package com.app.xplore.model.events;

import com.app.xplore.model.BaseEntity;
import com.app.xplore.models.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists")
@Getter
@Setter
@NoArgsConstructor
public class Artist extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "artist_id")
    private String artistId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String profession;
    
    @Column(columnDefinition = "TEXT")
    private String bio;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Column(name = "contact_info", length = 255)
    private String contactInfo;
    
    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private boolean isActive = true;
    
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;
    
    @ManyToMany(mappedBy = "artists", fetch = FetchType.LAZY)
    private Set<Event> events = new HashSet<>();
    
    // Business methods
    public void deactivate() {
        this.isActive = false;
    }
    
    public void activate() {
        this.isActive = true;
    }
}

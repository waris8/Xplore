package com.app.xplore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString(exclude = {"contact"}) // Exclude relationships to prevent circular references
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String userName;
    @CreatedDate
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private boolean isActive;
    private String imageUrl;
    private boolean isVerified;
    private UserType userType;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Contact contact;

    public User() {
        this.setUserType(UserType.USER);
    }
}

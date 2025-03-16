package com.app.xplore.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String userId;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
    private String imageUrl;
    private boolean isVerified;
    private UserType userType;
    private Contact contact;

    public User() {
        this.setUserType(UserType.USER);
    }
}

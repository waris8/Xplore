package com.app.xplore.dto.response;

import com.app.xplore.models.UserType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {
    private String userId;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
    private String imageUrl;
    private boolean isVerified;
    private UserType userType;
    private String contactId; // Reference to contact
}

package com.app.xplore.dto.request;

import com.app.xplore.models.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String userName;
    private boolean isActive;
    private String imageUrl;
    private boolean isVerified;
    private UserType userType;
    private String contactId; // Reference to contact
}

package com.app.xplore.models.events;

import com.app.xplore.models.User;
import com.app.xplore.models.UserType;
import lombok.Data;

@Data
public class Organiser extends User {
    private String organiserId;
    private String companyName;

    public Organiser() {
        this.setUserType(UserType.ORGANISER);
    }
}

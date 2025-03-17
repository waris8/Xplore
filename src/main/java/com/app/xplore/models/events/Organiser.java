package com.app.xplore.models.events;

import com.app.xplore.models.User;
import com.app.xplore.models.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Organiser extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String organiserId;
    private String companyName;

    public Organiser() {
        this.setUserType(UserType.ORGANISER);
    }
}

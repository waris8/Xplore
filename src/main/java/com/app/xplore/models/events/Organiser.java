//package com.app.xplore.models.events;
//
//import com.app.xplore.models.User;
//import com.app.xplore.models.UserType;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Entity
//@DiscriminatorValue("ORGANISER")
//public class Organiser extends User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String organiserId;
//    private String companyName;
//
//    public Organiser() {
//        this.setUserType(UserType.ORGANISER);
//    }
//}

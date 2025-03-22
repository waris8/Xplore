package com.app.xplore.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String contactId;

    @OneToOne
    private Address address;
    private String email;
    private List<Long> contactNo;
}

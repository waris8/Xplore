package com.app.xplore.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String likeId;

    @OneToOne
    private String userId;

    @OneToOne
    private String parentId;
}

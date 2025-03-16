package com.app.xplore.models;

import lombok.Data;

@Data
public class Like {
    private String likeId;
    private String userId;
    private String parentId;
}

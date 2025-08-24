package com.app.xplore.model;

import java.time.LocalDateTime;

public interface IAuditable {
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    String getCreatedBy();
    String getUpdatedBy();
}

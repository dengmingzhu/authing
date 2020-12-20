package com.dmz.authing.entity;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    private String createdBy;
    private String updatedBy;
    private Integer revision;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}

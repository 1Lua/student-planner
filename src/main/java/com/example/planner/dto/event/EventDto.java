package com.example.planner.dto.event;

import com.example.planner.entities.UserEntity;
import jakarta.persistence.*;

import java.util.Date;

public class EventDto {
    String id;
    private String name;
    private String description;
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
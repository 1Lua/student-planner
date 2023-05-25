package com.example.planner.dto;

public enum TaskStatus {

    NONE("none"),
    PLANNED ("planned"),
    IN_PROGRESS ("in_progress"),
    COMPLETED ("completed");

    private String name;
    TaskStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TaskStatus getTaskStatus(String name) {
        for (TaskStatus status : values()) {
            if (status.name.equals(name)) {
                return status;
            }
        }
        return NONE;
    }
}

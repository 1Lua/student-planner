package com.example.planner.dto.task;

import com.example.planner.dto.DatePeriod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskFilter {
    private DatePeriod period;
    private Boolean sortByPriority;

}

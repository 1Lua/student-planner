package com.example.planner.dto.event;

import com.example.planner.dto.DatePeriod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventFilterDto {
    private DatePeriod period;
}

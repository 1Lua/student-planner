package com.example.planner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DatePeriod {
    private Date from;
    private Date to;
}
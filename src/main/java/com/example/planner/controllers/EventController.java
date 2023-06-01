package com.example.planner.controllers;

import com.example.planner.dto.event.CreateEventDto;
import com.example.planner.dto.event.EventDto;
import com.example.planner.dto.event.EventFilterDto;
import com.example.planner.service.EventService;
import com.example.planner.utils.EventUtils;
import com.example.planner.validators.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.EventFilter;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("api/events")
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    EventValidator eventValidator;

    @Autowired
    EventUtils eventUtils;

    @PostMapping("/create")
    public EventDto createEvent(@RequestBody CreateEventDto createEventDto) {
        eventValidator.validateCreateEvent(createEventDto);
        return eventUtils.convertEntityToDto(eventService.createEvent(createEventDto));
    }

    @GetMapping("/{id}")
    public EventDto getEvent(@PathVariable String id) {
        return eventUtils.convertEntityToDto(eventService.getEvent(id));
    }

    @PostMapping("/edit")
    public EventDto editEvent(@RequestBody EventDto eventDto) {
        eventValidator.validateEditEvent(eventDto);
        return eventUtils.convertEntityToDto(eventService.editEvent(eventDto));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    @PostMapping("/filter")
    public List<EventDto> getEventsByFilter(@RequestBody EventFilterDto eventFilter) {

        return new ArrayList<EventDto>();
    }
}

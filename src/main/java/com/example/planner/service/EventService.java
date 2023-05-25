package com.example.planner.service;

import com.example.planner.dto.event.CreateEventDto;
import com.example.planner.dto.event.EventDto;
import com.example.planner.entities.EventEntity;
import com.example.planner.repositories.EventRepository;
import com.example.planner.utils.EventUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventUtils eventUtils;

    public EventEntity getEvent(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    public EventEntity createEvent(CreateEventDto createEventDto) {
        EventEntity eventEntity = new EventEntity();
        eventUtils.fillData(eventEntity, createEventDto);
        eventRepository.save(eventEntity);
        return eventEntity;
    }

    public EventEntity editEvent(EventDto eventDto) {
        EventEntity eventEntity = eventRepository.findById(eventDto.getId()).orElse(null);
        if (eventEntity != null) {
            eventUtils.fillData(eventEntity, eventDto);
            eventRepository.save(eventEntity);
        }
        return eventEntity;
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

}

package com.example.planner.utils;

import com.example.planner.dto.event.CreateEventDto;
import com.example.planner.dto.event.EventDto;
import com.example.planner.entities.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventUtils {

    public EventDto convertEntityToDto(EventEntity eventEntity) {
        if (eventEntity == null) {
            return null;
        }

        EventDto eventDto = new EventDto();
        eventDto.setId(eventEntity.getId());
        eventDto.setName(eventEntity.getName());
        eventDto.setDescription(eventEntity.getDescription());
        eventDto.setDate(eventEntity.getDate());
        return eventDto;
    }

    public EventEntity convertDtoToEntity(EventDto eventDto) {
        if (eventDto == null) {
            return null;
        }
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(eventDto.getId());
        eventEntity.setName(eventDto.getName());
        eventEntity.setDescription(eventDto.getDescription());
        eventEntity.setDate(eventDto.getDate());
        return eventEntity;
    }

    public void fillData(EventEntity eventEntity, CreateEventDto createEventDto) {
        if(createEventDto == null) {
            return;
        }
        eventEntity.setName(createEventDto.getName());
        eventEntity.setDescription(createEventDto.getDescription());
        eventEntity.setDate(createEventDto.getDate());
    }

    public void fillData(EventEntity eventEntity, EventDto eventDto) {
        if(eventDto == null) {
            return;
        }
        eventEntity.setId(eventDto.getId());
        eventEntity.setName(eventDto.getName());
        eventEntity.setDescription(eventDto.getDescription());
        eventEntity.setDate(eventDto.getDate());
    }
}

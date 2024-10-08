package com.example.Java_ticket.convert;

import com.example.Java_ticket.DTO.EventDTO;
import com.example.Java_ticket.model.Event;
import org.springframework.stereotype.Service;

@Service
public class ConvertToDTO {
    public EventDTO convertEvent(Event event)
    {
        return new EventDTO(event.getId(), event.getEventDate(), event.getName(), event.getPlace().getName());
    }
}

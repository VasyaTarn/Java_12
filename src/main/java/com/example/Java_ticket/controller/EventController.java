package com.example.Java_ticket.controller;

import com.example.Java_ticket.DTO.EventCreationDTO;
import com.example.Java_ticket.DTO.TicketPackDTO;
import com.example.Java_ticket.service.createEventService.CreateEventService;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventController {
    @Autowired
    private CreateEventService createEventService;

    @GetMapping("/create-event")
    public String showCreateEventForm(Model model) {
        EventCreationDTO eventCreationDto = new EventCreationDTO();

        if (eventCreationDto.getTicketPacksDto().isEmpty())
        {
            eventCreationDto.getTicketPacksDto().add(new TicketPackDTO());
        }

        model.addAttribute("eventCreationDto", eventCreationDto);
        return "createEvent";
    }

    @PostMapping("/create-event")
    public String createEvent(@ModelAttribute("eventCreationDto") EventCreationDTO eventCreationDto, Model model) {
        boolean isCreated = createEventService.CreateEventByDto(eventCreationDto);

        if (isCreated)
        {
            model.addAttribute("message", "Event created successfully");
        }
        else
        {
            model.addAttribute("message", "Event creation failed");
        }

        return "createEventResult";
    }

}

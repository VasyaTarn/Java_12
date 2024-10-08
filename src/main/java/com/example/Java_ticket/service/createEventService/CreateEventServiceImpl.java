package com.example.Java_ticket.service.createEventService;

import com.example.Java_ticket.DTO.EventCreationDTO;
import com.example.Java_ticket.DTO.PlaceDTO;
import com.example.Java_ticket.DTO.TicketPackDTO;
import com.example.Java_ticket.model.Event;
import com.example.Java_ticket.model.Place;
import com.example.Java_ticket.model.Ticket;
import com.example.Java_ticket.model.TicketStatus;
import com.example.Java_ticket.service.eventService.EventService;
import com.example.Java_ticket.service.placeService.PlaceService;
import com.example.Java_ticket.service.ticketService.TicketService;
import com.example.Java_ticket.service.ticketStatusService.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CreateEventServiceImpl implements CreateEventService {
    @Autowired
    private PlaceService placeService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketStatusService ticketStatusService;


    @Override
    public boolean CreateEventByDto(EventCreationDTO eventCreationDTO)
    {
        PlaceDTO placeDto = eventCreationDTO.getPlaceDto();
        Place place = placeService.findByName(placeDto.getName()).orElse(null);

        if (place == null)
        {
            Place newPlace = new Place();

            newPlace.setAddress(placeDto.getAddress());
            newPlace.setName(placeDto.getName());

            place = placeService.save(newPlace);
        }

        Event findEvent = eventService.findByEventDate(eventCreationDTO.getEventDate()).orElse(null);

        if (findEvent != null && Objects.equals(findEvent.getPlace().getId(), place.getId()))
        {
            return false;
        }

        Event event = new Event();
        event.setEventDate(eventCreationDTO.getEventDate());
        event.setName(eventCreationDTO.getName());
        event.setPlace(place);
        Event newEvent = eventService.save(event);

        TicketStatus status = ticketStatusService.findByStatus("FREE").orElse(null);

        if (status == null)
        {
            return false;
        }

        List<TicketPackDTO> ticketsDto = eventCreationDTO.getTicketPacksDto();
        for (TicketPackDTO ticketDto : ticketsDto)
        {
            float price = ticketDto.getPrice();

            for (int i = 1; i <= ticketDto.getQuantity(); i++)
            {
                Ticket newTicket = new Ticket();

                newTicket.setCost(price);
                newTicket.setNumber(i);
                newTicket.setEvent(newEvent);
                newTicket.setStatus(status);

                ticketService.save(newTicket);
            }
        }

        return true;
    }
}

package com.example.Java_ticket.service.eventService;

import com.example.Java_ticket.DTO.EventDTO;
import com.example.Java_ticket.model.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event save(Event event);
    int[] saveEventsList(List<Event> events);
    void update(Event event);
    void delete(Event event);
    List<Event> findAll();
    void deleteAll();

    Optional<Event> findByEventDate(LocalDate eventDate);
    Optional<Event> findById(int id);
    List<EventDTO> findAllDTO();
    List<EventDTO> findEventsBetweenDates(LocalDate startDate, LocalDate endDate);
}

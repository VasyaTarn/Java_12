package com.example.Java_ticket.service.eventService;

import com.example.Java_ticket.DAO.event.EventRepository;
import com.example.Java_ticket.DTO.EventDTO;
import com.example.Java_ticket.convert.ConvertToDTO;
import com.example.Java_ticket.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ConvertToDTO convertToDTO;

    @Override
    public Event save(Event event)
    {
        return eventRepository.save(event);
    }

    @Override
    public int[] saveEventsList(List<Event> events)
    {
        eventRepository.saveAll(events);
        return new int[0];
    }

    @Override
    public void update(Event event)
    {
        eventRepository.save(event);
    }

    @Override
    public void delete(Event event)
    {
        eventRepository.delete(event);
    }

    @Override
    public List<Event> findAll()
    {
        return eventRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        eventRepository.deleteAll();
    }


    @Override
    public Optional<Event> findByEventDate(LocalDate eventDate)
    {
        return eventRepository.findByEventDate(eventDate);
    }

    @Override
    public Optional<Event> findById(int id)
    {
        return eventRepository.findById(id);
    }

    @Transactional
    @Override
    public List<EventDTO> findAllDTO()
    {
        return eventRepository.findAll().stream()
                .map(convertToDTO::convertEvent)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<EventDTO> findEventsBetweenDates(LocalDate startDate, LocalDate endDate)
    {
        return eventRepository.findEventsBetweenDates(startDate, endDate).stream()
                .map(convertToDTO::convertEvent)
                .collect(Collectors.toList());
    }
}

package com.example.Java_ticket.service.ticketService;

import com.example.Java_ticket.DAO.ticket.TicketRepository;
import com.example.Java_ticket.model.Ticket;
import com.example.Java_ticket.service.ticketStatusService.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketStatusService ticketStatusService;


    @Override
    public void save(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }

    @Override
    public int[] saveTicketsList(List<Ticket> tickets)
    {
        ticketRepository.saveAll(tickets);
        return new int[0];
    }

    @Override
    public void update(Ticket ticket)
    {
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(Ticket ticket)
    {
        ticketRepository.delete(ticket);
    }

    @Override
    public List<Ticket> findAll()
    {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        ticketRepository.deleteAll();
    }


    @Override
    public List<Ticket> findTicketsByEventAndStatus(Integer eventId, String statusName)
    {
        return ticketStatusService.findByStatus(statusName)
                .map(status -> ticketRepository.findTicketsByEventAndStatus(eventId, status.getId()))
                .orElse(Collections.emptyList());
    }

    @Override
    public Optional<Ticket> findFirstTicketByEventAndStatusAndCustomerNull(Integer eventId, String statusName)
    {
        return ticketStatusService.findByStatus(statusName)
                .map(status -> {
                    List<Ticket> tickets = ticketRepository.findTicketByEventAndStatusAndCustomerNull(eventId, status.getId());
                    return tickets.isEmpty() ? null : tickets.get(0);
                })
                .map(Optional::of)
                .orElse(Optional.empty());
    }
}

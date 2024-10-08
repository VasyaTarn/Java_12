package com.example.Java_ticket.service.ticketService;

import com.example.Java_ticket.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    void save(Ticket ticket);
    int[] saveTicketsList(List<Ticket> tickets);
    void update(Ticket ticket);
    void delete(Ticket ticket);
    List<Ticket> findAll();
    void deleteAll();

    List<Ticket> findTicketsByEventAndStatus(Integer eventId, String statusName);
    Optional<Ticket> findFirstTicketByEventAndStatusAndCustomerNull(Integer eventId, String statusName);
}

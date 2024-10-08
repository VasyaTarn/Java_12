package com.example.Java_ticket.service.ticketStatusService;

import com.example.Java_ticket.model.TicketStatus;

import java.util.List;
import java.util.Optional;

public interface TicketStatusService {
    void save(TicketStatus ticketStatus);
    int[] saveTicketStatusesList(List<TicketStatus> ticketStatuses);
    void update(TicketStatus ticketStatus);
    void delete(TicketStatus ticketStatus);
    List<TicketStatus> findAll();
    void deleteAll();

    Optional<TicketStatus> findByStatus(String status);
}

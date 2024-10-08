package com.example.Java_ticket.service.ticketStatusService;

import com.example.Java_ticket.DAO.ticketStatus.TicketStatusRepository;
import com.example.Java_ticket.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketStatusServiceImpl implements TicketStatusService {
    @Autowired
    private TicketStatusRepository ticketStatusRepository;

    @Override
    public void save(TicketStatus ticketStatus)
    {
        ticketStatusRepository.save(ticketStatus);
    }

    @Override
    public int[] saveTicketStatusesList(List<TicketStatus> ticketStatuses)
    {
        ticketStatusRepository.saveAll(ticketStatuses);
        return new int[0];
    }

    @Override
    public void update(TicketStatus ticketStatus)
    {
        ticketStatusRepository.save(ticketStatus);
    }

    @Override
    public void delete(TicketStatus ticketStatus)
    {
        ticketStatusRepository.delete(ticketStatus);
    }

    @Override
    public List<TicketStatus> findAll()
    {
        return ticketStatusRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        ticketStatusRepository.deleteAll();
    }


    @Override
    public Optional<TicketStatus> findByStatus(String status)
    {
        return ticketStatusRepository.findByStatus(status);
    }
}

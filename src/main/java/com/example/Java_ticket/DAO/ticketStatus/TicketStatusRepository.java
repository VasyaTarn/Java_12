package com.example.Java_ticket.DAO.ticketStatus;

import com.example.Java_ticket.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {
    Optional<TicketStatus> findByStatus(String status);
}

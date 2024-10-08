package com.example.Java_ticket.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "ticketstatus")
public class TicketStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String status;
}

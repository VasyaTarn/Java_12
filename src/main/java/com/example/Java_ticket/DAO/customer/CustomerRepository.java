package com.example.Java_ticket.DAO.customer;


import com.example.Java_ticket.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findById(Integer id);
}

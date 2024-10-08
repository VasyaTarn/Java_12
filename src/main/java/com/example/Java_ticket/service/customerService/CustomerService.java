package com.example.Java_ticket.service.customerService;

import com.example.Java_ticket.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    int[] saveCustomersList(List<Customer> customers);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> findAll();
    void deleteAll();

    Optional<Customer> findById(int id);
}

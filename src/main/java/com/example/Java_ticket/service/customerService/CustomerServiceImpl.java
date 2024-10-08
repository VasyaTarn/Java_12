package com.example.Java_ticket.service.customerService;

import com.example.Java_ticket.DAO.customer.CustomerRepository;
import com.example.Java_ticket.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }

    @Override
    public int[] saveCustomersList(List<Customer> customers)
    {
        customerRepository.saveAll(customers);
        return new int[0];
    }

    @Override
    public void update(Customer customer)
    {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer)
    {
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @Override
    public void deleteAll()
    {
        customerRepository.deleteAll();
    }

    @Override
    public Optional<Customer> findById(int id)
    {
        return customerRepository.findById(id);
    }
}

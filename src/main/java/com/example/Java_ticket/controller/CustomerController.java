package com.example.Java_ticket.controller;

import com.example.Java_ticket.model.Customer;
import com.example.Java_ticket.model.Ticket;
import com.example.Java_ticket.service.customerService.CustomerService;
import com.example.Java_ticket.service.eventService.EventService;
import com.example.Java_ticket.service.ticketService.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "customer/create")
    public String createCustomerPage(Model model) {
        return "createCustomer";
    }

    @PostMapping(value = "customer/create")
    public String createCustomer(@RequestParam("name") String name,
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 Model model) {
        Customer addCustomer = new Customer(0, name, email, phone, null);
        customerService.save(addCustomer);
        return "redirect:/customers/get";
    }

    @GetMapping(value = "customers/get")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }

    @GetMapping(value = "customer/getTicket")
    public String getCustomerTicketPage(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("eventsDto", eventService.findAllDTO());
        return "ticketAssignment";
    }

    @PostMapping(value = "customer/getTicket")
    public String getCustomerTicket(@RequestParam("customerId") String customerId,
                                    @RequestParam("eventId") String eventId,
                                    Model model) {
        int customerIdInt = Integer.parseInt(customerId);
        int eventIdInt = Integer.parseInt(eventId);

        Ticket ticketFree = ticketService.findFirstTicketByEventAndStatusAndCustomerNull(eventIdInt, "FREE").orElse(null);
        Customer customer = customerService.findById(customerIdInt).orElse(null);

        if (ticketFree != null && customer != null)
        {
            ticketFree.setCustomer(customer);
            ticketService.save(ticketFree);

            model.addAttribute("message", "Ticket assignment successfully");
        }
        else
        {
            model.addAttribute("message", "Ticket assignment failed");
        }

        return "ticketAssignmentResult";
    }
}

package com.example.Java_ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JavaTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTicketApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start() {
		System.out.println("Test");
	}
}

package com.scaler.bookmyshow18jan23;

import com.scaler.bookmyshow18jan23.controllers.TicketController;
import com.scaler.bookmyshow18jan23.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow18jan23.models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bookmyshow18jan23Application implements CommandLineRunner {
    private TicketController ticketController;

    @Autowired
    public Bookmyshow18jan23Application(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    public static void main(String[] args) {
        SpringApplication.run(Bookmyshow18jan23Application.class, args);

//        Actor actor = new Actor();
//        actor.getName();
//        actor.setName("Naman");
    }

    @Override
    public void run(String... args) throws Exception {
        // H/W:
        // 0. Create a movie
        // 1. Create a city
        // 2. Create a theatre
        // 3. Add auditorium to a theatre (create a theatre)
        // 4. Create 3 seat types: vip, gold, platinum
        // 5. Create 50 seats in the above auditorium
        // 6. Create a show
        //   showController.createShow(Long movieId, Date startTime, Date endTime, Theatre thetreId)

//        BookTicketResponseDto response = ticketController.bookTicket(
//
//        );
    }
}

// ORM -> Object Relational Mapping Library
// Spring Data JPA -> Hibernate ORM -> Java Persistence Library

// Break till 10:20 PM
// After Break:
// - Represent Enums
// - Create Schema
// - Controller, Service, Repo

// HW:
// Implement classes and methods needed to create a new movie
// Implement classes and methods to create a new theatre
// Implement classes and emthods to create a new ticket
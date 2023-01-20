package com.scaler.bookmyshow18jan23.repositories;

import com.scaler.bookmyshow18jan23.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TicketRepository
extends JpaRepository<Ticket, Long> {

    Ticket save(Ticket ticket);
}

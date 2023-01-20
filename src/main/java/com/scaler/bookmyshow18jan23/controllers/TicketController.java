package com.scaler.bookmyshow18jan23.controllers;

import com.scaler.bookmyshow18jan23.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow18jan23.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow18jan23.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow18jan23.models.Ticket;
import com.scaler.bookmyshow18jan23.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        Long showId = request.getShowId();;
        List<Long> showSeatIds = request.getShowSeatIds();

        try {
            Ticket ticket = ticketService.bookTicket(
                    showId,
                    showSeatIds
            );

            BookTicketResponseDto response = new BookTicketResponseDto();
            response.setStatus("SUCCESS");
            response.setTicket(ticket);

            return response;
        } catch (ShowSeatNotAvailableException exception) {
            BookTicketResponseDto response = new BookTicketResponseDto();
            response.setStatus("FAILURE");

            return response;
        }
    }
}

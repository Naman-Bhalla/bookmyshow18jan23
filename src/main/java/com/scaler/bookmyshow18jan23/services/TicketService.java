package com.scaler.bookmyshow18jan23.services;

import com.scaler.bookmyshow18jan23.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow18jan23.models.*;
import com.scaler.bookmyshow18jan23.repositories.ShowRepository;
import com.scaler.bookmyshow18jan23.repositories.ShowSeatRepository;
import com.scaler.bookmyshow18jan23.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketPriceCalculator ticketPriceCalculator;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ShowRepository showRepository,
                         ShowSeatRepository showSeatRepository,
                         TicketPriceCalculator ticketPriceCalculator,
                         TicketRepository ticketRepository) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketPriceCalculator = ticketPriceCalculator;
        this.ticketRepository = ticketRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId,
                             List<Long> showSeatIds) throws ShowSeatNotAvailableException {

        // 1. Get show with that ID
        Show show = showRepository.findByIdEquals(showId);

        // 2. Get ShowSeat with those IDs
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        // 3. Check if all seats are available
        for (ShowSeat showSeat: showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("Show Seat " + showSeat.getId() + " is not available for booking.");
            }
        }

        // 4.1 If available:
        //     set status to locked
        for (ShowSeat showSeat: showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }

        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.IN_PROCESS);
        ticket.setBookingTime(new Date());
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setAmount(ticketPriceCalculator.calculateTicketPrice(
                showSeats
        ));

        //     create a ticket and save to DB

        Ticket savedTicket = ticketRepository.save(ticket);

        // 4.2 If any not available:
        //     throw an exception

        return savedTicket;
    }
}

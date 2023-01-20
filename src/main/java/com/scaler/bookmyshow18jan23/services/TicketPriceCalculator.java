package com.scaler.bookmyshow18jan23.services;

import com.scaler.bookmyshow18jan23.models.Show;
import com.scaler.bookmyshow18jan23.models.ShowSeat;
import com.scaler.bookmyshow18jan23.models.ShowSeatType;
import com.scaler.bookmyshow18jan23.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketPriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public TicketPriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public double calculateTicketPrice(List<ShowSeat> showSeats) {
        Show show = showSeats.get(0).getShow();

        // 1. Get ShowSeatType objects for this show
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShowEquals(show);

        // 2. Add the prices and done
        double amount = 0;

        for (ShowSeat showSeat: showSeats) {
            for (ShowSeatType showSeatType: showSeatTypes) {
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                }
            }
        }

        return amount;
    }
}

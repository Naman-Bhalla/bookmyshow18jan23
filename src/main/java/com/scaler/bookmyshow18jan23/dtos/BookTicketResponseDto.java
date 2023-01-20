package com.scaler.bookmyshow18jan23.dtos;

import com.scaler.bookmyshow18jan23.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private String status;
    private Ticket ticket;
}

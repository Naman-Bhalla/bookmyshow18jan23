package com.scaler.bookmyshow18jan23.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long showId;
    private List<Long> showSeatIds;
}

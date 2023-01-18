package com.scaler.bookmyshow18jan23.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    // SS : S
    // 1:1
    //  m:1
    @ManyToOne
    private Show show;

    // SS: S
    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

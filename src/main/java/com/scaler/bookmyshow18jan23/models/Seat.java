package com.scaler.bookmyshow18jan23.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {

    // S: ST
    @ManyToOne
    private SeatType seatType;
    private String name;
    private int row;
    private int col;
}

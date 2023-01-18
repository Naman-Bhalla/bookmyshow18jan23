package com.scaler.bookmyshow18jan23.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    // S:A
    @ManyToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;

    // S:M
    @ManyToOne
    private Movie movie;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

}

package com.scaler.bookmyshow18jan23.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;

    // T:A
    @OneToMany
    private List<Auditorium> auditoriums;
    private String company;
}

package com.scaler.bookmyshow18jan23.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;

    // M:A
    @ManyToMany
    private List<Actor> actors;
}

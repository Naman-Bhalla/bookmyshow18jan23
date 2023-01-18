package com.scaler.bookmyshow18jan23.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long id;
}

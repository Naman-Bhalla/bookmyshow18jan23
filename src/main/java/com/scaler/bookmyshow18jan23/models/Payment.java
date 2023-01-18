package com.scaler.bookmyshow18jan23.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private String thirdPartyRefId;
}

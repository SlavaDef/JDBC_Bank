package com.progItHomework.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class ExchangeRates { // курси валют

    private double buy_USD;
    private double sail_USD;
    private double buy_EUR;
    private double sail_EUR;


}

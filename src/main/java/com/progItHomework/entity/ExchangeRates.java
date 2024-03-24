package com.progItHomework.entity;

import lombok.*;

import jakarta.persistence.*;

@Data
//@Entity
@Embeddable
@NoArgsConstructor
public class ExchangeRates { // курси валют
   // @Id
   // private Long id;

    private double buy_USD;
    private double sail_USD;
    private double buy_EUR;
    private double sail_EUR;
    private double result;

    public ExchangeRates(double buy_USD, double sail_USD, double buy_EUR, double sail_EUR) {
        this.buy_USD = buy_USD;
        this.sail_USD = sail_USD;
        this.buy_EUR = buy_EUR;
        this.sail_EUR = sail_EUR;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "buy_USD=" + buy_USD +
                ", sail_USD=" + sail_USD +
                ", buy_EUR=" + buy_EUR +
                ", sail_EUR=" + sail_EUR +
              //  ", result=" + result +"UAN"+
                '}';
    }
}

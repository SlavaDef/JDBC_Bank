package com.progItHomework.entity;

import lombok.*;
import jakarta.persistence.*;


@NoArgsConstructor
@Data
@Entity
@Table(name = "scores")
public class Score { // рахунки
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "score_id")
    private Long id;
    @Column(name = "usd_score")
    private Double usd;
    @Column(name = "eur_score")
    private Double eur;
    @Column(name = "uan_score")
    private Double uan;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_passport")
    private Client client;
  //  @Transient
    @Embedded
    private ExchangeRates exchangeRates;

    public Score(Double usd, Double eur, Double uan, ExchangeRates exchangeRates) {
        this.usd = usd;
        this.eur = eur;
        this.uan = uan;
        this.exchangeRates = exchangeRates;
    }


}

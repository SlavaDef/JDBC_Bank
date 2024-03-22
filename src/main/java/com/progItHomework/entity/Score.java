package com.progItHomework.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "scores")
public class Score { // рахунки
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




}

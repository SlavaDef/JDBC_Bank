package com.progItHomework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@NoArgsConstructor
@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}

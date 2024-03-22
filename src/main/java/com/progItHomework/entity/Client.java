package com.progItHomework.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_full_name", length = 50, nullable = false)
    private String clientFullName;

    @Column(name = "client_phone",length = 20, nullable = false)
    private String phone;

    @Column(name = "client_address", length = 100, nullable = false)
    private String address;

    @Column(name = "client_email", length = 50, nullable = false)
    private String email;

    @Column(name = "client_passport", length = 10, nullable = false)
    private String passport;

    @OneToMany(mappedBy = "client", cascade ={CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Score> scoreList = new ArrayList<>();


}

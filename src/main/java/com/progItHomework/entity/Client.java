package com.progItHomework.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@NamedQueries({
@NamedQuery(name = "Client_By_Passport",
        query = "from Client where passport = :passport")})


@NoArgsConstructor
@Data
@Entity
@Table(name = "client")
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
    //@Lob
    @Column(length = 25, nullable = false)
    private String passport;

    @OneToMany(mappedBy = "client", cascade ={CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Score> scoreList = new ArrayList<>();


    public Client(String clientFullName, String phone, String address, String email, String passport) {
        this.clientFullName = clientFullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.passport = passport;
    }

}

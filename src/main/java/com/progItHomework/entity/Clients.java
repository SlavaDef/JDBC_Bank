package com.progItHomework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Clients {

    private long client_id;

    private String client_fullName;

    private String phone;

    private String address;

    private String email;

    private String passport;
}

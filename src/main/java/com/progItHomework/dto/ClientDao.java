package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.Score;
import org.hibernate.Session;

import java.util.List;

public interface ClientDao {

    Client addClient(Client client);

    List<Client> getAllClients();

    Client updateClient(Client client);

    Client getById(Long id);

    void createSomeClients(int count);


    void addScoreToClient(Score score, Client client);

    Client getClientByPassport(String passport);

}

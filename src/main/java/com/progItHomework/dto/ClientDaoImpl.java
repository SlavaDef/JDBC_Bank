package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.Score;
import com.progItHomework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

import static com.progItHomework.Util.*;

public class ClientDaoImpl implements ClientDao {

    @Override
    public Client addClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            return client;
        }
    }

    @Override
    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("from Client", Client.class);
            return query.list();
        }
    }

    @Override
    public Client updateClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.merge(client);
            tx1.commit();
            return client;
        }
    }

    @Override
    public Client getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    @Override
    public void createSomeClients(int count) {
        for (int i = 0; i < count; i++) {
            addClient(new Client(getRandomFullName(), getRandomPhone(), getRandomAddress(),
                    getRandomEmails(), getRandomPassport() + i));
        }
    }

    @Override
    public void addScoreToClient(Score score, Client client) {

        score.setClient(client);
        client.getScoreList().add(score);
        updateClient(client);
    }
}

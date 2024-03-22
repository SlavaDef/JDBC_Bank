package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDaoImpl implements ClientDao{

    @Override
    public Client addClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            return client;
        }
    }
}

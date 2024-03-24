package com.progItHomework;

import com.progItHomework.dto.ClientDao;
import com.progItHomework.dto.ClientDaoImpl;
import com.progItHomework.dto.ScoreDao;
import com.progItHomework.dto.ScoreDaoImp;
import com.progItHomework.entity.Client;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;

import static com.progItHomework.Application.runApplication;
import static com.progItHomework.Util.createClientsAndScores;


public class App {
    public static void main(String[] args) {

    //   ClientDao clientDao = new ClientDaoImpl();
    //    ScoreDao scoreDao = new ScoreDaoImp();

    //    clientDao.createSomeClients(5);
     //   scoreDao.createSomeScores(5);
    //    createClientsAndScores(clientDao,scoreDao);

      //  for (Client client : clientDao.getAllClients()) {
          //  System.out.println(client);
     //   }


          runApplication();

    }
}
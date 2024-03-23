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
    //    System.out.println(clientDao.getById(1L));
    //    Score score = new Score(0.01,0.01,0.01,
      //          new ExchangeRates(37.00, 38.5, 40.2, 41.00));
       // scoreDao.addScore(score);
     //   clientDao.addScoreToClient(score,clientDao.getById(1L));
       // Client client = clientDao.getById(1L);
      //  score.setClient(client);
      //  client.getScoreList().add(score);
      //  clientDao.updateClient(client);

      //  System.out.println(clientDao.getById(1L));

          runApplication();

    }
}
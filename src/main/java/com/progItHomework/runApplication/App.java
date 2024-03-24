package com.progItHomework.runApplication;

import com.progItHomework.dto.ClientDao;
import com.progItHomework.dto.ClientDaoImpl;
import com.progItHomework.dto.ScoreDao;
import com.progItHomework.dto.ScoreDaoImp;
import com.progItHomework.entity.Client;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;

import static com.progItHomework.runApplication.Application.runApplication;
import static com.progItHomework.utils.Util.createClientsAndScores;
import static com.progItHomework.utils.Util.getRandomDouble;


public class App {
    public static void main(String[] args) {

   /*    ClientDao clientDao = new ClientDaoImpl();
        ScoreDao scoreDao = new ScoreDaoImp();

        clientDao.createSomeClients(5);
      //  scoreDao.createSomeScores(5);
       // createClientsAndScores(clientDao,scoreDao);

        Score score = new Score(1.0, 1.0, 2.0,
                new ExchangeRates(37.00, 38.5, 40.2, 41.00));
        Score score2 = new Score(1.0, 1.0, 1.0,
                new ExchangeRates(37.00, 38.5, 40.2, 41.00));
        clientDao.addScoreToClient(score,clientDao.getById(1L));
        clientDao.addScoreToClient(score2,clientDao.getById(1L));

       System.out.println(clientDao.getById(1L).getScoreList()); // first client has 3 score
        System.out.println(scoreDao.allYourMoneyInUan(scoreDao.getById(1L).getClient().getScoreList())); */
        //  for (Client client : clientDao.getAllClients()) {
       //   System.out.println(client);
       //    }


          runApplication();

    }
}
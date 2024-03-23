package com.progItHomework;

import com.progItHomework.dto.ClientDao;
import com.progItHomework.dto.ClientDaoImpl;
import com.progItHomework.dto.ScoreDao;
import com.progItHomework.dto.ScoreDaoImp;
import com.progItHomework.entity.Client;

import static com.progItHomework.Util.createClientsAndScores;


public class App {
    public static void main(String[] args) {

        ClientDao clientDao = new ClientDaoImpl();
        ScoreDao scoreDao = new ScoreDaoImp();

        clientDao.createSomeClients(5);
        scoreDao.createSomeScores(5);
        createClientsAndScores(clientDao,scoreDao);

      //  for (Client client : clientDao.getAllClients()) {
        //    System.out.println(client);
      //  }
        System.out.println(clientDao.getById(1L));
       // scoreDao.updateScoreInUsd(scoreDao.getById(1L),9999.33);
       // scoreDao.updateScoreInEuro(scoreDao.getById(1L),9999.33);
      //  scoreDao.updateScoreInUan(scoreDao.getById(1L),9999.33);
        scoreDao.allYourManyInUan(scoreDao.getById(1L));
        System.out.println(clientDao.getById(1L));

    }
}
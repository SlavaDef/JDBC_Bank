package com.progItHomework.runApplication;

import static com.progItHomework.runApplication.Application.runApplication;


public class App {
    public static void main(String[] args) {

    /*   ClientDao clientDao = new ClientDaoImpl();
        ScoreDao scoreDao = new ScoreDaoImp();

        clientDao.createSomeClients(5);
     //   scoreDao.createSomeScores(5);
      //  createClientsAndScores(clientDao,scoreDao);

        Score score = new Score(1.0, 1.0, 2.0,
                new ExchangeRates(37.00, 38.5, 40.2, 41.00));
        Score score2 = new Score(1.0, 1.0, 1.0,
                new ExchangeRates(37.00, 38.5, 40.2, 41.00));
        clientDao.addScoreToClient(score,clientDao.getById(1L));
        clientDao.addScoreToClient(score2,clientDao.getById(1L));

       System.out.println(clientDao.getById(1L).getScoreList()); // first client has 2 score

        System.out.println(clientDao.getClientByPassport("HH:002220"));
        Client client = clientDao.getById(1L);
       // System.out.println(clientDao.getClientByPassport("HH:002220").getId());


        scoreDao.updateAnotherScoreInUsd(client.getScoreList().get(0), client.getScoreList().get(1),0.5);



        System.out.println(client);  */


        //  for (Client client : clientDao.getAllClients()) {
       //   System.out.println(client);
       //    }


          runApplication();

    }
}
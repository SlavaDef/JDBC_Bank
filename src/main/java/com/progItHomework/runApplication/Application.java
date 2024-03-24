package com.progItHomework.runApplication;

import com.progItHomework.dto.ClientDao;
import com.progItHomework.dto.ClientDaoImpl;
import com.progItHomework.dto.ScoreDao;
import com.progItHomework.dto.ScoreDaoImp;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;

import java.util.Scanner;

import static com.progItHomework.utils.Util.createClientsAndScores;

public class Application {

    public static void runApplication() {

        Long userId = 1L;
        try (Scanner sc = new Scanner(System.in)) {

            ClientDao clientDao = new ClientDaoImpl();
            ScoreDao scoreDao = new ScoreDaoImp();

            clientDao.createSomeClients(5);
            scoreDao.createSomeScores(5);
            createClientsAndScores(clientDao, scoreDao);

            while (true) {
                System.out.println("1: Get score info");
                System.out.println("2: Get count in UAN");
                System.out.println("3: Refill score in USD?");
                System.out.println("4: Refill score in EUR?");
                System.out.println("5: Refill score in UAN?");
                System.out.println("6: Create/Add score");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter your passport ");
                        String passport = sc.nextLine();
                        userId = clientDao.getClientByPassport(passport).getId();
                        System.out.println(clientDao.getClientByPassport(passport).getScoreList());
                        break;
                    case "2":
                        System.out.println("Your count is " +
                                scoreDao.allYourMoneyInUan(scoreDao.getById(userId).getClient().getScoreList())+ "_uans");
                        break;
                    case "3":
                        System.out.print("Enter how many dollars you want to deposit? ");
                        String usd = sc.nextLine();
                        double usD = Double.parseDouble(usd);
                        scoreDao.updateScoreInUsd(scoreDao.getById(userId), usD);
                        break;
                    case "4":
                        System.out.print("Enter how many euros you want to deposit ");
                        String eur = sc.nextLine();
                        double euR = Double.parseDouble(eur);
                        scoreDao.updateScoreInEuro(scoreDao.getById(userId), euR);
                        break;
                    case "5":
                        System.out.print("Enter how many uans you want to deposit ");
                        String uan = sc.nextLine();
                        double uaN = Double.parseDouble(uan);
                        scoreDao.updateScoreInUan(scoreDao.getById(userId), uaN);
                        break;
                    case "6":
                        Score score = new Score(0.01, 0.01, 0.01,
                                new ExchangeRates(37.00, 38.5, 40.2, 41.00));
                        clientDao.addScoreToClient(score, clientDao.getById(userId));
                        break;
                    default:
                        return;
                }

            }
        }
    }

}
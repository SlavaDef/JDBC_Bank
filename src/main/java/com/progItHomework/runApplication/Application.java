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
        String passport = "";
        try (Scanner sc = new Scanner(System.in)) {

            ClientDao clientDao = new ClientDaoImpl();
            ScoreDao scoreDao = new ScoreDaoImp();

            clientDao.createSomeClients(5);
            scoreDao.createSomeScores(5);
            createClientsAndScores(clientDao, scoreDao);

            while (true) {
                System.out.println("1: Get score info");
                System.out.println("2: Get count in UAN");
                System.out.println("3: Refill/money transfer score in USD?");
                System.out.println("4: Refill/money transfer score in EUR?");
                System.out.println("5: Refill/money transfer score in UAN?");
                System.out.println("6: Create/Add score");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter your passport ");
                        passport = sc.nextLine();
                        userId = clientDao.getClientByPassport(passport).getId();
                        System.out.println(clientDao.getClientByPassport(passport).getScoreList());
                        break;
                    case "2":
                        System.out.println("Your count is " +
                                scoreDao.allClientMoneyInUan(
                                        scoreDao.getById(userId).getClient().getScoreList()) + "_uans");
                        break;
                    case "3":
                        System.out.print("1 - refill, 2 - transit ");
                        String answer = sc.nextLine();
                        int ans = Integer.parseInt(answer);
                        if (ans == 1) {
                            System.out.print("Enter how many dollars you want to deposit? ");
                            String usd = sc.nextLine();
                            double usD = Double.parseDouble(usd);
                            scoreDao.updateScoreInUsdPlus(scoreDao.getById(userId), usD);
                        }
                        if (ans == 2) {  // TO-DO
                            System.out.print("How many? ");
                            String usd = sc.nextLine();
                            double usD = Double.parseDouble(usd);
                            scoreDao.updateScoreInUsdMinus(
                                    clientDao.getClientByPassport(passport).getScoreList().get(0), usD);
                            scoreDao.updateScoreInUsdPlus(
                                    clientDao.getClientByPassport(passport).getScoreList().get(1), usD);
                        }
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
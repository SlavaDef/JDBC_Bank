package com.progItHomework.utils;

import com.progItHomework.dto.ClientDao;
import com.progItHomework.dto.ScoreDao;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Util {


    public static String getRandomFullName() {
        List<String> list = Arrays.asList("Boris Jonson", "Junior Second", "Kait Midelton", "Ormando Banuchi",
                "Boby Faraday", "Pablo Eskobar", "Kristy.K", "Amanda Urega", "Sofi Terner");
        return list.get(ThreadLocalRandom.current().nextInt(9));
    }

    public static String getRandomPhone() {
        List<String> list = Arrays.asList("777-44-33", "555-23-10", "212-33-12", "897-36-77",
                "666-39-00", "122=44-33", "678-34-99", "777-88-99", "321-33-66");
        return list.get(ThreadLocalRandom.current().nextInt(9));
    }

    public static String getRandomAddress() {
        List<String> list = Arrays.asList("St.Djon street 3", "St.Bob street 45", "Junior street 12", "Games street 66",
                "Devil street 44", "Armstrong street 15", "Junior street 36", "Jesus street 19", "Tom.J.D street 28");
        return list.get(ThreadLocalRandom.current().nextInt(9));
    }

    public static String getRandomEmails() {
        List<String> list = Arrays.asList("Sidni@gmail.com", "Teg@gmail.com", "Archi234@gmail.com", "player66@gmail.com",
                "BigBoss@gmail.com", "Junior23@gmail.com", "Alfa33@gmail.com", "KillBill1@gmail.com", "234A5@gmail.com");
        return list.get(ThreadLocalRandom.current().nextInt(9));
    }

    public static Double getRandomDouble() {
        List<Double> list = Arrays.asList(88.23, 123.14, 333.99, 213.44, 678.50);
        return list.get(ThreadLocalRandom.current().nextInt(5));
    }

    public static void createClientsAndScores(ClientDao cl, ScoreDao sc){

        cl.addScoreToClient(sc.getById(1L), cl.getById(1L));
        cl.addScoreToClient(sc.getById(2L), cl.getById(2L));
        cl.addScoreToClient(sc.getById(3L), cl.getById(3L));
        cl.addScoreToClient(sc.getById(4L), cl.getById(4L));
        cl.addScoreToClient(sc.getById(5L), cl.getById(5L));
    }
}

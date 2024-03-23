package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;
import com.progItHomework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.progItHomework.Util.*;

public class ScoreDaoImp implements ScoreDao{

    @Override
    public Score addScore(Score score) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(score);
            transaction.commit();
            return score;
        }
    }

    @Override
    public Score getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Score.class, id);
        }
    }

    @Override
    public void createSomeScores(int count) {
        for (int i = 0; i < count; i++) {
            addScore(new Score(getRandomDouble(),getRandomDouble(),getRandomDouble(),
                    new ExchangeRates(37.00,38.5,40.2,41.00)));
        }
    }

    @Override
    public Score updateScore(Score score) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.merge(score);
            tx1.commit();
            return score;
        }
    }
    @Override
   public Score updateScoreInUsd(Score score, Double usd){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            score.setUsd(usd);
            session.merge(score);
            tx1.commit();
            return score;
        }
   }

    @Override
    public Score updateScoreInEuro(Score score, Double eur) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            score.setEur(eur);
            session.merge(score);
            tx1.commit();
            return score;
        }
    }

    @Override
    public Score updateScoreInUan(Score score, Double uan) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            score.setUan(uan);
            session.merge(score);
            tx1.commit();
            return score;
        }
    }

    @Override
    public Score allYourManyInUan(Score score) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            // score.getExchangeRates().setBuy_USD(37.00);
          //  score.getExchangeRates().setSail_USD(38.00);
          //  score.getExchangeRates().setBuy_EUR(40.00);
          //  score.getExchangeRates().setSail_EUR(41.00);
            double usdUan = score.getExchangeRates().getBuy_USD();
            double eurUan = score.getExchangeRates().getBuy_EUR();
            score.getExchangeRates().setResult((score.getUsd()*usdUan) + (score.getEur()*eurUan)+score.getUan());
            session.merge(score);
            tx1.commit();
            return score;
        }
    }


}

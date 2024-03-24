package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;
import com.progItHomework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static com.progItHomework.Util.*;
import static org.hibernate.resource.transaction.spi.TransactionStatus.ACTIVE;
import static org.hibernate.resource.transaction.spi.TransactionStatus.MARKED_ROLLBACK;

public class ScoreDaoImp implements ScoreDao {

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
            addScore(new Score(getRandomDouble(), getRandomDouble(), getRandomDouble(),
                    new ExchangeRates(37.00, 38.5, 40.2, 41.00)));
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
    public Score updateScoreInUsd(Score score, Double usd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double money = score.getUsd();
            score.setUsd(money + usd);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
        return score;
    }

    @Override
    public Score updateScoreInEuro(Score score, Double eur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double myMoney = score.getEur();
            score.setEur(myMoney + eur);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
        return score;
    }

    @Override
    public Score updateScoreInUan(Score score, Double uan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double myMoney = score.getUan();
            score.setUan(myMoney + uan);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
        return score;

    }

    @Override
    public Score allYourManyInUan(Score score) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            double usdUan = score.getExchangeRates().getBuy_USD();
            double eurUan = score.getExchangeRates().getBuy_EUR();
            score.getExchangeRates().setResult((score.getUsd() * usdUan) + (score.getEur() * eurUan) + score.getUan());
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
        return score;
    }
}

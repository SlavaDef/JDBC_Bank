package com.progItHomework.dto.ScoreDao;

import com.progItHomework.dto.ScoreDao.ScoreDao;
import com.progItHomework.entity.ExchangeRates;
import com.progItHomework.entity.Score;
import com.progItHomework.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.progItHomework.utils.Util.*;
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
    public void createSomeScores(int count) { // create random Scores
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
    public void updateScoreInEuro(Score score, Double eur) {
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
    }

    @Override
    public void updateScoreInUan(Score score, Double uan) {
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
    }

    @Override
    public double allClientMoneyInUan(List<Score> scorelist) {
        double res = 0.01;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try (session) {
            for (Score score : scorelist) {
                double usdUan = score.getExchangeRates().getBuy_USD();
                double eurUan = score.getExchangeRates().getBuy_EUR();
                score.getExchangeRates().setResult((score.getUsd() * usdUan) + (score.getEur() * eurUan) + score.getUan());
                res += score.getExchangeRates().getResult() - 0.01;
                session.merge(score);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
        return res;
    }

    @Override
    public void updateScoreInUsdPlus(Score score, Double usd) {
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
    }

    @Override
    public void updateScoreInUsdMinus(Score score, Double usd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double money = score.getUsd();
            score.setUsd(money - usd);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void tranzitScoresInUSD(Score first, Score second, Double usd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            updateScoreInUsdMinus(first,usd);
            updateScoreInUsdPlus(second,usd);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateScoreInEURPlus(Score score, Double eur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double money = score.getEur();
            score.setEur(money + eur);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateScoreInEURMinus(Score score, Double eur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double money = score.getEur();
            score.setEur(money - eur);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void tranzitScoresInEUR(Score first, Score second, Double eur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            updateScoreInEURMinus(first,eur);
            updateScoreInEURPlus(second,eur);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateScoreInUANPlus(Score score, Double uan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double money = score.getUan();
            score.setUan(money + uan);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateScoreInUANMinus(Score score, Double uan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            Double money = score.getUan();
            score.setUan(money - uan);
            session.merge(score);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void tranzitScoresInUAN(Score first, Score second, Double uan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            updateScoreInUANMinus(first,uan);
            updateScoreInUANPlus(second,uan);
            transaction.commit();
            session.flush();
        } catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void convertClientMoneyFromUanToUsd(Score first, Score second, Double uan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
          double res = uan/first.getExchangeRates().getSail_USD();
            updateScoreInUANMinus(first,uan);
            updateScoreInUsdPlus(second,res);
            transaction.commit();
            session.flush();
        }catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void convertClientMoneyFromUanToEur(Score first, Score second, Double uan) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            double res = uan/first.getExchangeRates().getSail_EUR();
            updateScoreInUANMinus(first,uan);
            updateScoreInEURPlus(second,res);
            transaction.commit();
            session.flush();
        }catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void convertClientMoneyFromUsdToUan(Score first, Score second, Double usd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            double res = usd*first.getExchangeRates().getSail_USD();
            updateScoreInUsdMinus(first,usd);
            updateScoreInUANPlus(second,res);
            transaction.commit();
            session.flush();
        }catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void convertClientMoneyFromUsdToEur(Score first, Score second,Double usd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            double res = (usd*first.getExchangeRates().getSail_USD()) / first.getExchangeRates().getSail_EUR();
            updateScoreInUsdMinus(first,usd);
            updateScoreInEURPlus(second,res);
            transaction.commit();
            session.flush();
        }catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void convertClientMoneyFromEurToUan(Score first, Score second, Double eur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            double res = eur*first.getExchangeRates().getSail_EUR();
            updateScoreInEURMinus(first,eur);
            updateScoreInUANPlus(second,res);
            transaction.commit();
            session.flush();
        }catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void convertClientMoneyFromEurToUsd(Score first, Score second, Double eur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try (session) {
            double res = (eur*first.getExchangeRates().getSail_EUR()) / first.getExchangeRates().getSail_USD();
            updateScoreInEURMinus(first,eur);
            updateScoreInUsdPlus(second,res);
            transaction.commit();
            session.flush();
        }catch (Exception e) {
            if (transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK) {
                transaction.rollback();
            }
        }
    }


}

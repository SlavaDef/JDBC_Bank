package com.progItHomework.dto.ScoreDao;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.Score;

import java.util.List;

public interface ScoreDao {

    Score addScore(Score score);

    Score getById(Long id);

    void createSomeScores(int count);

    Score updateScore(Score score);

    void updateScoreInUsdPlus(Score score, Double usd);

    void updateScoreInEuro(Score score, Double eur);

    void updateScoreInUan(Score score, Double uan);

    double allClientMoneyInUan(List<Score> scorelist);

    void updateScoreInUsdMinus(Score score, Double usd);

    void tranzitScoresInUSD(Score first, Score second, Double usd);

    void updateScoreInEURPlus(Score score, Double eur);

    void updateScoreInEURMinus(Score score, Double eur);

    void tranzitScoresInEUR(Score first, Score second, Double eur);

    void updateScoreInUANPlus(Score score, Double uan);

    void updateScoreInUANMinus(Score score, Double uan);

    void tranzitScoresInUAN(Score first, Score second, Double uan);




}

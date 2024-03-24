package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.Score;

import java.util.List;

public interface ScoreDao {

    Score addScore(Score score);

    Score getById(Long id);

    void createSomeScores(int count);

    Score updateScore(Score score);

    void updateScoreInUsd(Score score, Double usd);

    void updateScoreInEuro(Score score, Double eur);

    void updateScoreInUan(Score score, Double uan);

    double allYourMoneyInUan(List<Score> scorelist);

    Score getByClientPassport(String passport);
}

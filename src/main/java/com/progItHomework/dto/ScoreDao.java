package com.progItHomework.dto;

import com.progItHomework.entity.Client;
import com.progItHomework.entity.Score;

public interface ScoreDao {

    Score addScore(Score score);

    Score getById(Long id);

    void createSomeScores(int count);

    Score updateScore(Score score);

    Score updateScoreInUsd(Score score, Double usd);
    Score updateScoreInEuro(Score score, Double eur);
    Score updateScoreInUan(Score score, Double uan);

    Score allYourManyInUan(Score score);
}

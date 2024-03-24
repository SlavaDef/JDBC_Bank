package com.progItHomework.utils;

public class Tables {


    public static final String CREATE_EXCHANGE_RATES = "CREATE TABLE exchangeRates " +
            "(buy_USD DOUBLE NOT NULL, sail_USD DOUBLE NOT NULL," +
            "buy_EUR DOUBLE NOT NULL, sail_EUR DOUBLE NOT NULL)";


    public static final String CREATE_CLIENTS = "CREATE TABLE clients " +
            "(client_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, client_fullName VARCHAR(50) NOT NULL," +
            "phone VARCHAR(20) NOT NULL, address VARCHAR(50) NOT NULL," +
            "email VARCHAR(20) NOT NULL, passport VARCHAR(20) NOT NULL )";

    public static final String CREATE_SCORES = "CREATE TABLE scores (score_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            "usd_score DOUBLE(9,4) NOT NULL, eur_score DOUBLE(9,4) NOT NULL, uan_score DOUBLE(9,4) NOT NULL )" ;

    public static final String PAROLL = "1234";

    public static final String MY_SQL = "jdbc:mysql://localhost/exchange?serverTimezone=Europe/Kiev";

    public static final String INSERT_USD = "INSERT INTO scores (usd_score) VALUES(?)";

}
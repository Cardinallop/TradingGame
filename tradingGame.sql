DROP DATABASE IF EXISTS tradingGame;
CREATE DATABASE tradingGame;

USE tradingGame;

CREATE TABLE item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    UNIQUE(name),
    initialPrice DECIMAL(9, 2) NOT NULL,
    currentPrice DECIMAL(9, 2) NOT NULL,
    accelerator int NOT NULL
);

CREATE TABLE difficulty (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30)
);

CREATE TABLE `user`(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30),
    UNIQUE(username),
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    money DECIMAL(9, 2) NOT NULL,
    difficultyId INT NOT NULL,
    FOREIGN KEY (difficultyId) REFERENCES difficulty(id)
);

CREATE TABLE itemUser(
    quantity INT NOT NULL,
    itemId INT NOT NULL,
    userId INT NOT NULL,
    PRIMARY KEY(itemId, userId),
    FOREIGN KEY (itemId) REFERENCES item(id),
    FOREIGN KEY (userId) REFERENCES user(id)

);

________________________________________________________________________________
Query:

INSERT INTO difficulty (name) VALUES ("easy"), ("medium"), ("hard");
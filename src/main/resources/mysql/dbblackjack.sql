CREATE DATABASE dbblackjack
DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE dbblackjack;

CREATE TABLE players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    registration_date DATETIME NOT NULL
);

CREATE TABLE dealers(
    id INT AUTO_INCREMENT PRIMARY KEY
);


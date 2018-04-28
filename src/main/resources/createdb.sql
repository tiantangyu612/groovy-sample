CREATE DATABASE IF NOT EXISTS weatherinfo;
USE weatherinfo;

DROP TABLE IF EXISTS weather;

CREATE TABLE weather (
  city        VARCHAR(100) NOT NULL,
  temperature INTEGER      NOT NULL
);

INSERT INTO weather (city, temperature) VALUES ('Austin', 48);
INSERT INTO weather (city, temperature) VALUES ('Baton Rouge', 57);
INSERT INTO weather (city, temperature) VALUES ('Jackson', 50);
INSERT INTO weather (city, temperature) VALUES ('Montgomery', 53);
CREATE TABLE IF NOT EXISTS board(
    ID int PRIMARY KEY,
    name varchar(255) NOT NULL,
    abbreviation varchar(2) NOT NULL,
    postsCount int NOT NULL DEFAULT 100000
);

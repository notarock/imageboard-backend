CREATE TABLE IF NOT EXISTS post(
    id bigint,
    title varchar(255),
    content text,
    uri varchar(255),
    createdAt timestamp NOT NULL DEFAULT NOW()
);

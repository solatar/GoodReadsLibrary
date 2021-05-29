DROP TABLE IF EXISTS allbooks cascade;
CREATE TABLE allbooks(
    id SERIAL PRIMARY KEY, 
    author VARCHAR(50), 
    title VARCHAR(255)
);

DROP TABLE IF EXISTS users cascade;
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    password VARCHAR(50),
    type INTEGER
);

DROP TABLE IF EXISTS loans;
CREATE TABLE loans (
    id SERIAL PRIMARY KEY,
    book_id INTEGER REFERENCES allbooks (id),
    user_id INTEGER REFERENCES users (id),
    expiration DATE
);
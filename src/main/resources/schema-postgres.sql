DROP TABLE IF EXISTS allbooks cascade;
CREATE TABLE allbooks(
    id SERIAL PRIMARY KEY, 
    author VARCHAR(50), 
    title VARCHAR(255),
    status VARCHAR(50)
);

DROP TABLE IF EXISTS users cascade;
CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(255)
);

DROP TABLE IF EXISTS roles cascade;
CREATE TABLE roles(
    id SERIAL PRIMARY KEY,
    description VARCHAR(255)
);

DROP TABLE IF EXISTS users_roles cascade;
CREATE TABLE users_roles(
    user_id INTEGER REFERENCES users (id),
    role_id INTEGER REFERENCES roles (id)
);


DROP TABLE IF EXISTS loans cascade;
CREATE TABLE loans(
    id SERIAL PRIMARY KEY, 
    book_id INTEGER REFERENCES allbooks (id),
    user_id INTEGER REFERENCES users (id),
    due_date DATE 
);
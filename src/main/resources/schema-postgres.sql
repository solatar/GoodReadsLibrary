DROP TABLE IF EXISTS allbooks cascade;
CREATE TABLE allbooks(
    id SERIAL PRIMARY KEY, 
    author VARCHAR(50), 
    title VARCHAR(255)
);



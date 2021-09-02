INSERT INTO allbooks(author, title, status) VALUES('Sujata Massey', 'The Widows of Malabar Hill', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Indrek Hargla', 'Apothecary Melchior and the ghost of Rataskaevu Street', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Daniel Silva', 'The Heist', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Azar Nafisi', 'Reading Lolita in Tehran', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Rajaa Alsanea', 'Girls of Riyadh', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Chetan Bhagat', 'Two States', 'unavailable');
INSERT INTO allbooks(author, title, status) VALUES('Jhumpa Lahiri', 'The Lowland', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Shirin Ebadi', 'Iran Awakening: A Memoir of Revolution and Hope', 'available');
INSERT INTO allbooks(author, title, status) VALUES('Roger Leloup', 'Archangels of Vinea', 'available');

INSERT INTO users(username, password) VALUES('Pihla', '$2a$10$IZPbqRgRev0Q8M09Pffv4eLs9JTeLUBm8yB657UWw6laz/ZqEYfJW');
INSERT INTO users(username, password) VALUES('Libby', '$2a$10$C6HldmGcZ8rkBc.UxcvwaeO6U5xoNjvgb2tqn0Rg0njidQALmQuBu');

INSERT INTO roles(description) VALUES('patron');
INSERT INTO roles(description) VALUES('librarian');

INSERT INTO users_roles(role_id, user_id) VALUES(1,1);
INSERT INTO users_roles(role_id, user_id) VALUES(2,2);

INSERT INTO loans(book_id, user_id, due_date) VALUES(6, 1, '30-09-2021');
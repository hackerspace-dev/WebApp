INSERT INTO users (id, date, name) values (1, now(), "pierwszy");
INSERT INTO users (id, date, name) values (2, now(), "Ela");

INSERT INTO users (id, date, name, password) values (3, now(), "admin", "admin");
INSERT INTO roles (name, role, user_id) values ("admin", "admin", 3);
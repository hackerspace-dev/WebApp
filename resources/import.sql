INSERT INTO users (id, date, name) values (1, now(), "pierwszy");
INSERT INTO users (date, name) values (now(), "Ela");

INSERT INTO users (date, name, password) values (now(), "admin", "admin");
INSERT INTO roles (name, role) values ("admin", "admin");
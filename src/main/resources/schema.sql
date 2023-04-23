CREATE TABLE employees (
    id int AUTO_INCREMENT,
    name CLOB NOT NULL,
    role CLOB NOT NULL
);

INSERT INTO employees (name, role) VALUES ('Алексеев Андрей Мартынович', 'Оператор кино и телевидения');
INSERT INTO employees (name, role) VALUES ('Родионов Юлий Игоревич', 'Монтажник');
INSERT INTO employees (name, role) VALUES ('Беляев Гордей Альбертович', 'Диктор');
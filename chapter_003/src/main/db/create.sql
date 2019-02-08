DROP DATABASE IF EXISTS job4j;
CREATE DATABASE job4j;

\c job4j;

CREATE SCHEMA application;

CREATE TABLE application.role(
    role_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE application.state(
    state_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE application.user(
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role_id INTEGER REFERENCES application.role(role_id)
);

CREATE TABLE application.rule(
    rule_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE application.role_rule(
    role_rule_id SERIAL PRIMARY KEY,
    rule_id INTEGER REFERENCES application.rule(rule_id),
    role_id INTEGER REFERENCES application.role(role_id)
);

CREATE TABLE application.category(
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE application.item(
    item_id SERIAL PRIMARY KEY,
    category_id INTEGER REFERENCES application.category(category_id),
    state_id INTEGER REFERENCES application.state(state_id),
    description VARCHAR (100) NOT NULL,
    user_id INTEGER REFERENCES application.user(user_id) UNIQUE
);


CREATE TABLE application.comment(
    comment_id SERIAL PRIMARY KEY,
    comment_time TIMESTAMP NOT NULL,
    content VARCHAR(500) NOT NULL,
    item_id INTEGER REFERENCES application.item(item_id)
);

CREATE TABLE application.attachment(
    attachment_id SERIAL PRIMARY KEY,
    path VARCHAR(250) NOT NULL,
    item_id INTEGER REFERENCES application.item(item_id)
);



INSERT INTO application.role(name)
    VALUES('role 1'), ('role 2'), ('role 3');

INSERT INTO application.state(name)
    VALUES ('state 1'), ('state 2'), ('state 3');

INSERT INTO application.user(name, role_id)
    VALUES ('user 1', 1), ('user 2', 2), ('user 3', 3), ('user 1', 2);

INSERT INTO application.rule(name)
    VALUES ('rule 1'), ('rule 2'), ('rule 3');

INSERT INTO application.role_rule(rule_id, role_id)
    VALUES (1, 2), (1, 3), (2, 3);

INSERT INTO application.category(name)
    VALUES ('category 1'), ('category 2'), ('category 3');

INSERT INTO application.item(category_id, state_id, description, user_id)
    VALUES (1, 2, 'description 1', 1),
           (2, 1, 'description 2', 3),
           (3, 1, 'description 3', 2);

INSERT INTO application.comment(comment_time, content, item_id)
    VALUES ('2019-01-02 10:00:00', 'comment 1', 1),
           ('2019-01-05 19:05:05', 'comment 2', 2),
           ('2019-02-03 00:00:01', 'comment 3', 1);

INSERT INTO application.attachment(path, item_id)
    VALUES ('/tmp/data1.txt', 1),
           ('/home/user/file.pdf', 1),
           ('/etc/bin/hello.jar', 3);

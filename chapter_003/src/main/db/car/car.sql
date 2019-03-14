DROP DATABASE IF EXISTS job4j;
CREATE DATABASE job4j;

\c job4j;

CREATE SCHEMA application;

CREATE TABLE application.car_body(
    car_body_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE application.engine(
    engine_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE application.transmission(
    transmission_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);


CREATE TABLE application.machine(
    machine_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    car_body_id INTEGER REFERENCES application.car_body(car_body_id),
    engine_id INTEGER REFERENCES application.engine(engine_id),
    transmission_id INTEGER REFERENCES application.transmission(transmission_id)
);



INSERT INTO application.car_body(name)
    VALUES('car_body1'), ('car_body2'), ('car_body3');

INSERT INTO application.engine(name)
    VALUES ('engine1'), ('engine2'), ('engine3');

INSERT INTO application.transmission(name)
    VALUES ('transmission1'), ('transmissionr2'), ('transmission3');

INSERT INTO application.machine(name, car_body_id, engine_id, transmission_id)
    VALUES ('machine1', 1, 1, 1),
           ('machine2', 2, 3, 2);

SELECT m.machine_id, m.name AS machine_name,
    c_b.name AS carbody_name, t.name AS transmission_name, e.name AS engine_name
    FROM application.machine AS m
        INNER JOIN application.car_body AS c_b
            USING(car_body_id)
        INNER JOIN application.transmission AS t
            USING(transmission_id)
        INNER JOIN application.engine AS e
            USING(engine_id);

SELECT e.engine_id, e.name
    FROM application.engine AS e
        LEFT OUTER JOIN application.machine AS m
            USING(engine_id)
            WHERE m.machine_id is null;

SELECT t.transmission_id, t.name
    FROM application.transmission AS t
        LEFT OUTER JOIN application.machine AS m
            USING(transmission_id)
            WHERE m.machine_id is null;

SELECT c_b.car_body_id, c_b.name
    FROM application.car_body AS c_b
        LEFT OUTER JOIN application.machine AS m
            USING(car_body_id)
            WHERE m.machine_id is null;



DROP TABLE IF EXISTS employees;
CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');
CREATE TABLE employees
(
    id            SERIAL,
    first_name    VARCHAR(255) DEFAULT NULL,
    last_name     VARCHAR(255) DEFAULT NULL,

    gender        gender       DEFAULT NULL,

    department_id INT          DEFAULT NULL,
    job_title     VARCHAR(255) DEFAULT NULL,
    date_of_birth DATE         DEFAULT NULL,
    constraint check_gender check (gender in ('MALE', 'FEMALE')),
    PRIMARY KEY (id)

);

INSERT INTO employees (first_name, last_name, gender, department_id, job_title, date_of_birth)
VALUES ('Nina', 'Kravchuk', 'FEMALE', '123', 'manager', '2003-02-13'),
       ('Mikhail', 'Ivanchenko', 'MALE', '124', 'sales', '1986-09-20'),
       ('Andrei', 'Filimonov', 'MALE', '124', 'sales', '1997-11-17');

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



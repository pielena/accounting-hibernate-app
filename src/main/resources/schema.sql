CREATE DATABASE accounting;

CREATE USER accounting WITH PASSWORD 'accounting';

GRANT ALL PRIVILEGES ON DATABASE accounting TO accounting;
GRANT ALL PRIVILEGES ON SCHEMA public TO accounting;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO accounting;

CREATE TABLE customer
(
    id      SERIAL       NOT NULL PRIMARY KEY,
    name    VARCHAR(50)  NOT NULL,
    address VARCHAR(200) NOT NULL,
    tax_id  INT          NOT NULL
);

CREATE TABLE contract
(
    id          SERIAL         NOT NULL PRIMARY KEY,
    name        VARCHAR(50)    NOT NULL,
    subject     VARCHAR(50)    NOT NULL,
    sum         DECIMAL(10, 2) NOT NULL,
    comment     VARCHAR(1000)  NOT NULL,
    date        DATE           NOT NULL DEFAULT NOW(),
    customer_id INT            NOT NULL,

    CONSTRAINT contract_customer_FK FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE payment
(
    id           SERIAL         NOT NULL PRIMARY KEY,
    money_amount DECIMAL(10, 2) NOT NULL,
    time         TIMESTAMP      NOT NULL DEFAULT NOW(),
    contract_id  INT            NOT NULL,

    CONSTRAINT payment_contract_FK FOREIGN KEY (contract_id) REFERENCES contract (id)
);
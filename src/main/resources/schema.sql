CREATE TABLE IF NOT EXISTS customer
(
    id      SERIAL      NOT NULL PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    tax_id  INT         NOT NULL
);

CREATE TABLE IF NOT EXISTS contract
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    subject     VARCHAR(50) NOT NULL,
    sum         INT         NOT NULL,
    comment     VARCHAR(50) NOT NULL,
    date        DATE        NOT NULL,
    customer_id INT         NOT NULL,

    CONSTRAINT contract_customer_FK FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE IF NOT EXISTS payment
(
    id              SERIAL NOT NULL PRIMARY KEY,
    amount_of_money INT    NOT NULL,
    time            DATE   NOT NULL,
    contract_id     INT    NOT NULL,

    CONSTRAINT payment_contract_FK FOREIGN KEY (contract_id) REFERENCES contract (id)
);
INSERT INTO customer
VALUES (1, 'Mars Inc', '6885 Elm Street, McLean, Virginia 22101, United States', 19823558);
VALUES (2, 'Ferrero Co', 'Zona Ind. Pianodardina 83100 Avellino, Italy', 20934869);
VALUES (3, 'Hershey', '100 Crystal A Dr, Hershey, PA 17033, USA', 37824587);
VALUES (4, 'LINDT & SPRUNGLI (U.K.) LIMITED', '4717 Grand Avenue, Suite 700, Kansas City, MO 64112, USA', 42389878);
VALUES (5, 'Nestle', 'Nestle S.A., avenue Nestle 55, 1800 Vevey, Switzerland', 52350981);

INSERT INTO contract
VALUES (1, 'Delivery contract 132', 'Sugar', 100000, '30% prepayment, fixed 5% discount', '2022-01-23', 1);
VALUES (2, 'Delivery contract 133', 'Milk Powder', 200000, '30% prepayment, fixed 5% discount', '2022-02-22', 1);
VALUES (3, 'Delivery contract 134', 'Cocoa', 300000, '30% prepayment, fixed 5% discount', '2022-03-12', 1);
VALUES (4, 'Delivery contract 135', 'Milk Powder', 400000, '50% prepayment, fixed 10% discount', '2022-04-24', 2);
VALUES (5, 'Delivery contract 136', 'Sugar', 500000, '50% prepayment, fixed 10% discount', '2022-05-17', 2);

INSERT INTO payment
VALUES (1, 10000, '2022-02-02 12:15:13', 1);
VALUES (2, 20000, '2022-02-22 15:45:40', 1);
VALUES (3, 30000, '2022-03-03 11:01:12', 1);
VALUES (4, 40000, '2022-04-02 14:37:02', 2);
VALUES (5, 50000, '2022-05-02 10:59:01', 3);
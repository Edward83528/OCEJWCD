DROP DATABASE IF EXISTS ocejwcd;
CREATE DATABASE ocejwcd;
USE ocejwcd;

DROP TABLE IF EXISTS Member;

CREATE TABLE Member (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(32),
    LastName VARCHAR(32),
    BirthDate DATE,
    Bonus DECIMAL(8, 2)
);

INSERT INTO Member VALUES (1, 'Abhijit','Gopali','1956-06-01',70000.00);
INSERT INTO Member VALUES (2, 'Troy','Hammer','1965-03-31',102109.15);
INSERT INTO Member VALUES (3, 'Michael','Walton','1986-08-25',93400.20);
INSERT INTO Member VALUES (4, 'Thomas','Fitzpatrick','1961-09-22',75123.45);
INSERT INTO Member VALUES (5, 'Monica','Rose','1976-08-13',65000.00);
INSERT INTO Member VALUES (6, 'Simon','Johnson','1968-11-20',52000.00);
INSERT INTO Member VALUES (7, 'Code','Data','2013-07-01',98200.00);

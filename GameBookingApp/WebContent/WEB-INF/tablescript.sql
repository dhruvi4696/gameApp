

SQL> CREATE TABLE Games(gameId VARCHAR(5) PRIMARY KEY,gameName VARCHAR(30) UNIQU
E, location VARCHAR(20),gameDate DATE,AvSeats NUMBER(3),PriceTicket NUMBER(5,2));

SQL> INSERT INTO Games VALUES('1','COC','Home','13-Nov-17',150,250);

SQL> INSERT INTO Games VALUES('2','chess','college','01-dec-17',90,500);

SQL> INSERT INTO Games VALUES('3','shop','office','04-jan-16',80,650);

commit;

CREATE TABLE ITEM("NAME" VARCHAR(1) NOT NULL PRIMARY KEY, "PRICE" INTEGER)
CREATE TABLE OFFER("ID" INTEGER NOT NULL PRIMARY KEY,"ITEM" VARCHAR (1), "OFFER_SIZE" INTEGER, "OFFER_PRICE" INTEGER, OFFER_ITEM VARCHAR(1))
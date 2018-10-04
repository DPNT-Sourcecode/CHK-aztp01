INSERT INTO Item (name, price) VALUES ('A', 50);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (1, 3, 130, '');
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (2, 5, 200, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('A', 1)
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('A', 2)
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (2, 'A')
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (1, 'A')


INSERT INTO Item (name, price) VALUES ('B', 30);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (3, 2, 45, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('B', 3)
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (3, 'B')

INSERT INTO Item (name, price) VALUES ('C', 20);

INSERT INTO Item (name, price) VALUES ('D', 15);

INSERT INTO Item (name, price) VALUES ('E', 40);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (4, 2, 80, 'B');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('E', 4)
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (4, 'E')

INSERT INTO Item (name, price) VALUES ('F', 10);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (5, 2, 20, 'F');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('F', 5);
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (5, 'F')

INSERT INTO Item (name, price) VALUES ('G', 20);

INSERT INTO Item (name, price) VALUES ('H', 10);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (6, 5, 45, '');
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (7, 10, 80, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('H', 6);
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('H', 7);
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (7, 'H')
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (6, 'H')

INSERT INTO Item (name, price) VALUES ('I', 35);

INSERT INTO Item (name, price) VALUES ('J', 60);

INSERT INTO Item (name, price) VALUES ('K', 70);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (8, 2, 120, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('K', 8);
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (8, 'K')

INSERT INTO Item (name, price) VALUES ('L', 90);

INSERT INTO Item (name, price) VALUES ('M', 15);

INSERT INTO Item (name, price) VALUES ('N', 40);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (9, 3, 120, 'M');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('N', 9);
INSERT INTO Offer_Item (Offer_id, items_name) VALUES (9, 'N')

INSERT INTO Item (name, price) VALUES ('O', 10);

INSERT INTO Item (name, price) VALUES ('P', 50);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (10, 5, 200, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('P', 10);

INSERT INTO Item (name, price) VALUES ('Q', 30);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (11, 3, 80, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('Q', 11);

INSERT INTO Item (name, price) VALUES ('R', 50);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (12, 3, 150, 'Q');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('R', 12);

INSERT INTO Item (name, price) VALUES ('S', 30);
-- add group offer

INSERT INTO Item (name, price) VALUES ('T', 20);
-- add group offer

INSERT INTO Item (name, price) VALUES ('U', 40);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (13, 3, 120, 'U');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('U', 13);

INSERT INTO Item (name, price) VALUES ('V', 50);
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (14, 2, 90, '');
INSERT INTO Offer (id, offer_size, offer_price, offer_item) VALUES (15, 3, 130, '');
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('V', 14);
INSERT INTO Item_Offer (item_name, offers_id) VALUES ('V', 15);

INSERT INTO Item (name, price) VALUES ('W', 20);

INSERT INTO Item (name, price) VALUES ('X', 17);
--  add group offer

INSERT INTO Item (name, price) VALUES ('Y', 20);
-- add group offer

INSERT INTO Item (name, price) VALUES ('Z', 21);
-- add group offer

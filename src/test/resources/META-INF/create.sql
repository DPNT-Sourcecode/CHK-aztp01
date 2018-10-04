create table Item (name varchar(255) not null, price integer, primary key (name))
create table Item_Offer (Item_name varchar(255) not null, offers_id bigint not null)
create table Offer (id bigint not null, OFFER_ITEM varchar(255), OFFER_PRICE integer, OFFER_SIZE integer, primary key (id))
create table Offer_Item (Offer_id bigint not null, items_name varchar(255) not null)

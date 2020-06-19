DROP TABLE IF EXISTS public.appaka_commerce_warehouse_stock;
create table appaka_commerce_warehouse_stock
(
	sku varchar(255) not null,
	warehouse varchar(255) not null,
	quantity integer,

	constraint stock_pk primary key (sku, warehouse)
);
alter table appaka_commerce_warehouse_stock owner to username;
create unique index stock_sku_warehouse_uindex on appaka_commerce_warehouse_stock (sku, warehouse);


DROP TABLE IF EXISTS public.appaka_commerce_warehouse_transaction;
create table appaka_commerce_warehouse_transaction
(
	sku varchar(255),
	warehouse varchar(255),
	quantity integer,
	key varchar(255),
	inserted_at timestamp not null default now()
);
alter table appaka_commerce_warehouse_transaction owner to username;
create index transaction_inserted_at_index on appaka_commerce_warehouse_transaction (inserted_at);
create index transaction_sku_index on appaka_commerce_warehouse_transaction (sku);
create index transaction_sku_warehouse_index on appaka_commerce_warehouse_transaction (sku, warehouse);
create index transaction_warehouse_index on appaka_commerce_warehouse_transaction (warehouse);
create index transaction_key_index on appaka_commerce_warehouse_transaction (key);



CREATE TABLE ROOM(
  ROOM_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(16) NOT NULL,
  ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
  BED_INFO CHAR(2) NOT NULL
);

CREATE TABLE GUEST(
  GUEST_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)
);

CREATE TABLE RESERVATION(
  RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  ROOM_ID BIGINT NOT NULL,
  GUEST_ID BIGINT NOT NULL,
  RES_DATE DATE
);

ALTER TABLE RESERVATION ADD FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ROOM_ID);
ALTER TABLE RESERVATION ADD FOREIGN KEY (GUEST_ID) REFERENCES GUEST(GUEST_ID);
CREATE INDEX IDX_RES_DATE_ ON RESERVATION(RES_DATE);

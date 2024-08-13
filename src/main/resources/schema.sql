-- This schema file execute manually via any database cli before run the application
CREATE SCHEMA IF NOT EXISTS customer;
SET  search_path TO customer;

CREATE TABLE address (
    id BIGSERIAL PRIMARY KEY ,
    city VARCHAR NOT NULL ,
    city_zone VARCHAR NOT NULL
);

CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR NOT NULL ,
    email VARCHAR NOT NULL UNIQUE ,
    address_id BIGINT REFERENCES address (id) ON DELETE CASCADE
);

CREATE SEQUENCE product_id_seq START WITH 632913 INCREMENT BY 109499;

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY ,
    product_id BIGINT DEFAULT nextval('product_id_seq'),
    name VARCHAR NOT NULL ,
    model VARCHAR NOT NULL ,
    price VARCHAR NOT NULL
);

INSERT INTO products (name, model, price) VALUES ('camera','12-ab','25k');
INSERT INTO products (name, model, price) VALUES ('laptop','32-ab','55k');
INSERT INTO products (name, model, price) VALUES ('tv','902-ab','75k');
INSERT INTO products (name, model, price) VALUES ('trimmer','k2-ab','15k');
INSERT INTO products (name, model, price) VALUES ('tv','22-ab','55k');

CREATE TABLE reviews (
    id BIGSERIAL PRIMARY KEY ,
    content VARCHAR NOT NULL ,
    star DECIMAL NOT NULL ,
    product_primary_key BIGINT REFERENCES products (id) ON DELETE CASCADE
);

---

START TRANSACTION;

DROP TABLE IF EXISTS product_wish_list;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_type;
DROP TABLE IF EXISTS wish_list;


CREATE TABLE product_type (
	id serial primary key,
	type char(1) not null UNIQUE,
	name varchar(32) not null
);

CREATE TABLE product (
	sku varchar(10) primary key,
	product_type bigint not null,
	name varchar(64) not null,
	description text,
	perishable char(1) DEFAULT 'N',
	price numeric(6,2) not null,
	weight_in_lbs int,
	taxable boolean DEFAULT true,
	
	CONSTRAINT chk_perishable CHECK (perishable IN ('Y', 'N')),
	CONSTRAINT fk_product_product_type FOREIGN KEY (product_type) REFERENCES product_type(id)
);

CREATE TABLE wish_list (
	id serial primary key,
	name varchar(64) not null,
	date_created DATE DEFAULT current_date
);

CREATE TABLE product_wish_list (
	product_sku varchar(10),
	wish_list_id bigint,
	date_added DATE DEFAULT current_date,
	
	CONSTRAINT pk_product_wish_list PRIMARY KEY (product_sku, wish_list_id),
	CONSTRAINT fk_product_wish_list_sku FOREIGN KEY (product_sku) REFERENCES product(sku),
	CONSTRAINT fk_product_wish_list_id FOREIGN KEY (wish_list_id) REFERENCES wish_list(id)
);

-- We can trust the ids created by the sequence, only because the schema script DROPS everything and rebuilds it,
-- which restarts the sequence at 1 for all tables.
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'C', 'Clothing');  -- id 1
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'G', 'Grocery');   -- id 2
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'H', 'Home Goods');   -- id 3
INSERT INTO product_type(id, type, name) VALUES (DEFAULT, 'B', 'Book');   -- id 4

-- Insert Products
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('A01', 1, 'TE Blue Snuggie', 'A blanket, coat mix that does neither well.', 'N', 24.98, 6, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('C02', 2, 'TE Coffee', 'A delicious blend of blue java', 'Y', 8.99, 1, false);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('D4', 3, 'TE Coffee Mug', 'Perfect for containing java.', 'N', 5.55, 1, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('B003', 4, 'Surviving TE: The Book', 'A giant book detailing how to survive a bootcamp', 'N', 19.95, 11, true);
INSERT INTO product(
	sku, product_type, name, description, perishable, price, weight_in_lbs, taxable)
	VALUES ('BKSTD01', 4, 'TE Student Book', 'Student Text Book', 'N', 39.95, 5, false);

-- Insert wishlists
INSERT INTO wish_list (id, name, date_created) VALUES (DEFAULT, 'Wishlist One', current_date);
INSERT INTO wish_list (name) VALUES ('Things I need');
	
-- Add Items to WishList with id 1
INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('A01', 1, current_date);

INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('D4', 1, current_date);

-- Add Items to WishList with id 2
INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('B003', 2, current_date);

INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('D4', 2, current_date);

INSERT INTO product_wish_list (product_sku, wish_list_id, date_added)
VALUES ('BKSTD01', 2, current_date);
	
COMMIT;

-- Get all products (with product type) and wishlist name in wishlist 1
-- SELECT p.sku, pt.type, pt.name AS product_type, p.name AS product_name, p.description, 
-- 	p.perishable, p.price, p.weight_in_lbs, p.taxable, wl.name
-- FROM product p
-- JOIN product_type pt ON p.product_type = pt.id
-- JOIN product_wish_list pwl ON p.sku = pwl.product_sku
-- JOIN wish_list wl ON pwl.wish_list_id = wl.id
-- WHERE wl.id = 1;

-- Get the count of product and total value of the items for both wishlists
-- SELECT wish_list.name, COUNT(*) AS items_in_wishlist, SUM(price) 
-- FROM product
-- JOIN product_wish_list ON product.sku = product_wish_list.product_sku
-- JOIN wish_list ON product_wish_list.wish_list_id = wish_list.id
-- GROUP BY wish_list.id
-- ORDER BY items_in_wishlist DESC;
	
-- Get all product sku, name, price, and the name of any wishlist they are in 
-- ordered by price from the most expensive to the least
-- SELECT product.sku, product.name, product.price, wish_list.name
-- FROM product
-- LEFT JOIN product_wish_list ON product.sku = product_wish_list.product_sku
-- LEFT JOIN wish_list ON product_wish_list.wish_list_id = wish_list.id
-- ORDER BY product.price DESC;
	
-- Delete a product from a wishlist
-- DELETE FROM product_wish_list
-- WHERE product_sku = 'D4' AND wish_list_id = 2;
	
-- Get All Products with Product Type.  Ordered by the skus in alphabestic order
-- SELECT p.sku, pt.type, pt.name AS product_type, p.name AS product_name, p.description, 
-- 	p.perishable, p.price, p.weight_in_lbs, p.taxable
-- FROM product p
-- JOIN product_type pt ON p.product_type = pt.id
-- ORDER BY sku;
	
-- Update Wishlist One to a new name
-- UPDATE wish_list
-- SET name = 'Cool things'
-- WHERE name = 'Wishlist One';
	
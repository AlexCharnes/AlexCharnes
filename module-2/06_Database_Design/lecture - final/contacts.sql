--CREATE DATABASE contacts;
DROP TABLE IF EXISTS person_phone;
DROP TABLE IF EXISTS person_address;
DROP TABLE IF EXISTS person_email;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS email;
DROP TABLE IF EXISTS phone;

CREATE TABLE person (
	person_id serial primary key,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	middle_name varchar(100),
	last_updated timestamp DEFAULT current_timestamp
);

CREATE TABLE address (
	address_id serial primary key,
	street varchar(100) not null,
	street_two varchar(100),
	city varchar(100) not null,
	district varchar(50) not null,
	postal_code varchar(20) not null,
	country_code char(3) DEFAULT 'USA',
	type varchar(20),
	type_description varchar(255),
	
	CONSTRAINT chk_address_type CHECK (type IN ('HOME', 'WORK', 'SHIPPING', 'BILLING', 'OTHER')),
	CONSTRAINT check_address_type_desc CHECK ( (type = 'OTHER' AND type_description IS NOT NULL) 
											  OR (type != 'OTHER' AND type_description IS NULL) )
);

CREATE TABLE person_address (
	person_id bigint,
	address_id bigint,
	
	CONSTRAINT pk_person_address PRIMARY KEY (person_id, address_id),
	CONSTRAINT fk_person_address_address_id FOREIGN KEY (address_id) REFERENCES address(address_id),
	CONSTRAINT fk_person_address_person_id FOREIGN KEY (person_id) REFERENCES person(person_id)
);


CREATE TABLE email (
	email_address varchar(255) primary key,
	type varchar(20),
	type_description varchar(255),
	
	CONSTRAINT chk_email_type CHECK (type IN ('PERSONAL', 'WORK', 'SCHOOL', 'OTHER')),
	CONSTRAINT chk_email_type_desc CHECK ( (type = 'OTHER' AND type_description IS NOT NULL) OR 
										  (type != 'OTHER' AND type_description IS NULL) )
	
);

CREATE table person_email (
	person_id bigint,
	email_address varchar(255),
	
	CONSTRAINT pk_person_email PRIMARY KEY (person_id, email_address),
									-- (column on this table) REFERENCES other_table(column on other table)
	CONSTRAINT fk_person_email_person FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_email_address FOREIGN KEY (email_address) REFERENCES email(email_address)
);

CREATE TABLE phone (
	phone_id serial primary key,
	number varchar(20) not null,
	country_prefix varchar(5) DEFAULT '01',
	type varchar(20),
	type_description varchar(255),
	
	CONSTRAINT chk_phone_type CHECK (type IN ('WORK', 'HOME', 'PERSONAL', 'MOBILE', 'OTHER')),
	CONSTRAINT chk_phone_type_desc CHECK ( (type = 'OTHER' AND type_description IS NOT NULL) OR 
										  (type != 'OTHER' AND type_description IS NULL) )
);

CREATE TABLE person_phone (
	person_id bigint,
	phone_id bigint,
	
	CONSTRAINT pk_person_phone PRIMARY KEY (person_id, phone_id),
	CONSTRAINT fk_person_phone_person_id FOREIGN KEY (person_id) REFERENCES person(person_id),
	CONSTRAINT fk_person_phone_phone_id FOREIGN KEY (phone_id) REFERENCES phone(phone_id)
);





insert into address (street, city, district, postal_code, type, type_description) values 
('street', 'city', 'district', 'postalCode', 'HOME', null);


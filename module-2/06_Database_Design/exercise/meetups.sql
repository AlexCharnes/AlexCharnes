--DROP TABLE member;
--DROP TABLE interest_group;
--DROP TABLE event;
--DROP TABLE member_group;
--DROP TABLE group_event;


CREATE TABLE member (
	member_id bigint primary key,
	last_name varchar(50),
	first_name varchar(50),
	email varchar(100),
	phone_number varchar(15),
	date_of_birth varchar(10),
	email_reminder boolean
);

CREATE TABLE interest_group (
	group_number bigint primary key,
	group_name varchar(100),
	amount_of_members bigint

);

CREATE TABLE event (
	event_number bigint primary key,
	event_name varchar(50),
	description varchar(255),
	start_time_and_date varchar(100),
	duration_in_minutes bigint,
	group_running_event varchar(100),
	member_count bigint

);

CREATE TABLE member_group(
	member_id bigint primary key,
	group_number bigint,
	FOREIGN KEY (group_number) REFERENCES member(member_id)

);

CREATE TABLE group_event(
	group_number bigint primary key,
	event_number bigint,
	FOREIGN KEY (event_number) REFERENCES interest_group(group_number)

);


INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (1, 'Johnson', 'John', 'johnnyjohnson@something.com', '614-555-5456', '1972-04-06', false);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (2, 'Barker', 'Bob', 'bobsburgers@something.com', '614-555-5422', '1965-07-06', true);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (3, 'Scott', 'Blarney', 'bthaman@something.com', '614-555-7656', '1990-01-06', false);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (4, 'black', 'Sam', 'sammysandwich@something.com', '614-555-2345', '1972-04-06', false);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (5, 'Becker', 'James', 'hiimjames@something.com', '614-555-7652', '1950-12-06', false);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (6, 'Carr', 'hodja', 'hodgpodg@something.com', '614-555-9182', '1955-09-23', true);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (7, 'Belcher', 'Tina', 'tinasteaparty@something.com', '614-555-7477', '1996-07-27', true);

INSERT INTO member(member_id, last_name, first_name, email, phone_number, date_of_birth, email_reminder)
VALUES (8, 'Barnes', 'Greg', 'gregsgags@something.com', '614-555-8822', '1968-06-22', true);



INSERT INTO interest_group(group_number, group_name, amount_of_members)
VALUES (2276, 'The Alliance', 20637);

INSERT INTO interest_group(group_number, group_name, amount_of_members)
VALUES (2281, 'The Horde', 22854);

INSERT INTO interest_group(group_number, group_name, amount_of_members)
VALUES (2341, 'The Nuetrals', 7);



INSERT INTO event(event_number,	event_name,	description, start_time_and_date, duration_in_minutes, group_running_event, member_count)
VALUES(100, 'Warsung Gulch', 'PvP Event', 'March 10th, 2024 at 8 p.m.', 30, 'The Alliance', 40);

INSERT INTO event(event_number,	event_name,	description, start_time_and_date, duration_in_minutes, group_running_event, member_count)
VALUES(200, 'Drop Party', 'Item Giveaway', 'March 13th at 4 p.m.', 60, 'The Alliance', 50);

INSERT INTO event(event_number,	event_name,	description, start_time_and_date, duration_in_minutes, group_running_event, member_count)
VALUES(300, 'Networking', 'Come and meet new players!', 'March 16th, 2024 at 2 p.m.', 120, 'The Nuetral', 10);
create sequence users_id_seq
;

create table applications
(
	id serial not null
		constraint applications_id_pk
			primary key,
	title varchar(50) not null,
	text varchar(50) not null,
	date_create timestamp not null
)
;

create table users
(
	id serial not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	password varchar(100) not null,
	address varchar(50),
	username varchar(50) not null,
	date_birth date
)
;

create unique index users_username_uindex
	on users (username)
;

create table comments
(
	id serial not null
		constraint comments_pkey
			primary key,
	text varchar(50) not null
)
;

create table applications_comments
(
	application_id integer not null,
	comment_id integer not null
)
;

create table applications_users
(
	application_id integer not null,
	user_id integer not null
)
;

-- auto-generated definition
-- No source text available
create SEQUENCE applications_id_seq;
-- auto-generated definition
CREATE SEQUENCE users_id_seq;
-- auto-generated definition
-- No source text available
create sequence comments_id_seq;
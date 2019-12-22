create schema public
;

comment on schema public is 'standard public schema'
;

create table applications
(
	id integer not null
		constraint applications_id_pk
			primary key,
	title varchar(50) not null,
	text varchar(50)
)
;

create table users
(
	id serial not null
		constraint users_id_pk
			primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	password varchar(100) not null,
	address varchar(50),
	date_birth time not null,
	username varchar(50) not null
)
;

create unique index users_login_uindex
	on users (username)
;

create sequence users_id_seq;
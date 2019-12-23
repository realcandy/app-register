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
	id serial not null
	  	constraint users_id_pk
			  primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	password varchar(100) not null,
	address varchar(50),
	username varchar(50) not null,
	date_birth date
)
;

create table comments
(
	id serial not null
		constraint comments_id_pk
			primary key,
	text varchar(50) not null
)
;

create table applications_comments
(
	application_id integer not null
		constraint applications_comments_applications_id_fk
			references applications,
	comment_id integer not null
		constraint applications_comments_comments_id_fk
			references comments
)
;

create table applications_users
(
	application_id integer not null
		constraint applications_users_applications_id_fk
			references applications,
	user_id integer not null
		constraint applications_users_users_id_fk
			references users
)
;

--CREATE SEQUENCE public.applications_id_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE public.applications ALTER COLUMN id SET DEFAULT nextval('public.applications_id_seq');
ALTER SEQUENCE public.applications_id_seq OWNED BY public.applications.id;

--CREATE SEQUENCE public.users_id_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq');
ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;

--CREATE SEQUENCE public.comments_id_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE public.comments ALTER COLUMN id SET DEFAULT nextval('public.comments_id_seq');
ALTER SEQUENCE public.comments_id_seq OWNED BY public.comments.id;
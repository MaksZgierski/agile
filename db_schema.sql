CREATE TABLE application_settings (
	id serial NOT NULL PRIMARY KEY,
	key varchar NOT NULL,
	value varchar NOT NULL
);

CREATE TABLE user_session (
	id serial NOT NULL PRIMARY KEY,
	user_id int NOT NULL REFERENCES application_user(id),
	token varchar NOT NULL,
	add_date timestamp NOT NULL
);

-- admin, standard user etc.
CREATE TABLE user_type (
	id serial NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	active boolean NOT NULL,
	add_date timestamp NOT NULL,
	last_modified timestamp
);

CREATE TABLE application_user (
	id serial NOT NULL PRIMARY KEY,
	login varchar NOT NULL,
	password varchar NOT NULL,
	name varchar NOT NULL,
	user_type_id int NOT NULL REFERENCES user_type(id),
	active boolean NOT NULL,
	add_date timestamp NOT NULL,
	last_modified timestamp
);

-- hospital, school etc.
CREATE TABLE place_type (
	id serial NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	active boolean NOT NULL,
	add_date timestamp NOT NULL,
	last_modified timestamp
);

CREATE TABLE place (
	id serial NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	place_type_id int NOT NULL REFERENCES place_type(id),
	owner_id int NOT NULL REFERENCES application_user(id),
	lat real NOT NULL,
	lon real NOT NULL,
	address varchar NOT NULL,
	description varchar,
	active boolean NOT NULL,
	add_date timestamp NOT NULL,
	last_modified timestamp
);

-- media, images mostly (.jpg, .png)
CREATE TABLE media (
	id serial NOT NULL PRIMARY KEY,
	place_id int NOT NULL REFERENCES place(id),
	local_link varchar NOT NULL,
	active boolean NOT NULL,
	add_date timestamp NOT NULL
);

-- convenience for disabled etc.
CREATE TABLE convenience (
	id serial NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	active boolean NOT NULL,
	add_date timestamp NOT NULL,
	last_modified timestamp
);

CREATE TABLE place_convenience (
	id serial NOT NULL PRIMARY KEY,
	place_id int NOT NULL REFERENCES place(id),
	convenience_id int NOT NULL REFERENCES convenience(id),
	active boolean NOT NULL,
	add_date timestamp NOT NULL
);

CREATE TABLE opinion (
	id serial NOT NULL PRIMARY KEY,
	user_id int NOT NULL REFERENCES application_user(id),
	place_id int NOT NULL REFERENCES place(id),
	rating int NOT NULL,
	comment varchar NOT NULL,
	add_date timestamp
);


INSERT INTO user_type VALUES(default, 'user', true, now());
INSERT INTO user_type VALUES(default, 'moderator', true, now());

INSERT INTO place_type VALUES(default, 'School', true, now());
INSERT INTO place_type VALUES(default, 'Hospital', true, now());


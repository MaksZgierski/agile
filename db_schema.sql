CREATE TABLE application_settings (
	id serial NOT NULL PRIMARY KEY,
	key varchar NOT NULL,
	value varchar NOT NULL
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

CREATE TABLE user_session (
	id serial NOT NULL PRIMARY KEY,
	user_id int NOT NULL REFERENCES application_user(id),
	token varchar NOT NULL,
	add_date timestamp NOT NULL
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

INSERT INTO convenience VALUES(default, 'Parking lot', true, now());
INSERT INTO convenience VALUES(default, 'Bike parking lot', true, now());
INSERT INTO convenience VALUES(default, 'Disabled conveniences', true, now());
INSERT INTO convenience VALUES(default, 'Child care', true, now());

INSERT INTO application_user VALUES(default, 'test@test', '098F6BCD4621D373CADE4E832627B4F6', 'test', 2, true, now());

INSERT INTO place VALUES(default, 'Place1', 1, 1, 51.723887, 19.462877, 'ul. Piotrkowska 100', 'Description of Place1', true, now());
INSERT INTO place VALUES(default, 'Place2', 2, 1, 51.724304, 19.454806, 'ul. Sienkiewicza 100', 'Description of Place2', true, now());

INSERT INTO place_convenience VALUES(default, 1, 1, true, now());
INSERT INTO place_convenience VALUES(default, 2, 1, true, now());
INSERT INTO place_convenience VALUES(default, 2, 2, true, now());

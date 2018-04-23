-- DELETE SCHEMA BOOKING_HOTELS_SCHEMA;
-- CREATE SCHEMA BOOKING_HOTELS_SCHEMA;

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.users
(
  username varchar(50) PRIMARY KEY,
  password varchar(100) NOT NULL,
  enabled boolean DEFAULT true,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
);

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.authorities
(
 id SERIAL PRIMARY KEY,
  username varchar(50) REFERENCES users(username),
  authority varchar(50) NOT NULL,

);

 CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.countries
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.cities
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL,
  country_id integer REFERENCES countries(id)
);

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.hotels
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL,
  city_id integer REFERENCES cities(id),
  category varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.room_categories
(
  id SERIAL PRIMARY KEY,
  name varchar(50) NOT NULL,
  description varchar(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.rooms
(
  id SERIAL PRIMARY KEY,
  number integer NOT NULL,
  hotel_id integer references hotels(id),
  room_category_id integer REFERENCES room_categories(id),
  price integer NOT NULL,
  persons integer NOT NULL
);

CREATE TABLE IF NOT EXISTS BOOKING_HOTELS_SCHEMA.booking
(
  id SERIAL PRIMARY KEY,
  room_id integer REFERENCES rooms(id),
  user_username varchar(50) REFERENCES users(username),
  total_sum integer NOT NULL,
  persons integer NOT NULL,
  date_begin TIMESTAMP NOT NULL,
  date_end TIMESTAMP NOT NULL
);
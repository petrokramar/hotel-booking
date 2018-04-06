INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('BobMarley', '{noop}1', 'true', 'Bob', 'Marley');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('JamesBond', '{noop}1', 'true', 'James', 'Bond');
INSERT INTO users(username, password, enabled, first_name, last_name)
VALUES('JohnLennon', '{noop}1', 'false', 'John', 'Lennon');

INSERT INTO authorities(username, authority)
VALUES('BobMarley', 'ROLE_ADMIN');
INSERT INTO authorities(username, authority)
VALUES('BobMarley', 'ROLE_MANAGER');
INSERT INTO authorities(username, authority)
VALUES('BobMarley', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('JamesBond', 'ROLE_MANAGER');
INSERT INTO authorities(username, authority)
VALUES('JamesBond', 'ROLE_USER');
INSERT INTO authorities(username, authority)
VALUES('JohnLennon', 'ROLE_USER');

INSERT INTO room_categories(id, name, description)
VALUES('1', 'First', 'First category');
INSERT INTO room_categories(id, name, description)
VALUES('2', 'Second', 'Second category');
INSERT INTO room_categories(id, name, description)
VALUES('3', 'Third', 'Third category');
-- ALTER SEQUENCE room_category_id_seq RESTART WITH 4;

INSERT INTO countries(id, name)
VALUES('1', 'Egypt');
INSERT INTO countries(id, name)
VALUES('2', 'Turkey');
INSERT INTO countries(id, name)
VALUES('3', 'Tunisia');
-- ALTER SEQUENCE countris_id_seq RESTART WITH 4;

INSERT INTO cities(id, name, country_id)
VALUES('1', 'Hurhgada', '1');
INSERT INTO cities(id, name, country_id)
VALUES('2', 'Avsallar', '2');
INSERT INTO cities(id, name, country_id)
VALUES('3', 'Port el Cantaoui', '3');
INSERT INTO cities(id, name, country_id)
VALUES('4', 'Kemer', '2');
INSERT INTO cities(id, name, country_id)
VALUES('5', 'Marmaris', '2');
INSERT INTO cities(id, name, country_id)
VALUES('6', 'Alania', '2');
INSERT INTO cities(id, name, country_id)
VALUES('7', 'Belek', '2');
INSERT INTO cities(id, name, country_id)
VALUES('8', 'Side', '2');
-- ALTER SEQUENCE cities_id_seq RESTART WITH 9;

INSERT INTO hotels(id, name, city_id, category)
VALUES('1', 'Hurhgada hotel 1', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('2', 'Avsallar hotel 1', '2', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('3', 'Port el Cantaoui hotel 1', '3', 'THREE_STARS');
-- ALTER SEQUENCE hotels_id_seq RESTART WITH 4;

INSERT INTO rooms(id, number, hotel_id, room_category_id, price)
VALUES('1', '101', '1', '1', '300');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price)
VALUES('2', '201', '2', '2', '200');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price)
VALUES('3', '301', '3', '3', '100');

INSERT INTO hotel_services(id, name, description)
VALUES('1', 'Breakfast', 'Breakfast');
INSERT INTO hotel_services(id, name, description)
VALUES('2', 'Cleaning room', 'Cleaning room');

INSERT INTO booking(id, room_id, user_username, date_begin, date_end)
VALUES('1', '1', 'BobMarley', '2018-02-25', '2018-02-28');
INSERT INTO booking(id, room_id, user_username, date_begin, date_end)
VALUES('2', '2', 'JamesBond', '2018-02-28', '2018-03-05');

INSERT INTO booking_services(booking_id, service_id)
VALUES('1', '1');
INSERT INTO booking_services(booking_id, service_id)
VALUES('1', '2');
INSERT INTO booking_services(booking_id, service_id)
VALUES('2', '1');
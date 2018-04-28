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
INSERT INTO countries(id, name)
VALUES('4', 'Country 4');
INSERT INTO countries(id, name)
VALUES('5', 'Country 5');
INSERT INTO countries(id, name)
VALUES('6', 'Country 6');
INSERT INTO countries(id, name)
VALUES('7', 'Country 7');
INSERT INTO countries(id, name)
VALUES('8', 'Country 8');
INSERT INTO countries(id, name)
VALUES('9', 'Country 9');
INSERT INTO countries(id, name)
VALUES('10', 'Country 10');
INSERT INTO countries(id, name)
VALUES('11', 'Country 11');
INSERT INTO countries(id, name)
VALUES('12', 'Country 12');
INSERT INTO countries(id, name)
VALUES('13', 'Country 13');
INSERT INTO countries(id, name)
VALUES('14', 'Country 14');
INSERT INTO countries(id, name)
VALUES('15', 'Country 15');
INSERT INTO countries(id, name)
VALUES('16', 'Country 16');
INSERT INTO countries(id, name)
VALUES('17', 'Country 17');
INSERT INTO countries(id, name)
VALUES('18', 'Country 18');
INSERT INTO countries(id, name)
VALUES('19', 'Country 19');
INSERT INTO countries(id, name)
VALUES('20', 'Country 20');
INSERT INTO countries(id, name)
VALUES('21', 'Country 21');
INSERT INTO countries(id, name)
VALUES('22', 'Country 22');
INSERT INTO countries(id, name)
VALUES('23', 'Country 23');
INSERT INTO countries(id, name)
VALUES('24', 'Country 24');
INSERT INTO countries(id, name)
VALUES('25', 'Country 25');
INSERT INTO countries(id, name)
VALUES('26', 'Country 26');
INSERT INTO countries(id, name)
VALUES('27', 'Country 27');
INSERT INTO countries(id, name)
VALUES('28', 'Country 28');
INSERT INTO countries(id, name)
VALUES('29', 'Country 29');
INSERT INTO countries(id, name)
VALUES('30', 'Country 30');
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
INSERT INTO cities(id, name, country_id)
VALUES('9', 'City 9', '9');
INSERT INTO cities(id, name, country_id)
VALUES('10', 'City 10', '10');
INSERT INTO cities(id, name, country_id)
VALUES('11', 'City 11', '11');
INSERT INTO cities(id, name, country_id)
VALUES('12', 'City 12', '12');
INSERT INTO cities(id, name, country_id)
VALUES('13', 'City 13', '13');
INSERT INTO cities(id, name, country_id)
VALUES('14', 'City 14', '14');
INSERT INTO cities(id, name, country_id)
VALUES('15', 'City 15', '15');
INSERT INTO cities(id, name, country_id)
VALUES('16', 'City 16', '16');
INSERT INTO cities(id, name, country_id)
VALUES('17', 'City 17', '17');
INSERT INTO cities(id, name, country_id)
VALUES('18', 'City 18', '18');
INSERT INTO cities(id, name, country_id)
VALUES('19', 'City 19', '19');
INSERT INTO cities(id, name, country_id)
VALUES('20', 'City 20', '20');
INSERT INTO cities(id, name, country_id)
VALUES('21', 'City 21', '21');
INSERT INTO cities(id, name, country_id)
VALUES('22', 'City 22', '22');
INSERT INTO cities(id, name, country_id)
VALUES('23', 'City 23', '23');
INSERT INTO cities(id, name, country_id)
VALUES('24', 'City 24', '24');
INSERT INTO cities(id, name, country_id)
VALUES('25', 'City 25', '25');
INSERT INTO cities(id, name, country_id)
VALUES('26', 'City 26', '26');
INSERT INTO cities(id, name, country_id)
VALUES('27', 'City 27', '27');
INSERT INTO cities(id, name, country_id)
VALUES('28', 'City 28', '28');
INSERT INTO cities(id, name, country_id)
VALUES('29', 'City 29', '29');
INSERT INTO cities(id, name, country_id)
VALUES('30', 'City 30', '30');
-- ALTER SEQUENCE cities_id_seq RESTART WITH 9;

INSERT INTO hotels(id, name, city_id, category)
VALUES('1', 'Hurhgada hotel 1', '1', 'FIVE_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('2', 'Avsallar hotel 1', '2', 'FOUR_STARS');
INSERT INTO hotels(id, name, city_id, category)
VALUES('3', 'Port el Cantaoui hotel 1', '3', 'THREE_STARS');
-- ALTER SEQUENCE hotels_id_seq RESTART WITH 4;

INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('1', '101', '1', '1', '300', '1');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('2', '201', '2', '2', '200', '2');
INSERT INTO rooms(id, number, hotel_id, room_category_id, price, persons)
VALUES('3', '301', '3', '3', '100', '3');

INSERT INTO booking(id, room_id, user_username, total_sum, persons, date_begin, date_end)
VALUES('1', '1', 'BobMarley', '300', '1', '2018-02-25', '2018-02-28');
INSERT INTO booking(id, room_id, user_username, total_sum, persons,  date_begin, date_end)
VALUES('2', '2', 'JamesBond', '200', '2', '2018-02-28', '2018-03-05');
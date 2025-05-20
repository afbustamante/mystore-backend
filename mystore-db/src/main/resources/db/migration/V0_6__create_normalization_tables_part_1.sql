CREATE TABLE actors
(
    actor_id   SERIAL NOT NULL,
    first_name varchar(50),
    last_name  varchar(50)
);

ALTER TABLE actors ADD CONSTRAINT pk_actors PRIMARY KEY (actor_id);

CREATE TABLE countries
(
    country_id SERIAL      NOT NULL,
    name       varchar(50) NOT NULL,
    region     smallint    NOT NULL
);

ALTER TABLE countries ADD CONSTRAINT pk_countries PRIMARY KEY (country_id);

CREATE TABLE cities
(
    city_id    SERIAL      NOT NULL,
    name       varchar(50) NOT NULL,
    state      varchar(50),
    country_id integer     NOT NULL
);

ALTER TABLE cities ADD CONSTRAINT pk_cities PRIMARY KEY (city_id);
ALTER TABLE cities ADD CONSTRAINT fk_cities_country FOREIGN KEY (country_id) REFERENCES countries (country_id);

CREATE TABLE addresses
(
    address_id  SERIAL      NOT NULL,
    line_1      varchar(50) NOT NULL,
    line_2      varchar(50),
    postal_code varchar(9),
    city_id     integer     NOT NULL
);

ALTER TABLE addresses ADD CONSTRAINT pk_addresses PRIMARY KEY (address_id);
ALTER TABLE addresses ADD CONSTRAINT fk_addresses_city FOREIGN KEY (city_id) REFERENCES cities (city_id);

CREATE TABLE film_actors
(
    film_id  integer NOT NULL,
    actor_id integer NOT NULL
);

ALTER TABLE film_actors ADD CONSTRAINT pk_film_actors PRIMARY KEY (film_id, actor_id);
ALTER TABLE film_actors ADD CONSTRAINT fk_film_actors_actor FOREIGN KEY (actor_id) REFERENCES actors (actor_id);
ALTER TABLE film_actors ADD CONSTRAINT fk_film_actors_film FOREIGN KEY (film_id) REFERENCES products (product_id);

CREATE TABLE users
(
    user_id  SERIAL      NOT NULL,
    username varchar(20) NOT NULL,
    password varchar(64) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT pk_users PRIMARY KEY (user_id);
ALTER TABLE users ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE customers ADD COLUMN address_id INTEGER;
ALTER TABLE customers ADD COLUMN user_id INTEGER;
ALTER TABLE customers ADD CONSTRAINT fk_customers_address FOREIGN KEY (address_id) REFERENCES addresses (address_id);
ALTER TABLE customers ADD CONSTRAINT fk_customers_user FOREIGN KEY (user_id) REFERENCES users (user_id);

ALTER TABLE products ALTER COLUMN category_id TYPE integer;

-- Fill some tables that only need a simple select statement
INSERT INTO users (username, password)
SELECT DISTINCT username, password FROM customers;

INSERT INTO actors (first_name, last_name)
SELECT DISTINCT split_part(actor, ' ', 1) as first_name, split_part(actor, ' ', 2) as last_name FROM products ORDER BY first_name, last_name;

INSERT INTO countries (name, region)
SELECT DISTINCT country, region FROM customers ORDER BY country;

UPDATE customers c SET user_id = (SELECT user_id FROM users u WHERE u.username = c.username);

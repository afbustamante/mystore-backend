-- Migrate cities
create or replace procedure migrate_cities()
    language plpgsql
as $$
declare
    r RECORD;
begin
    for r in select country_id, name from countries loop
        insert into cities (name, country_id, state)
            select distinct c.city, r.country_id, c.state from customers c where c.country = r.name order by c.city, c.state;
    end loop;
end;
$$;

call migrate_cities();

-- Migrate addresses
create or replace procedure migrate_addresses()
    language plpgsql
as $$
declare
    r RECORD;
begin
    for r in select ci.city_id, ci.country_id, ci.name as city_name, co.name as country_name from cities ci inner join countries co on co.country_id = ci.country_id loop
        insert into addresses (line_1, line_2, postal_code, city_id)
            select distinct cu.address_1, cu.address_2, cu.zip, r.city_id
            from customers cu
            where cu.country = r.country_name and cu.city = r.city_name;
    end loop;
end;
$$;

call migrate_addresses();

-- Update customers addresses
create or replace procedure update_customers_addresses()
    language plpgsql
as $$
declare
    r RECORD;
begin
    for r in select a.address_id, a.line_1, a.line_2, a.postal_code, a.city_id, c.name as city_name, co.name as country_name from addresses a inner join cities c on c.city_id = a.city_id inner join countries co on co.country_id = c.country_id loop
        update customers set address_id = r.address_id
            where r.line_1 = address_1 and r.line_2 = address_2 and r.postal_code = zip and r.city_name = city and r.country_name = country;
    end loop;
end;
$$;

call update_customers_addresses();

-- Migrate actors by film
create or replace procedure migrate_film_actors()
    language plpgsql
as $$
declare
    r RECORD;
begin
    for r in select actor_id, first_name || ' ' || last_name as full_name from actors loop
        insert into film_actors (film_id, actor_id)
            select product_id, r.actor_id from products where actor = r.full_name;
    end loop;
end;
$$;

call migrate_film_actors();

-- Set mandatory fields
alter table customers alter column address_id set not null;
alter table customers alter column address_id set not null;

-- Drop useless columns
alter table customers drop column username;
alter table customers drop column password;
alter table customers drop column address_1;
alter table customers drop column address_2;
alter table customers drop column city;
alter table customers drop column zip;
alter table customers drop column state;
alter table customers drop column country;
alter table customers drop column region;
alter table customers drop column credit_card_type;
alter table customers drop column credit_card_number;
alter table customers drop column credit_card_expiration_date;

-- Drop temporary procedures
drop procedure migrate_cities;
drop procedure migrate_addresses;
drop procedure migrate_film_actors;
drop procedure update_customers_addresses;

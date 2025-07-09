ALTER TABLE customers ADD COLUMN birth_date DATE;

UPDATE customers
SET birth_date = cast(now() - cast(age || ' years' as interval) - cast(cast(random() as numeric(5,4)) || ' years' as interval) as date);

ALTER TABLE customers DROP COLUMN age;

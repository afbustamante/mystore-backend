ALTER TABLE products ALTER COLUMN special TYPE boolean USING special::integer::boolean;

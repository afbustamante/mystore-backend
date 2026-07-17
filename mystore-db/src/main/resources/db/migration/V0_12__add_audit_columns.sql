ALTER TABLE actors ADD COLUMN created_by VARCHAR(20);
ALTER TABLE actors ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE actors ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE actors ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE addresses ADD COLUMN created_by VARCHAR(20);
ALTER TABLE addresses ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE addresses ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE addresses ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE customers ADD COLUMN created_by VARCHAR(20);
ALTER TABLE customers ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE customers ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE customers ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE inventory ADD COLUMN created_by VARCHAR(20);
ALTER TABLE inventory ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE inventory ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE inventory ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE orders ADD COLUMN created_by VARCHAR(20);
ALTER TABLE orders ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE orders ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE orders ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE order_items ADD COLUMN created_by VARCHAR(20);
ALTER TABLE order_items ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE order_items ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE order_items ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE products ADD COLUMN created_by VARCHAR(20);
ALTER TABLE products ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE products ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE products ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE reorders ADD COLUMN created_by VARCHAR(20);
ALTER TABLE reorders ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE reorders ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE reorders ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

ALTER TABLE users ADD COLUMN created_by VARCHAR(20);
ALTER TABLE users ADD COLUMN created_at TIMESTAMP WITH TIME ZONE;
ALTER TABLE users ADD COLUMN updated_by VARCHAR(20);
ALTER TABLE users ADD COLUMN updated_at TIMESTAMP WITH TIME ZONE;

UPDATE actors SET created_by = 'SYS', created_at = now();
UPDATE addresses SET created_by = 'SYS', created_at = now();
UPDATE customers SET created_by = 'SYS', created_at = now();
UPDATE inventory SET created_by = 'SYS', created_at = now();
UPDATE orders SET created_by = 'SYS', created_at = now();
UPDATE order_items SET created_by = 'SYS', created_at = now();
UPDATE products SET created_by = 'SYS', created_at = now();
UPDATE reorders SET created_by = 'SYS', created_at = now();
UPDATE users SET created_by = 'SYS', created_at = now();

ALTER TABLE actors ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE actors ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE addresses ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE addresses ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE customers ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE customers ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE inventory ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE inventory ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE orders ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE orders ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE order_items ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE order_items ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE products ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE products ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE reorders ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE reorders ALTER COLUMN created_by SET NOT NULL;

ALTER TABLE users ALTER COLUMN created_at SET NOT NULL;
ALTER TABLE users ALTER COLUMN created_by SET NOT NULL;

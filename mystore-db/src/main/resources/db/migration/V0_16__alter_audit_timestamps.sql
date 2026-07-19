ALTER TABLE addresses ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE addresses ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE customers ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE customers ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE inventory ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE inventory ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE orders ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE orders ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE order_items ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE order_items ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE products ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE products ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE reorders ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE reorders ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

ALTER TABLE users_ ALTER COLUMN created_at TYPE timestamp USING created_at::timestamp;
ALTER TABLE users_ ALTER COLUMN updated_at TYPE timestamp USING updated_at::timestamp;

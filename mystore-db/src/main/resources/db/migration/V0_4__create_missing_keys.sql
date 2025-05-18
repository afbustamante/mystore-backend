-- customers_history
ALTER TABLE customers_history
    ADD CONSTRAINT fk_customers_history_order FOREIGN KEY (order_id)
        REFERENCES orders (order_id);

CREATE INDEX ix_customers_history_order_id ON customers_history (order_id);

ALTER TABLE customers_history
    ADD CONSTRAINT fk_customers_history_product FOREIGN KEY (product_id)
        REFERENCES products (product_id);

CREATE INDEX ix_customers_history_product_id ON customers_history (product_id);

-- inventory
ALTER TABLE inventory
    ADD CONSTRAINT fk_inventory_product FOREIGN KEY (product_id)
        REFERENCES products (product_id);

-- orders_items
ALTER TABLE orders_items
    ADD CONSTRAINT pk_orders_items PRIMARY KEY (order_item_id, order_id);

ALTER TABLE orders_items
    ADD CONSTRAINT fk_orders_items_product FOREIGN KEY (product_id)
        REFERENCES products (product_id);

CREATE INDEX ix_orders_items_product_id ON orders_items (product_id);

-- products
ALTER TABLE products
    ADD CONSTRAINT fk_products_category FOREIGN KEY (category_id)
        REFERENCES categories (category_id);

CREATE INDEX ix_products_category_id ON products (category_id);

ALTER TABLE products
    ADD CONSTRAINT fk_products_common_product FOREIGN KEY (common_product_id)
        REFERENCES products (product_id);

CREATE INDEX ix_products_common_product_id ON products (common_product_id);

-- reorders
ALTER TABLE reorders
    ADD COLUMN reorder_id SERIAL NOT NULL;

ALTER TABLE reorders
    ADD CONSTRAINT pk_reorders PRIMARY KEY (reorder_id);

ALTER TABLE reorders
    ADD CONSTRAINT fk_reorders_product FOREIGN KEY (product_id)
        REFERENCES products (product_id);

CREATE INDEX ix_reorders_product_id ON reorders (product_id);

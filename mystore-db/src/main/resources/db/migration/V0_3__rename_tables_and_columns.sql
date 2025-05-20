ALTER TABLE categories RENAME COLUMN category TO category_id;
ALTER TABLE categories RENAME COLUMN categoryname TO name;

ALTER TABLE cust_hist RENAME TO customers_history;
ALTER TABLE customers_history RENAME COLUMN customerid to customer_id;
ALTER TABLE customers_history RENAME COLUMN orderid to order_id;
ALTER TABLE customers_history RENAME COLUMN prod_id to product_id;

ALTER TABLE customers RENAME COLUMN customerid TO customer_id;
ALTER TABLE customers RENAME COLUMN firstname TO first_name;
ALTER TABLE customers RENAME COLUMN lastname TO last_name;
ALTER TABLE customers RENAME COLUMN address1 TO address_1;
ALTER TABLE customers RENAME COLUMN address2 TO address_2;
ALTER TABLE customers RENAME COLUMN creditcardtype TO credit_card_type;
ALTER TABLE customers RENAME COLUMN creditcard TO credit_card_number;
ALTER TABLE customers RENAME COLUMN creditcardexpiration TO credit_card_expiration_date;

ALTER TABLE inventory RENAME COLUMN prod_id TO product_id;
ALTER TABLE inventory RENAME COLUMN quan_in_stock TO quantity_in_stock;

ALTER TABLE orderlines RENAME TO order_items;
ALTER TABLE order_items RENAME COLUMN orderlineid TO order_item_id;
ALTER TABLE order_items RENAME COLUMN orderid TO order_id;
ALTER TABLE order_items RENAME COLUMN prod_id TO product_id;
ALTER TABLE order_items DROP COLUMN orderdate;

ALTER TABLE orders RENAME COLUMN orderid TO order_id;
ALTER TABLE orders RENAME COLUMN orderdate TO order_date;
ALTER TABLE orders RENAME COLUMN customerid TO customer_id;
ALTER TABLE orders RENAME COLUMN netamount TO net_amount;
ALTER TABLE orders RENAME COLUMN totalamount TO total_amount;

ALTER TABLE products RENAME COLUMN prod_id TO product_id;
ALTER TABLE products RENAME COLUMN category TO category_id;
ALTER TABLE products RENAME COLUMN common_prod_id TO common_product_id;

ALTER TABLE reorder RENAME TO reorders;
ALTER TABLE reorders RENAME COLUMN prod_id TO product_id;
ALTER TABLE reorders RENAME COLUMN date_low TO date_low_level;
ALTER TABLE reorders RENAME COLUMN quan_low TO quantity_low_level;
ALTER TABLE reorders RENAME COLUMN date_reordered TO reorder_date;
ALTER TABLE reorders RENAME COLUMN quan_reordered TO reordered_quantity;
ALTER TABLE reorders RENAME COLUMN date_expected TO expected_date;


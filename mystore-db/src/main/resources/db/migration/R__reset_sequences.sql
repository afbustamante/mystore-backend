SELECT setval('categories_category_id_seq', coalesce(max(category_id), 1000)) FROM categories;
SELECT setval('customers_customer_id_seq', coalesce(max(customer_id), 1000)) FROM customers;
SELECT setval('orders_order_id_seq', coalesce(max(order_id), 1000)) FROM orders;
SELECT setval('products_product_id_seq', coalesce(max(product_id), 1000)) FROM products;

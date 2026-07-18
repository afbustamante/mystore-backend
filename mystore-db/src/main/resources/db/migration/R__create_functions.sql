
-- pgsqlds2_create_db.sql: DVD Store Database Version 2.1 Build Script - Postgres version
-- Copyright (C) 2011 Vmware, Inc. 
-- Last updated 2/13/11

CREATE OR REPLACE FUNCTION BROWSE_BY_CATEGORY (
    IN batch_size_in INTEGER,
    IN category_in INTEGER
)
RETURNS SETOF PRODUCTS
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY SELECT * FROM PRODUCTS WHERE CATEGORY_ID = category_in AND SPECIAL IS TRUE LIMIT batch_size_in;
    RETURN;
END;
$$;

CREATE OR REPLACE FUNCTION BROWSE_BY_TITLE (
    IN batch_size_in INTEGER,
    IN title_in TEXT
)
RETURNS SETOF PRODUCTS
LANGUAGE plpgsql
AS $$
DECLARE
  vector_in TEXT;
BEGIN
    vector_in := replace(trim(both from title_in), ' ','&');
    RETURN QUERY SELECT * FROM PRODUCTS WHERE to_tsvector('simple', title) @@ to_tsquery(vector_in) LIMIT batch_size_in;
    RETURN;
END;
$$;

-- Drop old functions
DROP FUNCTION IF EXISTS browse_by_actor;
DROP FUNCTION IF EXISTS login;
DROP FUNCTION IF EXISTS new_customer;
DROP FUNCTION IF EXISTS purchase;

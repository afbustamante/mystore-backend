alter table users add column active boolean;

update users set active = true;

alter table users alter column active set not null;

alter table customers add column active boolean;

update customers set active = true;

alter table customers alter column active set not null;
alter table customers add constraint uc_customers_email unique (email);

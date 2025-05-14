# My Store App

Spring Boot and Spring Data JPA project based on [Dell DVD Store Database](https://linux.dell.com/dvdstore/) for PostgreSQL.

This project uses:

- Spring Boot 3.4
- Spring Data JPA 3.4
- Spring Framework 6.2
- Flyway 11.8
- Embedded H2 Database 2.3
- Built-on Maven

It requires Java 17+ and optionally a PostgreSQL Server 14+ in order to deploy the application with a
database server. You must use one of the Spring profiles available for these servers: `h2` to start with an H2 Embedded
database or `postgresql` to start with a PostgreSQL database.

## Building and running this project

In order to build this project for the first time, use the following command:

    $ ./mvnw clean install

After that, you can run the Spring Boot Web application using the following command:

    $ java -jar mystore-web/target/mystore-web.jar

### Running over PostgreSQL

In order to run the project with PostgreSQL, you must create a database named `ds2` and a superuser `ds2` to manipulate
the structure of the database using Flyway. Here is an exemple of script to start a new database for this project:

    create user ds2 with superuser;
    alter user ds2 with password 'ds2';
    create database ds2 owner ds2;

Also, you must create the user that will use the database from the application without DDL rights, juste a normal app
account, like this:

    create user web with password 'web';

Finally, you must start the app using the `postgresql` Spring profile:

    $ java -jar mystore-web/target/mystore-web.jar -Dspring.profiles.active=postgresql

*Note*: During the first start, some sample data will be loaded from the data.sql file. You must change the value of the
property `spring.sql.init.mode` to `never` in order to use the app after a restart. Otherwise, the app will try to read
the same file again, and you will get primary key violation messages. You can also remove the data.sql file if you do
not want sample data to be loaded in the database. Only the categories table should have some real data ready to use.

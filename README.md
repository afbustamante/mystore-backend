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

    $ java -jar mystore-web/target/myproject-web.jar

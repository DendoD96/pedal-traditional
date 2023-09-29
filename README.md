# pedal-traditional

`pedal-traditional` is an e-commerce application built with Java and uses SpringBoot and JBoss EAP for
- Overview of the company and it's products
- Sell E-Bikes
- Login and Account Management

## Tech Stack:
This project was developed using the following technologies;

- Java
- Spring Boot
- Thymeleaf rendering engine
- PostgresQL
- SQL Server
- HTTP for static pages
- Dynamic pages with JSP Tomcat via JBoss Webserver running on a RHEL box
- Middleware/Server - Middleware/server that acts as a legacy ‘back office’ applications (all JAVA applications running on JBoss EAP, Springboot, Hibernate) running on a RHEL box
-   JBoss EAP in Domain Mode,
-   JBoss EAP on a VM

### Deployment
- RHEL Based Monolith VM deployed on non-kubernetes env
- Rehost the VM on OpenShift using CNV

## Features for User

 1. Website pages
    -   Welcome page
	    -  Text and image based introduction to Pedal
	    -  List of bikes
	    - Login Page
	    - Create Account Page
2. Buy a bike page    
3. My Account page
	- Name, Email and Registration ID
    - Manage Account
    - Bike details - Make, Model, Year of manufacture, Date of Purchase
    

  

## To Run:

  

Ensure you the data requirements settled, then use the `mvnw` bin or IntelliJ runner to start the application.

  

### Database

The bike_commerce application uses two databases;

The SQL Server database should have the following table;

*  `employees` table for storing employees data

  

The postgresql database should have the following tables;

  

* bikes

* service_user

* bike_order

  

# Data Requirements;

  

This application uses PostgresQL and SQL Server databases with their datasources configured in the `com.example.bike_commerce.configuration` package. To connect with the databases, the `application.properties` file should have the following properties;

Ensure to replace the placeholders in the angle brackets

  

```yml

# POSTGRES DATABASE

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

spring.datasource.customers.url=<POSTGRES_DB_URL>

spring.datasource.customers.username=<POSTGRES_DB_USERNAME>

spring.datasource.customers.password=<POSTGRES_DB_PASSWORD>

  

# SQL SERVER DATABASE

spring.datasource.employees.url=<SQL_SERVER_URL>

spring.datasource.employees.username=<SQL_SERVER_USERNAME>

spring.datasource.employees.password=<SQL_SERVER_PASSWORD>

spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect

```

  

The `./ebike_data.sql` file contains SQL statements to create the columns within the aforementioned tables.

The image below also shows the data diagram;

  

<img  src="data-visualization.png"  alt="Data Visualization"  />

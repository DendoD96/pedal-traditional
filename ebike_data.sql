-- Create the 'bikes' table
CREATE TABLE IF NOT EXISTS bikes (
                                     id SERIAL PRIMARY KEY,
                                     name VARCHAR(100) NOT NULL,
    warranty_status CHAR(10),
    image BYTEA,
    model VARCHAR(50) NOT NULL,
    price INT NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

-- Create the 'service_user' table
CREATE TABLE IF NOT EXISTS service_user (
                                            id SERIAL PRIMARY KEY,
                                            fullname VARCHAR(150) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(75) NOT NULL,
    user_role VARCHAR(50) NOT NULL,
    password VARCHAR(75) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

-- Create the 'bike_order' table
CREATE TABLE IF NOT EXISTS bike_order (
                                          id SERIAL PRIMARY KEY,
                                          date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                          product_id INT NOT NULL,
                                          customer_id INT NOT NULL,
                                          price INT NOT NULL,
                                          CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES service_user(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES bikes(id)
    );
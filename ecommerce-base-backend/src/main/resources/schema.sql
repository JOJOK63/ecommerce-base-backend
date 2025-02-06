CREATE TABLE IF NOT EXISTS PRODUCTS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255),
    DESCRIPTION TEXT,
    PRICE DECIMAL,
    STOCK INT,
    WEIGHT DECIMAL,
    STATE VARCHAR(50),
    CREATED_AT TIMESTAMP,
    UPDATED_AT TIMESTAMP
);

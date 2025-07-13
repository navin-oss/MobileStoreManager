-- Create 'user' table
CREATE TABLE user (
    userid INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    password VARCHAR(100),
    city VARCHAR(50)
);

-- Create 'mobile' table
CREATE TABLE mobile (
    id INT PRIMARY KEY AUTO_INCREMENT,
    company VARCHAR(50),
    model VARCHAR(50),
    price DOUBLE
);

-- Create 'orders' table
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userid INT,
    mobile_id INT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userid) REFERENCES user(userid),
    FOREIGN KEY (mobile_id) REFERENCES mobile(id)
);

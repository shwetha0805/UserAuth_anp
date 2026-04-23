CREATE DATABASE auth_db1;

USE auth_db1;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    role VARCHAR(20)
);

desc users;

-- Insert admin
INSERT INTO users(username, password, role)
VALUES ('admin', 'admin123', 'ADMIN');

SELECT * FROM users;


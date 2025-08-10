
-- * SQL for creating table
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(50)
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255)
);

CREATE TABLE audit_logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    action VARCHAR(255),
    timestamp DATETIME
);

-- Insert sample students
INSERT INTO students (name, email, address, phone) VALUES
('Alice Johnson', 'alice.johnson@example.com', '123 Main St, Springfield', '555-1234'),
('Bob Smith', 'bob.smith@example.com', '456 Oak Ave, Metropolis', '555-5678'),
('Charlie Lee', 'charlie.lee@example.com', '789 Pine Rd, Gotham', '555-9012');

-- Insert sample books
INSERT INTO books (title, author) VALUES
('Introduction to Java', 'James Gosling'),
('Spring Boot in Action', 'Craig Walls'),
('Database Systems', 'C.J. Date');

-- Insert sample audit logs
INSERT INTO audit_logs (action, timestamp) VALUES
('Student Alice Johnson created', '2024-06-01 10:00:00'),
('Book "Introduction to Java" added', '2024-06-01 10:05:00'),
('Student Bob Smith updated', '2024-06-02 14:30:00');



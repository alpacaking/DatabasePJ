CREATE DATABASE IF NOT EXISTS canteen ; USE canteen;
-- 创建 User 表
CREATE TABLE IF NOT EXISTS User (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL,
                                    gender VARCHAR(10) NOT NULL,
                                    studentIdOrStaffId VARCHAR(20) NOT NULL,
                                    username VARCHAR(255) NOT NULL UNIQUE,
                                    password VARCHAR(255) NOT NULL
);

-- 创建 Merchant 表
CREATE TABLE IF NOT EXISTS Merchant (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        address VARCHAR(255) NOT NULL,
                                        username VARCHAR(255) NOT NULL UNIQUE,
                                        password VARCHAR(255) NOT NULL
);

-- 创建 Admin 表
CREATE TABLE IF NOT EXISTS Admin (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     username VARCHAR(255) NOT NULL UNIQUE,
                                     password VARCHAR(255) NOT NULL
);

-- 创建 Dish 表
CREATE TABLE IF NOT EXISTS Dish (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL,
                                    price DOUBLE NOT NULL,
                                    category VARCHAR(255) NOT NULL,
                                    description TEXT NOT NULL,
                                    image VARCHAR(255)
);

-- 创建 Order 表
CREATE TABLE IF NOT EXISTS `Order` (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       userId INT NOT NULL,
                                       merchantId INT NOT NULL,
                                       dishId INT NOT NULL,
                                       orderStatus VARCHAR(50) NOT NULL,
                                       FOREIGN KEY (userId) REFERENCES User(id),
                                       FOREIGN KEY (merchantId) REFERENCES Merchant(id),
                                       FOREIGN KEY (dishId) REFERENCES Dish(id)
);

-- 插入初始数据到 User 表
INSERT INTO User (name, gender, studentIdOrStaffId, username, password) VALUES
                                                                            ('Alice', 'Female', 'S001', 'alice', 'alicepass'),
                                                                            ('Bob', 'Male', 'S002', 'bob', 'bobpass'),
                                                                            ('Charlie', 'Male', 'S003', 'charlie', 'charliepass'),
                                                                            ('Diana', 'Female', 'S004', 'diana', 'dianapass'),
                                                                            ('Eve', 'Female', 'S005', 'eve', 'evepass');

-- 插入初始数据到 Merchant 表
INSERT INTO Merchant (name, address, username, password) VALUES
                                                             ('Merchant One', 'Address 1', 'merchant1', 'merchant1pass'),
                                                             ('Merchant Two', 'Address 2', 'merchant2', 'merchant2pass'),
                                                             ('Merchant Three', 'Address 3', 'merchant3', 'merchant3pass'),
                                                             ('Merchant Four', 'Address 4', 'merchant4', 'merchant4pass'),
                                                             ('Merchant Five', 'Address 5', 'merchant5', 'merchant5pass');

-- 插入初始数据到 Admin 表
INSERT INTO Admin (name, username, password) VALUES
                                                 ('Admin One', 'admin1', 'admin1pass'),
                                                 ('Admin Two', 'admin2', 'admin2pass'),
                                                 ('Admin Three', 'admin3', 'admin3pass'),
                                                 ('Admin Four', 'admin4', 'admin4pass'),
                                                 ('Admin Five', 'admin5', 'admin5pass');

-- 插入初始数据到 Dish 表
INSERT INTO Dish (name, price, category, description, image) VALUES
                                                                 ('Dish One', 10.50, 'Category 1', 'Description 1', 'image1.jpg'),
                                                                 ('Dish Two', 12.00, 'Category 2', 'Description 2', 'image2.jpg'),
                                                                 ('Dish Three', 15.75, 'Category 1', 'Description 3', 'image3.jpg'),
                                                                 ('Dish Four', 9.99, 'Category 3', 'Description 4', 'image4.jpg'),
                                                                 ('Dish Five', 11.20, 'Category 2', 'Description 5', 'image5.jpg');

-- 插入初始数据到 Order 表
INSERT INTO `Order` (userId, merchantId, dishId, orderStatus) VALUES
                                                                  (1, 1, 1, 'Pending'),
                                                                  (2, 2, 2, 'Completed'),
                                                                  (3, 3, 3, 'Cancelled'),
                                                                  (4, 4, 4, 'Pending'),
                                                                  (5, 5, 5, 'Completed');

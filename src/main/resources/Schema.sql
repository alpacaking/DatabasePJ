-- 用户表
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50) NOT NULL,
                       gender ENUM('M', 'F') NOT NULL,
                       role ENUM('student', 'staff', 'merchant', 'admin') NOT NULL,
                       username VARCHAR(20) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       student_id VARCHAR(20),
                       staff_id VARCHAR(20)
);

-- 商户表
CREATE TABLE merchants (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           address VARCHAR(255),
                           user_id INT,
                           FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 菜品表
CREATE TABLE dishes (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        price DECIMAL(10, 2) NOT NULL,
                        category VARCHAR(50),
                        description TEXT,
                        image_url VARCHAR(255),
                        merchant_id INT,
                        FOREIGN KEY (merchant_id) REFERENCES merchants(id)
);

-- 收藏表
CREATE TABLE favorites (
                           user_id INT,
                           dish_id INT,
                           PRIMARY KEY (user_id, dish_id),
                           FOREIGN KEY (user_id) REFERENCES users(id),
                           FOREIGN KEY (dish_id) REFERENCES dishes(id)
);

-- 订单表
CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT,
                        merchant_id INT,
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status ENUM('queued', 'completed') NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (merchant_id) REFERENCES merchants(id)
);

-- 订单项表
CREATE TABLE order_items (
                             order_id INT,
                             dish_id INT,
                             quantity INT,
                             PRIMARY KEY (order_id, dish_id),
                             FOREIGN KEY (order_id) REFERENCES orders(id),
                             FOREIGN KEY (dish_id) REFERENCES dishes(id)
);

-- 消息表
CREATE TABLE messages (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          user_id INT,
                          content TEXT,
                          sent_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 评价表
CREATE TABLE reviews (
                         user_id INT,
                         dish_id INT,
                         rating INT,
                         comment TEXT,
                         PRIMARY KEY (user_id, dish_id),
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (dish_id) REFERENCES dishes(id)
);

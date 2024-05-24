-- 插入一些初始用户数据
INSERT INTO users (name, gender, role, username, password, student_id, staff_id) VALUES
                                                                                     ('张三', '男', 'student', 'zhangsan', 'password123', 'S12345', NULL),
                                                                                     ('李四', '女', 'staff', 'lisi', 'password123', NULL, 'T67890'),
                                                                                     ('王五', '男', 'admin', 'wangwu', 'admin123', NULL, NULL);

-- 插入一些初始商户数据
INSERT INTO merchants (name, address, user_id) VALUES
                                                   ('商户A', '地址A', 2),
                                                   ('商户B', '地址B', 2);

-- 插入一些初始菜品数据
INSERT INTO dishes (name, price, category, description, image_url, merchant_id) VALUES
                                                                                    ('红烧肉', 20.0, '荤菜', '经典红烧肉', 'http://example.com/hongshaorou.jpg', 1),
                                                                                    ('青菜', 5.0, '素菜', '新鲜青菜', 'http://example.com/qingcai.jpg', 1);

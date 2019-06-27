# 管理员
INSERT INTO admin (username, password) VALUES ('admin','admin');

# 会员
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('2273461589@qq.com',2,284,'test',1,'Erica','18251838318',9713.370000000003,'test');
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('2544194336@qq.com',1,0,'test',1,'小寒','18251838318',10000,'test');
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('yeyuewangxuan@126.com',1,0,'test',1,'羡羡','18251838318',10000,'test');
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('361487214@qq.com',1,0,'test',1,'Jerry唐','15996235505',10000,'test');

# 地址
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (1,'2273461589@qq.com','鼓楼区','汉口路22号','南京市',1,'王轩','18251838318','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (2,'2273461589@qq.com','栖霞区','广州路8号','南京市',1,'王轩','18251838318','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (3,'2273461589@qq.com','江宁区','陶园南楼','南京市',1,'唐佳未','15996235505','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (6,'2273461589@qq.com','鼓楼区','南京大学鼓楼校区','南京市',1,'唐佳未','15996235505','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (19,'2273461589@qq.com','江宁区','东大九龙湖校区','南京市',1,'许杨','18260199930','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (20,'yeyuewangxuan@126.com','鼓楼区','南京大学','南京市',1,'许杨','18260199930','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (21,'2273461589@qq.com','浦口区','南京大学金陵学院','南京市',1,'王轩','18251838318','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (22,'361487214@qq.com','鼓楼区','南京大学陶园南楼','南京市',1,'Jerry唐','15996235505','江苏');

# 餐厅1信息
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('1877104','KFC','鼓楼区','珠江路2号','快餐便当',1,'南京市',4,'http://localhost:8000/images/upload/1877104.png','江苏',4.5);
# 餐厅1餐品
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (1,'1877104','黄金鸡块5块装','小食',11.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_1.jpg','精选鸡肉，香鲜酥脆');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (2,'1877104','醇香土豆泥','小食',6.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_2.jpg','细腻香浓，润滑可口');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (3,'1877104','葡式蛋挞经典1只装','小食',8,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_3.jpg','口感嫩滑，浓郁香甜');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (4,'1877104','百事可乐|中','饮品',9.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_4.jpg','主要原料：水、百事可乐糖浆、二氧化碳');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (5,'1877104','桃之恋乌龙茶','饮品',13.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_5.jpg','主要原料：茶，桃汁浓浆、桃丁罐头');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (6,'1877104','热辣香骨鸡','主食',11.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_6.jpg','热辣香骨鸡');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (7,'1877104','十翅分享桶','套餐',75,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_7.jpg','十块香辣鸡翅 x 1  百事可乐（中） x 2');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (8,'1877104','十块香辣鸡翅','主食',48,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_8.jpg','香辣多汁，口感鲜美');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (9,'1877104','比利时风味华夫','小食',9,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_9.jpg','香软的华夫，恰到好处的甜度，香浓醇厚');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (10,'1877104','香脆薯饼','小食',7,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_10.jpg','外脆里糯，浓浓薯香');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (11,'1877104','劲爆鸡米花','小食',11.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_11.jpg','劲爆鸡米花');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (12,'1877104','安心大油条','小食',6.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_12.jpg','香酥可口');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (13,'1877104','皮蛋瘦肉粥','主食',9.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_13.jpg','精选优质大米，配上皮蛋和五香瘦肉丝');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (14,'1877104','冰拿铁|中','饮品',16,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_14.jpg','精选阿拉比卡咖啡豆，新鲜现磨');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (15,'1877104','醇豆浆|热','饮品',9,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/1877104_15.jpg','主要原料：豆浆粉、水');
# 餐厅1订单
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (1,1,1,'2019-05-27 23:25:07',23.45,'2273461589@qq.com','1877104',1.05,0,0,0,'鼓楼区 汉口路22号','已送达', 5,'18260199930','无', 0, '王轩');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (1,1,1,1,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (2,1,4,1,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (2,1,1,'2019-05-30 23:25:07',23.45,'2273461589@qq.com','1877104',1.05,0,0,0,'鼓楼区 汉口路22号','已送达', 5,'18260199930','无', 0, '王轩');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (3,1,1,2,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (4,1,4,2,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (3,1,1,'2019-06-20 23:25:07',23.45,'2544194336@qq.com','1877104',1.05,0,0,0,'鼓楼区 汉口路22号','已送达', 5,'18260199930','无', 0, 'Jerry唐');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (5,1,1,3,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (6,1,4,3,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name)VALUES (4,1,1,'2019-06-21 23:25:07',22.25,'yeyuewangxuan@126.com','1877104',1.25,5,20,0,'鼓楼区 南京大学','已送达', 5,'18260199930','豆浆多加糖', 0, '许杨');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (7,1,10,4,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (8,1,9,4,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (9,1,15,4,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name)VALUES (5,1,1,'2019-06-27 23:25:07',22.25,'yeyuewangxuan@126.com','1877104',1.25,5,20,0,'鼓楼区 南京大学','已送达', 5,'18260199930','豆浆多加糖', 0, '许杨');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (10,1,10,5,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (11,1,9,5,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (12,1,15,5,1);

# 餐厅1折扣
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (1,20,50,'1877104','2019-12-31','2019-01-01');
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (2,5,20,'1877104','2019-12-31','2019-01-01');

# 餐厅2信息
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('348d04f','麦当劳','玄武区','珠江路4号中山大厦一楼','快餐便当',1,'南京市',1,'http://localhost:8000/images/upload/348d04f.jpg','江苏',3.0);
# 餐厅2餐品
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (16,'348d04f','麦辣鸡翅','小食',11.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_16.jpg','精选鸡肉，香鲜酥脆');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (17,'348d04f','可口可乐|中杯','饮品',9.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_17.jpg','可口可乐中杯 494ml');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (18,'348d04f','经典麦辣鸡腿汉堡','主食',20,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_18.jpg','经典麦辣鸡腿汉堡1份');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (19,'348d04f','巨无霸','主食',23,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_19.jpg','巨无霸1份');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (20,'348d04f','奥利奥麦旋风','小食',12.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_20.jpg','奥利奥麦旋风');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (21,'348d04f','香芋派','小食',7.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_21.jpg','香芋派1份');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (22,'348d04f','香芋派2个','套餐',12,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_22.jpg','香芋派 x 2');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (23,'348d04f','黑芝麻豆浆|大','饮品',12,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_23.jpg','黑芝麻豆浆（大）348ml');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (24,'348d04f','脆香油条','小食',6,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_24.jpg','脆香油条');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (25,'348d04f','鲜煮咖啡|大','饮品',11,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_25.jpg','鲜煮咖啡（大）348ml');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (26,'348d04f','那么大鸡排','小食',13,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_26.jpg','那么大鸡排1份');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (27,'348d04f','玉米杯','小食',13,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_27.jpg','玉米杯（大）1份');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (28,'348d04f','香芒芒','饮品',18,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_28.jpg','香芒芒1倍660ml');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (29,'348d04f','不素之霸双层牛肉堡','主食',21,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_29.jpg','不素之霸双层牛肉堡1份');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (30,'348d04f','麦香鱼','主食',9,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/348d04f_30.jpg','麦香鱼1份');
# 餐厅2折扣
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (3,20,50,'348d04f','2019-12-31','2019-01-01');
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (4,5,20,'348d04f','2019-12-31','2019-01-01');
# 餐厅2订单
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (6,1,1,'2019-05-27 23:25:07',23.45,'361487214@qq.com','348d04f',1.05,0,0,1,'鼓楼区 南京大学陶园南楼','等待商家接单', NULL,'15996235505','可乐去冰', 0, 'Jerry唐');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (13,1,16,6,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (14,1,17,6,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (7,1,1,'2019-06-01 23:25:07',23.45,'361487214@qq.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','已送达', 4,'15996235505','可乐去冰', 0, 'Jerry唐');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (15,1,16,7,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (16,1,17,7,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (8,1,1,'2019-06-05 23:25:07',23.45,'yeyuewangxuan@126.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','已送达', 5,'15996235505','可乐去冰', 0, '羡羡');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (17,1,16,8,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (18,1,17,8,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (9,0,0,'2019-06-07 23:25:07',23.45,'361487214@qq.com','348d04f',1.05,0,0,1,'鼓楼区 南京大学陶园南楼','已送达', NULL,'15996235505','可乐去冰', 0, 'Jerry唐');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (19,1,16,9,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (20,1,17,9,0);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (10,1,1,'2019-06-06 23:25:07',23.45,'361487214@qq.com','348d04f',1.05,0,0,1,'鼓楼区 南京大学陶园南楼','等待商家发货', NULL,'15996235505','无', 0, 'Jerry唐');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (21,1,22,10,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (22,1,25,10,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (11,1,1,'2019-06-07 23:25:07',23.45,'361487214@qq.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','等待商家发货', NULL,'15996235505','无', 0, 'Jerry唐');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (23,1,22,11,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (24,1,25,11,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (12,1,1,'2019-06-08 00:25:07',23.45,'2544194336@qq.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','等待商家发货', NULL,'18251838318','无', 0, '小寒');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (25,1,22,12,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (26,1,25,12,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (13,1,1,'2019-06-08 00:35:07',23.45,'2544194336@qq.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','等待商家发货', NULL,'18251838318','可乐去冰', 0, '小寒');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (27,1,16,13,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (28,1,17,13,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (14,1,1,'2019-06-08 00:37:07',23.45,'2544194336@qq.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','已送达', NULL,'18251838318','可乐去冰', 0, '小寒');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (29,1,16,14,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (30,1,17,14,1);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee, receiver_name) VALUES (15,1,1,'2019-06-08 00:45:07',23.45,'2544194336@qq.com','348d04f',1.05,0,0,0,'鼓楼区 南京大学陶园南楼','已送达', NULL,'18251838318','可乐去冰', 0, '小寒');
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (31,1,16,15,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (32,1,17,15,1);

# 餐厅3信息
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('41e8cea','CoCo都可（和会街店）','鼓楼区','和会街124号','甜品饮品',1,'南京市',0,'http://localhost:8000/images/upload/41e8cea.jpg','江苏',0);
# 餐厅3餐品
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (31,'41e8cea','珍珠奶茶|中杯','饮品',10,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_31.png','醇香奶茶中加入一颗颗香Q弹牙，嚼劲十足的珍珠');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (32,'41e8cea','奶茶三兄弟|中杯','饮品',11,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_32.jpg','醇香奶茶搭配香滑布丁、Q弹珍珠及鲜嫩口感的仙草冻');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (33,'41e8cea','芒果养乐多|大杯','饮品',16,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_33.jpg','果香浓郁，酸甜美味带来满满元气');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (34,'41e8cea','莓莓果茶|大杯','饮品',13,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_34.jpg','清新果香好美味');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (35,'41e8cea','戳戳鲜柚绿茶|大杯','饮品',16,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_35.jpg','轻轻一戳，把果粒戳出来更美味');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (36,'41e8cea','布丁奶茶|中杯','饮品',10,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_36.jpg','醇香奶茶中加入顺滑软嫩的布丁');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (37,'41e8cea','布丁奶茶|大杯','饮品',12,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_36.jpg','醇香奶茶中加入顺滑软嫩的布丁');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (38,'41e8cea','奶茶三兄弟|大杯','饮品',13,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_32.jpg','醇香奶茶搭配香滑布丁、Q弹珍珠及鲜嫩口感的仙草冻');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (39,'41e8cea','珍珠奶茶|大杯','饮品',12,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_31.jpg','醇香奶茶中加入一颗颗香Q弹牙，嚼劲十足的珍珠');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (40,'41e8cea','双拼奶茶|中杯','饮品',10,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_40.png','香Q弹牙的珍珠搭配顺滑软嫩的布丁，与醇香奶茶融合');
# 餐厅3折扣
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (5,7,25,'41e8cea','2019-12-31','2019-01-01');
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (6,5,20,'41e8cea','2019-12-31','2019-01-01');

# 餐厅4信息
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293602','宽窄巷子','鼓楼区','湖北路21号','特色菜系',1,'南京市',13,'http://localhost:8000/images/upload/6293602.jpg','江苏',4.4);
# 餐厅4餐品
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (41,'6293602','培根','主食',2.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_41.png','培根');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (42,'6293602','鸡翅中','主食',5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_42.jpg','鸡翅中');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (43,'6293602','秋葵','主食',1.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_43.jpg','秋葵');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (44,'6293602','四川笋尖','主食',1.5,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_44.jpg','四川笋尖');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (45,'6293602','油炸豆泡','主食',1,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_45.jpg','油炸豆泡');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (46,'6293602','冒肥牛','主食',28,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_46.jpg','冒肥牛');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (47,'6293602','冒成都宽粉','主食',9,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_47.jpg','冒成都宽粉');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (48,'6293602','刀切小馒头','小食',13,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_48.jpg','刀切小馒头');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (49,'6293602','红糖糍粑','主食',13,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_49.jpg','红糖糍粑');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (50,'6293602','芝士丸','主食',4,1000,'2019-01-31','2019-12-31','http://localhost:8000/images/upload/41e8cea_50.png','芝士丸');
# 餐厅4折扣
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (7,20,50,'6293602','2019-12-31','2019-01-01');
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (8,5,20,'6293602','2019-12-31','2019-01-01');

# 其他餐厅
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293603','绝味鸭脖（广州路店）','鼓楼区','广州路22号（南京大学门口旁）','特色菜系',1,'南京市',13,'http://localhost:8000/images/upload/6293603.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293604','串意十足烧烤店','秦淮区','三条巷18号1F11-1号','特色菜系',1,'南京市',13,'http://localhost:8000/images/upload/6293604.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293605','天山大盘鸡','玄武区','新街口街道杨将军巷9号曼度广场A栋四层隐食纪M2-8','特色菜系',1,'南京市',13,'http://localhost:8000/images/upload/6293605.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293606','东北饺子坊','玄武区','新街口街道大纱帽巷40号1栋107室','快餐便当',1,'南京市',13,'http://localhost:8000/images/upload/6293606.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293607','四川菜馆','玄武区','新街口北门桥3号107室','快餐便当',1,'南京市',13,'http://localhost:8000/images/upload/6293607.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293608','围炉小巷·烧烤（新街口店）','玄武区','新街口街道北门桥3-5号一层部分','特色菜系',1,'南京市',13,'http://localhost:8000/images/upload/6293608.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293609','鲜果切','秦淮区','汉中路120号28层','小吃夜宵',1,'南京市',13,'http://localhost:8000/images/upload/6293609.jpg','江苏',4.4);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293610','正新鸡排','玄武区','珠江路381号','快餐便当',1,'南京市',13,'http://localhost:8000/images/upload/6293610.jpg','江苏',4.4);


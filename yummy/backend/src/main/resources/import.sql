
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('2273461589@qq.com',2,284,'test',1,'Erica','18251838318',9713.370000000003,'test');
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('2544194336@qq.com',1,0,'test',1,'小寒','18251838318',10000,'test');
INSERT INTO member (email, level, score, password, usable, username, phone,balance, pay_password) VALUES('yeyuewangxuan@126.com',1,0,'test',1,'羡羡','18251838318',10000,'test');

INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('1877104','KFC','鼓楼区','珠江路2号','快餐便当',1,'南京市',4,'http://localhost:8000/images/upload/1.jpg','江苏',4.5);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('348d04f','麦当劳','鼓楼区','珠江路1号','快餐便当',1,'南京市',1,'http://localhost:8000/images/upload/2.jpg','江苏',3.0);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('41e8cea','M记','栖霞区','栖霞大道1号','快餐便当',1,'南京市',0,'http://localhost:8000/images/upload/3.jpg','江苏',0);
INSERT INTO restaurant (id, name, district, address, type, usable, city, evaluation_num, image, province, stars) VALUES ('6293602','宽窄巷子','鼓楼区','湖北路21号','特色菜系',1,'南京市',13,'http://localhost:8000/images/upload/P.jpg','江苏',4.4);

INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (2,'6293602','冒菜','主食',20,1000,'2019-01-31','2019-03-30','http://localhost:8000/images/upload/1.jpg','丸子冒菜');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (3,'6293602','里脊肉','小食',4,1002,'2019-01-31','2019-03-30','http://localhost:8000/images/upload/2.jpg','精选里脊肉');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (4,'6293602','土豆','小食',3,1014,'2019-01-31','2019-04-03','http://localhost:8000/images/upload/3.jpg','新鲜土豆');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (5,'6293602','宽粉','主食',5,999,'2019-01-31','2019-03-28','http://localhost:8000/images/upload/P.jpg','又长又宽');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (6,'1877104','炸鸡','主食',10,527,'2019-02-28','2019-04-23','http://localhost:8000/images/upload/炸鸡.jpg','金黄香脆的外皮');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (7,'1877104','炸鸡套餐','套餐',15,125,'2019-02-28','2019-03-20','http://localhost:8000/images/upload/炸鸡.jpg','香辣咸麻的味道');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (8,'348d04f','炸鸡','主食',10,1002,'2019-03-13','2019-03-27','http://localhost:8000/images/upload/炸鸡.jpg','鲜嫩多汁的鸡肉');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (9,'348d04f','薯条','小食',5,1002,'2019-03-13','2019-03-27','http://localhost:8000/images/upload/3.jpg','外脆内酥，可口诱人');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (10,'348d04f','炸鸡薯条套餐','套餐',12,502,'2019-03-18','2019-03-27','http://localhost:8000/images/upload/3.jpg','外脆内酥，可口诱人');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (11,'6293602','米饭','主食',10,98,'2019-04-21','2019-04-29','http://localhost:8000/images/upload/1.png','性平、味甘，营养均衡');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (12,'6293602','小米粥','主食',20,995,'2019-05-31','2019-06-29','http://localhost:8000/images/upload/炸鸡.jpg','口味清淡，健胃消食');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (13,'6293602','可口可乐','饮品',7,100,'2019-06-04','2019-07-30','http://localhost:8000/images/upload/可乐.jpg','不是所有的可乐都是可口可乐');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (14,'6293602','土豆','小食',5,1000,'2019-05-31','2019-07-31','http://localhost:8000/images/upload/3.jpg','新鲜土豆');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (15,'6293602','里脊肉','小食',10,800,'2019-05-31','2019-07-31','http://localhost:8000/images/upload/2.jpg','精选里脊肉');
INSERT INTO food (id, rest_id, name, type, price, amount, start_date, end_date, image, description) VALUES (16,'6293602','冒菜','主食',25,800,'2019-05-31','2019-07-31','http://localhost:8000/images/upload/1.jpg','丸子冒菜');

INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (1,10,50,'6293602','2019-03-29','2019-01-31'), (2,10,20,'6293602','2019-02-21','2019-02-13');
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (3,15,30,'6293602','2019-03-28','2019-01-31'), (4,20,40,'6293602','2019-03-29','2019-01-31');
INSERT INTO discount (id, dis_money, full_money, rest_id, end_date, start_date) VALUES (5,10,30,'348d04f','2019-03-26','2019-03-12'), (6,10,30,'6293602','2019-07-30','2019-05-31');

#INSERT INTO modify_info (id, address, district, request_time, name, type, rest_id) VALUES (5,'珠江路1号','鼓楼区','2019-03-19 22:10:22','KFC','快餐便当','1877104');

INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (1,'2273461589@qq.com','鼓楼区','汉口路22号','南京市',1,'王轩','18251838318','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (2,'2273461589@qq.com','栖霞区','广州路8号','南京市',1,'王轩','18251838318','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (3,'2273461589@qq.com','江宁区','陶园南楼','南京市',1,'唐佳未','15996235505','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (6,'2273461589@qq.com','鼓楼区','南京大学鼓楼校区','南京市',1,'唐佳未','15996235505','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (19,'2273461589@qq.com','江宁区','东大九龙湖校区','南京市',1,'许杨','18260199930','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (20,'yeyuewangxuan@126.com','鼓楼区','南京大学','南京市',1,'许杨','18260199930','江苏');
INSERT INTO address (id, email, district, address, city, is_usable, name, phone, province) VALUES (21,'2273461589@qq.com','浦口区','南京大学金陵学院','南京市',1,'王轩','18251838318','江苏');

INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (1,0,0,'2019-02-26 19:45:53',23.65,'2273461589@qq.com','6293602',1.85,15,30,1,'鼓楼区  汉口路22号','已送达', 5,'18260199930','不要小葱，不要香菜，少放辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (2,0,0,'2019-02-26 20:17:29',26.5,'2273461589@qq.com','6293602',2,15,30,0,'鼓楼区  汉口路22号','已送达', 5,'18260199930','不要小葱，不要香菜', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (3,0,0,'2019-02-26 20:22:12',22.5,'2273461589@qq.com','6293602',1,0,0,0,'鼓楼区  汉口路22号','已送达',5,'18251838318','少放辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (6,1,1,'2019-02-27 22:02:58',25.3,'2273461589@qq.com','6293602',2.2,20,40,0,'鼓楼区  汉口路22号','已送达',4,'15996235505','不要辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (7,0,0,'2019-02-28 20:57:52',29.15,'2273461589@qq.com','6293602',1.35,0,0,1,'鼓楼区  汉口路22号','已送达',4,'15996235505','不要葱姜蒜', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (8,1,1,'2019-03-01 10:41:58',10.15,'2273461589@qq.com','6293602',0.35,0,0,0,'鼓楼区  汉口路22号','已送达',4,'18251838318','多放些酱', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (9,0,0,'2019-03-01 10:44:27',6.35,'2273461589@qq.com','6293602',0.15,0,0,0,'鼓楼区  汉口路22号','已送达',4,'15996235505','', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (10,0,0,'2019-03-19 22:19:58',27.25,'2273461589@qq.com','1877104',1.25,0,0,0,'鼓楼区  汉口路22号','已送达',5,'18260199930','不要小葱，不要香菜', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (11,1,1,'2019-03-19 22:20:28',32,'2273461589@qq.com','1877104',1.5,0,0,0,'鼓楼区  汉口路22号','已送达',5,'18260199930','不要小葱，不要香菜', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (12,1,1,'2019-03-20 10:43:29',31.05,'2273461589@qq.com','6293602',1.45,0,0,0,'鼓楼区  汉口路22号','已送达',3,'18251838318','不要辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (13,0,0,'2019-03-20 10:43:41',27.25,'2273461589@qq.com','1877104',1.25,0,0,0,'鼓楼区  汉口路22号','已送达',4,'15996235505','微微辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (14,0,0,'2019-03-20 10:53:41',29.15,'2273461589@qq.com','348d04f',1.35,0,0,0,'鼓楼区  汉口路22号','已送达',3,'18260199930','多放点辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (15,1,1,'2019-03-20 10:54:03',28.15,'2273461589@qq.com','6293602',2.35,20,40,0,'鼓楼区  汉口路22号','已送达',3,'18251838318','不要香菜', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (16,1,1,'2019-03-20 10:54:43',27.25,'2273461589@qq.com','1877104',1.25,0,0,1,'鼓楼区  汉口路22号','已送达',4,'15996235505','', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (17,1,1,'2019-04-26 19:56:41',22.5,'2273461589@qq.com','6293602',1,0,0,0,'鼓楼区  汉口路22号','已送达',5,'18251838318','多给一份餐具', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (18,1,1,'2019-06-05 23:41:11',41.5,'2273461589@qq.com','6293602',2,0,0,0,'鼓楼区  汉口路22号','已送达',5,'18251838318','', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (19,1,1,'2019-06-06 09:49:27',41.5,'2273461589@qq.com','6293602',2,0,0,0,'鼓楼区  汉口路22号','已送达',5,'15996235505','微微辣', 3.5);
INSERT INTO orders (id, is_paid, is_valid, order_time, sum, email, rest_id, dis_by_level, dis_by_rest, full_money, is_cancel, address, express_state, grade, phone, remark, deliver_fee) VALUES (20,1,1,'2019-06-08 11:41:49',22.5,'2273461589@qq.com','6293602',1,0,0,1,'鼓楼区  汉口路22号','已送达',5,'18260199930','不要香菜，少放辣', 3.5);

INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (1,1,2,1,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (2,2,3,1,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (3,3,4,1,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (4,2,2,2,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (5,1,2,3,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (10,1,2,6,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (11,6,3,6,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (12,1,2,7,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (13,1,3,7,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (14,1,4,7,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (15,1,3,8,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (16,1,4,8,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (17,1,4,9,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (18,1,6,10,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (19,1,7,10,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (20,2,7,11,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (21,1,2,12,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (22,1,3,12,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (23,1,5,12,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (24,1,6,13,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (25,1,7,13,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (26,1,8,14,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (27,1,9,14,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (28,1,10,14,0);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (29,2,2,15,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (30,1,3,15,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (31,1,4,15,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (32,1,6,16,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (33,1,7,16,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (34,2,11,17,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (35,2,12,18,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (36,2,12,19,1);
INSERT INTO order_info (id, num, f_id, o_id, is_valid) VALUES (37,1,12,20,1);

INSERT INTO express_state (oid, state) VALUES (1,'已送达');
INSERT INTO express_state (oid, state) VALUES (6,'等待商家接单');
INSERT INTO express_state (oid, state) VALUES (7,'等待商家接单');
INSERT INTO express_state (oid, state) VALUES (8,'等待商家接单');
INSERT INTO express_state (oid, state) VALUES (11,'已送达');
INSERT INTO express_state (oid, state) VALUES (12,'配送中');
INSERT INTO express_state (oid, state) VALUES (15,'配送中');
INSERT INTO express_state (oid, state) VALUES (16,'已送达');
INSERT INTO express_state (oid, state) VALUES (17,'等待商家发货');
INSERT INTO express_state (oid, state) VALUES (18,'等待商家接单');
INSERT INTO express_state (oid, state) VALUES (19,'等待商家接单');
INSERT INTO express_state (oid, state) VALUES (20,'等待商家发货');

INSERT INTO admin (username, password) VALUES ('admin','admin');

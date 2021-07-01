CREATE DATABASE `oauth2_learning` CHARACTER SET 'utf8mb4';

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL COMMENT '用户id',
   `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `fullname` varchar(255) NOT NULL COMMENT '用户姓名',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- 张三密码123， 李四密码456
INSERT INTO t_user VALUES
(1, "zhangsan", "$2a$10$m.puRqdZWS9e8D/vRcXuD.JbRK50QqikNvEOJIdBq8cq1zh/iymO2", "张三", "13012312389"),
(2, "lisi", "$2a$10$8ZKW4BMJ6xXh10KjgEggM.WQjpQXh3o00XfAiajFfyajYRfJt4dIe", "李四", "13532188989");

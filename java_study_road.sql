SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for back_admin
-- ----------------------------
DROP TABLE IF EXISTS `back_admin`;
CREATE TABLE `back_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_code` varchar(20) DEFAULT NULL COMMENT '管理员id',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `admin_name` varchar(20) DEFAULT NULL COMMENT '管理员姓名',
  `role_id` int(255) DEFAULT NULL COMMENT '角色id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '管理员角色名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of back_admin
-- ----------------------------
INSERT INTO `back_admin` VALUES ('30', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', '0', '超级管理员', '2019-07-04 14:12:00');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL COMMENT '账号（手机号）',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `sex` int(2) DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `qq` varchar(255) DEFAULT NULL COMMENT 'QQ',
  `weixin` varchar(255) DEFAULT NULL COMMENT '微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
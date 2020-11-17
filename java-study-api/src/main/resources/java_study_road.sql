
-- DMC dump 1.0.0
-- ------------------------------------------------------
    
-- ----------------------------
-- Table structure for back_admin
-- ----------------------------
    
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
      
INSERT INTO `back_admin` (`id`,`admin_code`,`password`,`admin_name`,`role_id`,`role_name`,`create_time`) VALUES (30,'admin','E10ADC3949BA59ABBE56E057F20F883E','admin',0,'超级管理员','2019-07-04 14:12:00');
-- ----------------------------
-- Table structure for interface_info
-- ----------------------------
    
CREATE TABLE `interface_info` (
  `api_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `api_method` varchar(12) NOT NULL COMMENT 'HttpMethod：GET、PUT、POST',
  `api_path` varchar(512) NOT NULL COMMENT '拦截路径',
  `api_status` int(2) NOT NULL COMMENT '状态：0草稿，1发布，2有变更，3禁用',
  `api_comment` varchar(255) DEFAULT NULL COMMENT '注释',
  `api_type` varchar(24) NOT NULL COMMENT '脚本类型：SQL、DataQL',
  `api_script` mediumtext NOT NULL COMMENT '查询脚本：xxxxxxx',
  `api_schema` mediumtext COMMENT '接口的请求/响应数据结构',
  `api_sample` mediumtext COMMENT '请求/响应/请求头样本数据',
  `api_option` mediumtext COMMENT '扩展配置信息',
  `api_create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `api_gmt_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`api_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='Dataway 中的API'; 
      
INSERT INTO `interface_info` (`api_id`,`api_method`,`api_path`,`api_status`,`api_comment`,`api_type`,`api_script`,`api_schema`,`api_sample`,`api_option`,`api_create_time`,`api_gmt_time`) VALUES (2,'GET','/api/listAdmin',2,'后台管理用户列表','SQL','select * from back_admin;','{\"requestSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"message\":{\"type\":\"string\"}}},\"responseSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"executionTime\":{\"type\":\"number\"},\"code\":{\"type\":\"number\"},\"success\":{\"type\":\"boolean\"},\"lifeCycleTime\":{\"type\":\"number\"},\"message\":{\"type\":\"string\"},\"value\":{\"type\":\"object\",\"properties\":{\"role_name\":{\"type\":\"string\"},\"admin_code\":{\"type\":\"string\"},\"password\":{\"type\":\"string\"},\"create_time\":{\"type\":\"number\"},\"role_id\":{\"type\":\"number\"},\"id\":{\"type\":\"number\"},\"admin_name\":{\"type\":\"string\"}}}}}}','{\"requestBody\":\"{\\\"message\\\":\\\"Hello DataQL.\\\"}\",\"headerData\":[]}','{\"resultStructure\":true,\"responseFormat\":\"{\\n  \\\"success\\\"      : \\\"@resultStatus\\\",\\n  \\\"message\\\"      : \\\"@resultMessage\\\",\\n  \\\"code\\\"         : \\\"@resultCode\\\",\\n  \\\"lifeCycleTime\\\": \\\"@timeLifeCycle\\\",\\n  \\\"executionTime\\\": \\\"@timeExecution\\\",\\n  \\\"value\\\"        : \\\"@resultData\\\"\\n}\"}','2020-06-01 15:34:09','2020-06-01 16:31:04');
-- ----------------------------
-- Table structure for interface_release
-- ----------------------------
    
CREATE TABLE `interface_release` (
  `pub_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Publish ID',
  `pub_api_id` int(11) NOT NULL COMMENT '所属API ID',
  `pub_method` varchar(12) NOT NULL COMMENT 'HttpMethod：GET、PUT、POST',
  `pub_path` varchar(512) NOT NULL COMMENT '拦截路径',
  `pub_status` int(2) NOT NULL COMMENT '状态：0有效，1无效（可能被下线）',
  `pub_type` varchar(24) NOT NULL COMMENT '脚本类型：SQL、DataQL',
  `pub_script` mediumtext NOT NULL COMMENT '查询脚本：xxxxxxx',
  `pub_script_ori` mediumtext NOT NULL COMMENT '原始查询脚本，仅当类型为SQL时不同',
  `pub_schema` mediumtext COMMENT '接口的请求/响应数据结构',
  `pub_sample` mediumtext COMMENT '请求/响应/请求头样本数据',
  `pub_option` mediumtext COMMENT '扩展配置信息',
  `pub_release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间（下线不更新）',
  PRIMARY KEY (`pub_id`),
  KEY `idx_interface_release` (`pub_api_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='Dataway API 发布历史。'; 
      
INSERT INTO `interface_release` (`pub_id`,`pub_api_id`,`pub_method`,`pub_path`,`pub_status`,`pub_type`,`pub_script`,`pub_script_ori`,`pub_schema`,`pub_sample`,`pub_option`,`pub_release_time`) VALUES (1,2,'GET','/api/listAdmin',0,'SQL','var tempCall = @@sql(`message`)<%select * from back_admin;%>;\nreturn tempCall(${message});','select * from back_admin;','{\"requestSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"message\":{\"type\":\"string\"}}},\"responseSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"executionTime\":{\"type\":\"number\"},\"code\":{\"type\":\"number\"},\"success\":{\"type\":\"boolean\"},\"lifeCycleTime\":{\"type\":\"number\"},\"message\":{\"type\":\"string\"},\"value\":{\"type\":\"object\",\"properties\":{\"role_name\":{\"type\":\"string\"},\"admin_code\":{\"type\":\"string\"},\"password\":{\"type\":\"string\"},\"create_time\":{\"type\":\"number\"},\"role_id\":{\"type\":\"number\"},\"id\":{\"type\":\"number\"},\"admin_name\":{\"type\":\"string\"}}}}}}','{\"requestBody\":\"{\\\"message\\\":\\\"Hello DataQL.\\\"}\",\"headerData\":[]}','{\"resultStructure\":true,\"responseFormat\":\"{\\n  \\\"success\\\"      : \\\"@resultStatus\\\",\\n  \\\"message\\\"      : \\\"@resultMessage\\\",\\n  \\\"code\\\"         : \\\"@resultCode\\\",\\n  \\\"lifeCycleTime\\\": \\\"@timeLifeCycle\\\",\\n  \\\"executionTime\\\": \\\"@timeExecution\\\",\\n  \\\"value\\\"        : \\\"@resultData\\\"\\n}\"}','2020-06-01 16:04:00');
INSERT INTO `interface_release` (`pub_id`,`pub_api_id`,`pub_method`,`pub_path`,`pub_status`,`pub_type`,`pub_script`,`pub_script_ori`,`pub_schema`,`pub_sample`,`pub_option`,`pub_release_time`) VALUES (2,2,'GET','/api/listAdmin',0,'SQL','var tempCall = @@sql(`message`)<%select * from back_admin;%>;\nreturn tempCall(${message});','select * from back_admin;','{\"requestSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"message\":{\"type\":\"string\"}}},\"responseSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"executionTime\":{\"type\":\"number\"},\"code\":{\"type\":\"number\"},\"success\":{\"type\":\"boolean\"},\"lifeCycleTime\":{\"type\":\"number\"},\"message\":{\"type\":\"string\"},\"value\":{\"type\":\"object\",\"properties\":{\"role_name\":{\"type\":\"string\"},\"admin_code\":{\"type\":\"string\"},\"password\":{\"type\":\"string\"},\"create_time\":{\"type\":\"number\"},\"role_id\":{\"type\":\"number\"},\"id\":{\"type\":\"number\"},\"admin_name\":{\"type\":\"string\"}}}}}}','{\"requestBody\":\"{\\\"message\\\":\\\"Hello DataQL.\\\"}\",\"headerData\":[]}','{\"resultStructure\":true,\"responseFormat\":\"{\\n  \\\"success\\\"      : \\\"@resultStatus\\\",\\n  \\\"message\\\"      : \\\"@resultMessage\\\",\\n  \\\"code\\\"         : \\\"@resultCode\\\",\\n  \\\"lifeCycleTime\\\": \\\"@timeLifeCycle\\\",\\n  \\\"executionTime\\\": \\\"@timeExecution\\\",\\n  \\\"value\\\"        : \\\"@resultData\\\"\\n}\"}','2020-06-01 16:08:47');
INSERT INTO `interface_release` (`pub_id`,`pub_api_id`,`pub_method`,`pub_path`,`pub_status`,`pub_type`,`pub_script`,`pub_script_ori`,`pub_schema`,`pub_sample`,`pub_option`,`pub_release_time`) VALUES (3,2,'GET','/api/listAdmin',0,'SQL','var tempCall = @@sql(`message`)<%select * from back_admin%>;\nreturn tempCall(${message});','select * from back_admin','{\"requestSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"message\":{\"type\":\"string\"}}},\"responseSchema\":{\"$schema\":\"http://json-schema.org/draft-04/schema#\",\"type\":\"object\",\"properties\":{\"executionTime\":{\"type\":\"number\"},\"code\":{\"type\":\"number\"},\"success\":{\"type\":\"boolean\"},\"lifeCycleTime\":{\"type\":\"number\"},\"message\":{\"type\":\"string\"},\"value\":{\"type\":\"object\",\"properties\":{\"role_name\":{\"type\":\"string\"},\"admin_code\":{\"type\":\"string\"},\"password\":{\"type\":\"string\"},\"create_time\":{\"type\":\"number\"},\"role_id\":{\"type\":\"number\"},\"id\":{\"type\":\"number\"},\"admin_name\":{\"type\":\"string\"}}}}}}','{\"requestBody\":\"{\\\"message\\\":\\\"Hello DataQL.\\\"}\",\"headerData\":[]}','{\"resultStructure\":true,\"responseFormat\":\"{\\n  \\\"success\\\"      : \\\"@resultStatus\\\",\\n  \\\"message\\\"      : \\\"@resultMessage\\\",\\n  \\\"code\\\"         : \\\"@resultCode\\\",\\n  \\\"lifeCycleTime\\\": \\\"@timeLifeCycle\\\",\\n  \\\"executionTime\\\": \\\"@timeExecution\\\",\\n  \\\"value\\\"        : \\\"@resultData\\\"\\n}\"}','2020-06-01 16:15:51');
-- ----------------------------
-- Table structure for user_info
-- ----------------------------
    
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
      

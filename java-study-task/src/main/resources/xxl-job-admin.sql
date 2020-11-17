
-- DMC dump 1.0.0
-- ------------------------------------------------------

-- ----------------------------
-- Table structure for xxl_job_group
-- ----------------------------

CREATE TABLE `xxl_job_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(64) NOT NULL COMMENT '执行器AppName',
  `title` varchar(12) NOT NULL COMMENT '执行器名称',
  `order` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `address_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '执行器地址类型：0=自动注册、1=手动录入',
  `address_list` varchar(512) DEFAULT NULL COMMENT '执行器地址列表，多地址逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_group` (`id`,`app_name`,`title`,`order`,`address_type`) VALUES (3,'xxl-job-executor','测试executor',0,0);
-- ----------------------------
-- Table structure for xxl_job_info
-- ----------------------------

CREATE TABLE `xxl_job_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_cron` varchar(128) NOT NULL COMMENT '任务执行CRON',
  `job_desc` varchar(255) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `author` varchar(64) DEFAULT NULL COMMENT '作者',
  `alarm_email` varchar(255) DEFAULT NULL COMMENT '报警邮件',
  `executor_route_strategy` varchar(50) DEFAULT NULL COMMENT '执行器路由策略',
  `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `executor_block_strategy` varchar(50) DEFAULT NULL COMMENT '阻塞处理策略',
  `executor_timeout` int(11) NOT NULL DEFAULT '0' COMMENT '任务执行超时时间，单位秒',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `glue_type` varchar(50) NOT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) DEFAULT NULL COMMENT 'GLUE备注',
  `glue_updatetime` datetime DEFAULT NULL COMMENT 'GLUE更新时间',
  `child_jobid` varchar(255) DEFAULT NULL COMMENT '子任务ID，多个逗号分隔',
  `trigger_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '调度状态：0-停止，1-运行',
  `trigger_last_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '上次调度时间',
  `trigger_next_time` bigint(13) NOT NULL DEFAULT '0' COMMENT '下次调度时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_info` (`id`,`job_group`,`job_cron`,`job_desc`,`add_time`,`update_time`,`author`,`alarm_email`,`executor_route_strategy`,`executor_handler`,`executor_param`,`executor_block_strategy`,`executor_timeout`,`executor_fail_retry_count`,`glue_type`,`glue_source`,`glue_remark`,`glue_updatetime`,`child_jobid`,`trigger_status`,`trigger_last_time`,`trigger_next_time`) VALUES (2,3,'* 0/1 * * * ?','test','2020-05-29 04:40:38','2020-05-29 04:40:38','阿斌','','FIRST','testTask','','SERIAL_EXECUTION',0,0,'BEAN','','GLUE代码初始化','2020-05-29 04:40:38','',0,0,0);
-- ----------------------------
-- Table structure for xxl_job_lock
-- ----------------------------

CREATE TABLE `xxl_job_lock` (
  `lock_name` varchar(50) NOT NULL COMMENT '锁名称',
  PRIMARY KEY (`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_lock` (`lock_name`) VALUES ('schedule_lock');
-- ----------------------------
-- Table structure for xxl_job_log
-- ----------------------------

CREATE TABLE `xxl_job_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_group` int(11) NOT NULL COMMENT '执行器主键ID',
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `executor_address` varchar(255) DEFAULT NULL COMMENT '执行器地址，本次执行的地址',
  `executor_handler` varchar(255) DEFAULT NULL COMMENT '执行器任务handler',
  `executor_param` varchar(512) DEFAULT NULL COMMENT '执行器任务参数',
  `executor_sharding_param` varchar(20) DEFAULT NULL COMMENT '执行器任务分片参数，格式如 1/2',
  `executor_fail_retry_count` int(11) NOT NULL DEFAULT '0' COMMENT '失败重试次数',
  `trigger_time` datetime DEFAULT NULL COMMENT '调度-时间',
  `trigger_code` int(11) NOT NULL COMMENT '调度-结果',
  `trigger_msg` text COMMENT '调度-日志',
  `handle_time` datetime DEFAULT NULL COMMENT '执行-时间',
  `handle_code` int(11) NOT NULL COMMENT '执行-状态',
  `handle_msg` text COMMENT '执行-日志',
  `alarm_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败',
  PRIMARY KEY (`id`),
  KEY `I_trigger_time` (`trigger_time`),
  KEY `I_handle_code` (`handle_code`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for xxl_job_log_report
-- ----------------------------

CREATE TABLE `xxl_job_log_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trigger_day` datetime DEFAULT NULL COMMENT '调度-时间',
  `running_count` int(11) NOT NULL DEFAULT '0' COMMENT '运行中-日志数量',
  `suc_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行成功-日志数量',
  `fail_count` int(11) NOT NULL DEFAULT '0' COMMENT '执行失败-日志数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_trigger_day` (`trigger_day`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (1,'2020-01-15 00:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (2,'2020-01-14 00:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (3,'2020-01-13 00:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (4,'2020-05-29 00:00:00',0,0,2);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (5,'2020-05-28 00:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (6,'2020-05-27 00:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (7,'2020-05-28 11:00:00',0,0,1);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (8,'2020-05-27 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (9,'2020-05-26 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (10,'2020-05-29 11:00:00',0,3,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (11,'2020-05-30 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (12,'2020-05-31 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (13,'2020-06-01 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (14,'2020-06-02 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (15,'2020-06-03 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (16,'2020-06-04 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (17,'2020-06-05 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (18,'2020-06-06 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (19,'2020-06-07 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (20,'2020-06-08 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (21,'2020-06-09 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (22,'2020-06-10 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (23,'2020-06-11 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (24,'2020-06-12 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (25,'2020-06-13 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (26,'2020-06-14 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (27,'2020-06-15 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (28,'2020-06-16 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (29,'2020-06-17 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (30,'2020-06-18 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (31,'2020-06-19 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (32,'2020-06-20 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (33,'2020-06-21 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (34,'2020-06-22 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (35,'2020-06-23 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (36,'2020-06-24 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (37,'2020-06-25 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (38,'2020-06-26 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (39,'2020-06-27 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (40,'2020-06-28 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (41,'2020-06-29 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (42,'2020-06-30 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (43,'2020-07-01 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (44,'2020-07-02 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (45,'2020-07-03 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (46,'2020-07-04 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (47,'2020-07-05 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (48,'2020-07-06 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (49,'2020-07-07 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (50,'2020-07-08 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (51,'2020-07-09 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (52,'2020-07-10 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (53,'2020-07-11 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (54,'2020-07-12 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (55,'2020-07-13 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (56,'2020-07-14 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (57,'2020-07-15 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (58,'2020-07-16 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (59,'2020-07-17 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (60,'2020-07-18 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (61,'2020-07-19 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (62,'2020-07-20 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (63,'2020-07-21 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (64,'2020-07-22 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (65,'2020-07-23 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (66,'2020-07-24 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (67,'2020-07-25 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (68,'2020-07-26 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (69,'2020-07-27 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (70,'2020-07-28 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (71,'2020-07-29 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (72,'2020-07-30 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (73,'2020-07-31 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (74,'2020-08-01 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (75,'2020-08-02 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (76,'2020-08-03 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (77,'2020-08-04 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (78,'2020-08-05 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (79,'2020-08-06 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (80,'2020-08-07 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (81,'2020-08-08 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (82,'2020-08-09 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (83,'2020-08-10 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (84,'2020-08-11 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (85,'2020-08-12 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (86,'2020-08-13 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (87,'2020-08-14 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (88,'2020-08-15 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (89,'2020-08-16 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (90,'2020-08-17 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (91,'2020-08-18 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (92,'2020-08-19 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (93,'2020-08-20 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (94,'2020-08-21 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (95,'2020-08-22 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (96,'2020-08-23 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (97,'2020-08-24 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (98,'2020-08-25 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (99,'2020-08-26 11:00:00',0,0,0);
INSERT INTO `xxl_job_log_report` (`id`,`trigger_day`,`running_count`,`suc_count`,`fail_count`) VALUES (100,'2020-08-27 11:00:00',0,0,0);
-- ----------------------------
-- Table structure for xxl_job_logglue
-- ----------------------------

CREATE TABLE `xxl_job_logglue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `job_id` int(11) NOT NULL COMMENT '任务，主键ID',
  `glue_type` varchar(50) DEFAULT NULL COMMENT 'GLUE类型',
  `glue_source` mediumtext COMMENT 'GLUE源代码',
  `glue_remark` varchar(128) NOT NULL COMMENT 'GLUE备注',
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for xxl_job_registry
-- ----------------------------

CREATE TABLE `xxl_job_registry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `registry_group` varchar(50) NOT NULL,
  `registry_key` varchar(255) NOT NULL,
  `registry_value` varchar(255) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_g_k_v` (`registry_group`,`registry_key`,`registry_value`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for xxl_job_user
-- ----------------------------

CREATE TABLE `xxl_job_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `role` tinyint(4) NOT NULL COMMENT '角色：0-普通用户、1-管理员',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_user` (`id`,`username`,`password`,`role`) VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',1);
/*
 Navicat Premium Data Transfer

 Source Server         : Yum
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : 47.106.188.177:3306
 Source Schema         : rs_new

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 10/07/2019 21:25:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_data`;
CREATE TABLE `sys_data`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典ID',
  `key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '键',
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值',
  `typeNo` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型编号',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级部门id\r\n',
  `dept_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称\r\n',
  `sort` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序\r\n',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人\r\n',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间\r\n',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间\r\n',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人\r\n',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注\r\n',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1626943068559052800', NULL, '广东东软学院', '1', NULL, '2019-05-15 23:42:13', NULL, NULL, NULL, '0');
INSERT INTO `sys_dept` VALUES ('1626943452073627648', '1626943068559052800', '计算机学院', '2', NULL, '2019-05-15 23:43:33', NULL, NULL, NULL, '0');
INSERT INTO `sys_dept` VALUES ('1626943569098903552', '1626943452073627648', '软件工程系', '3', NULL, '2019-05-15 23:44:01', NULL, NULL, NULL, '0');
INSERT INTO `sys_dept` VALUES ('1626943763580391424', '1626943569098903552', '软工一班', '4', NULL, '2019-05-15 23:44:47', NULL, NULL, NULL, '0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `type_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名',
  `typeNo` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型编号',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `BEAN_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方法名',
  `PARAMS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `CRON_EXPRESSION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'cron表达式',
  `STATUS` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务状态  0：正常  1：暂停',
  `REMARK` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`JOB_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, 'testTask', 'test', 'mrbird', '0/1 * * * * ?', '1', '有参任务调度测试', '2018-02-24 16:26:14');
INSERT INTO `sys_job` VALUES (2, 'testTask', 'test1', NULL, '0/10 * * * * ?', '1', '无参任务调度测试', '2018-02-24 17:06:23');
INSERT INTO `sys_job` VALUES (3, 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1', '有参任务调度测试,每隔一秒触发', '2018-02-26 09:28:26');
INSERT INTO `sys_job` VALUES (11, 'testTask', 'test2', NULL, '0/5 * * * * ?', '1', '测试异常', '2018-02-26 11:15:30');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `JOB_ID` bigint(20) NOT NULL COMMENT '任务id',
  `BEAN_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'spring bean名称',
  `METHOD_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方法名',
  `PARAMS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数',
  `STATUS` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `ERROR` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '失败信息',
  `TIMES` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时(单位：毫秒)',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`LOG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2476 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
INSERT INTO `sys_job_log` VALUES (2448, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20 15:31:50');
INSERT INTO `sys_job_log` VALUES (2449, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:31:51');
INSERT INTO `sys_job_log` VALUES (2450, 3, 'testTask', 'test', 'hello world', '0', NULL, 2, '2018-03-20 15:31:52');
INSERT INTO `sys_job_log` VALUES (2451, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20 15:31:53');
INSERT INTO `sys_job_log` VALUES (2452, 3, 'testTask', 'test', 'hello world', '0', NULL, 2, '2018-03-20 15:31:54');
INSERT INTO `sys_job_log` VALUES (2453, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:31:55');
INSERT INTO `sys_job_log` VALUES (2454, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20 15:31:56');
INSERT INTO `sys_job_log` VALUES (2455, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:31:57');
INSERT INTO `sys_job_log` VALUES (2456, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:31:59');
INSERT INTO `sys_job_log` VALUES (2457, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:31:59');
INSERT INTO `sys_job_log` VALUES (2458, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:32:00');
INSERT INTO `sys_job_log` VALUES (2459, 3, 'testTask', 'test', 'hello world', '0', NULL, 0, '2018-03-20 15:32:01');
INSERT INTO `sys_job_log` VALUES (2460, 3, 'testTask', 'test', 'hello world', '0', NULL, 5, '2018-03-20 15:32:02');
INSERT INTO `sys_job_log` VALUES (2461, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:32:03');
INSERT INTO `sys_job_log` VALUES (2462, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:32:04');
INSERT INTO `sys_job_log` VALUES (2463, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:32:05');
INSERT INTO `sys_job_log` VALUES (2464, 3, 'testTask', 'test', 'hello world', '0', NULL, 1, '2018-03-20 15:32:06');
INSERT INTO `sys_job_log` VALUES (2465, 11, 'testTask', 'test2', NULL, '1', 'java.lang.NoSuchMethodException: cc.mrbird.job.task.TestTask.test2()', 0, '2018-03-20 15:32:26');
INSERT INTO `sys_job_log` VALUES (2466, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 15:26:40');
INSERT INTO `sys_job_log` VALUES (2467, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 15:26:50');
INSERT INTO `sys_job_log` VALUES (2468, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 15:27:20');
INSERT INTO `sys_job_log` VALUES (2469, 2, 'testTask', 'test1', NULL, '0', NULL, 3, '2018-04-02 17:29:20');
INSERT INTO `sys_job_log` VALUES (2470, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 17:29:30');
INSERT INTO `sys_job_log` VALUES (2471, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 17:29:40');
INSERT INTO `sys_job_log` VALUES (2472, 2, 'testTask', 'test1', NULL, '0', NULL, 14, '2018-04-02 17:29:50');
INSERT INTO `sys_job_log` VALUES (2473, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 17:30:00');
INSERT INTO `sys_job_log` VALUES (2474, 2, 'testTask', 'test1', NULL, '0', NULL, 0, '2018-04-02 17:30:10');
INSERT INTO `sys_job_log` VALUES (2475, 2, 'testTask', 'test1', NULL, '0', NULL, 1, '2018-04-02 17:30:20');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `OPERATION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作内容',
  `TIME` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时',
  `METHOD` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作方法',
  `PARAMS` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '方法参数',
  `IP` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者IP',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 860 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (730, 'MrBird', '恢复任务', 55, 'cc.mrbird.job.controller.JobController.resumeJob()', 'jobIds: 3', '127.0.0.1', '2018-03-19 10:07:32', NULL);
INSERT INTO `sys_log` VALUES (731, 'MrBird', '执行任务', 40, 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 3', '127.0.0.1', '2018-03-19 10:07:36', NULL);
INSERT INTO `sys_log` VALUES (733, 'MrBird', '暂停任务', 10, 'cc.mrbird.job.controller.JobController.pauseJob()', 'jobIds: 3', '127.0.0.1', '2018-03-19 10:07:53', NULL);
INSERT INTO `sys_log` VALUES (734, 'MrBird', '恢复任务', 17, 'cc.mrbird.job.controller.JobController.resumeJob()', 'jobIds: 1', '127.0.0.1', '2018-03-19 10:08:02', NULL);
INSERT INTO `sys_log` VALUES (735, 'MrBird', '执行任务', 13, 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 1', '127.0.0.1', '2018-03-19 10:08:05', NULL);
INSERT INTO `sys_log` VALUES (737, 'MrBird', '暂停任务', 11, 'cc.mrbird.job.controller.JobController.pauseJob()', 'jobIds: 1', '127.0.0.1', '2018-03-19 10:08:27', NULL);
INSERT INTO `sys_log` VALUES (738, 'MrBird', '执行任务', 14, 'cc.mrbird.job.controller.JobController.runJob()', 'jobIds: 11', '127.0.0.1', '2018-03-19 10:08:34', NULL);
INSERT INTO `sys_log` VALUES (840, 'MrBird', '删除用户', 255, 'cc.mrbird.system.controller.UserController.deleteUsers()', 'ids: 165,166', '127.0.0.1', '2018-03-20 18:34:26', NULL);
INSERT INTO `sys_log` VALUES (841, 'MrBird', '修改用户', 348, 'cc.mrbird.system.controller.UserController.updateUser()', 'user: cc.mrbird.system.domain.User@5adf3b3b  roles: [Ljava.lang.Long;@75a9cd18', '127.0.0.1', '2018-03-21 09:05:12', NULL);
INSERT INTO `sys_log` VALUES (842, 'MrBird', '删除调度日志', 79, 'cc.mrbird.job.controller.JobLogController.deleteJobLog()', 'ids: 2447', '127.0.0.1', '2018-03-22 18:52:10', 'XX内网IP');
INSERT INTO `sys_log` VALUES (843, 'MrBird', '修改用户', 18805, 'cc.mrbird.system.controller.UserController.updateUser()', 'user: cc.mrbird.system.domain.User@1a6c90df  rolesSelect: [Ljava.lang.Long;@4d9b2e06', '127.0.0.1', '2018-03-27 09:20:05', 'XX内网IP');
INSERT INTO `sys_log` VALUES (844, 'MrBird', '修改用户', 5222, 'cc.mrbird.system.controller.UserController.updateUser()', 'user: cc.mrbird.system.domain.User@655c7201  rolesSelect: [Ljava.lang.Long;@1840d3a4', '127.0.0.1', '2018-03-27 09:20:23', 'XX内网IP');
INSERT INTO `sys_log` VALUES (845, 'MrBird', '修改用户', 6989, 'cc.mrbird.system.controller.UserController.updateUser()', 'user: cc.mrbird.system.domain.User@3691c744  rolesSelect: [Ljava.lang.Long;@1cb15d59', '127.0.0.1', '2018-03-27 09:21:09', 'XX内网IP');
INSERT INTO `sys_log` VALUES (846, 'MrBird', '新增任务', 361, 'cc.mrbird.job.controller.JobController.addJob()', 'job: cc.mrbird.job.domain.Job@41ea2910', '127.0.0.1', '2018-03-27 15:24:30', 'XX内网IP');
INSERT INTO `sys_log` VALUES (847, 'MrBird', '修改任务', 429, 'cc.mrbird.job.controller.JobController.updateJob()', 'job: cc.mrbird.job.domain.Job@7cb0d614', '127.0.0.1', '2018-03-27 15:25:31', 'XX内网IP');
INSERT INTO `sys_log` VALUES (848, 'MrBird', '修改任务', 273, 'cc.mrbird.job.controller.JobController.updateJob()', 'job: cc.mrbird.job.domain.Job@4937e65d', '127.0.0.1', '2018-03-27 17:43:09', 'XX内网IP');
INSERT INTO `sys_log` VALUES (849, 'MrBird', '修改任务', 712, 'cc.mrbird.job.controller.JobController.updateJob()', 'job: cc.mrbird.job.domain.Job@aa7781d', '127.0.0.1', '2018-03-27 17:43:31', 'XX内网IP');
INSERT INTO `sys_log` VALUES (850, 'MrBird', '新增任务', 294, 'cc.mrbird.job.controller.JobController.addJob()', 'job: cc.mrbird.job.domain.Job@5543ec34', '127.0.0.1', '2018-03-28 14:36:44', 'XX内网IP');
INSERT INTO `sys_log` VALUES (851, 'MrBird', '修改任务', 353, 'cc.mrbird.job.controller.JobController.updateJob()', 'job: cc.mrbird.job.domain.Job@3fccec56', '127.0.0.1', '2018-03-28 14:37:06', 'XX内网IP');
INSERT INTO `sys_log` VALUES (852, 'MrBird', '修改任务', 262, 'cc.mrbird.job.controller.JobController.updateJob()', 'job: cc.mrbird.job.domain.Job@2ed43da1', '127.0.0.1', '2018-03-28 14:41:50', 'XX内网IP');
INSERT INTO `sys_log` VALUES (853, 'MrBird', '删除任务', 589, 'cc.mrbird.job.controller.JobController.deleteJob()', 'ids: 18,19', '127.0.0.1', '2018-03-29 10:26:30', 'XX内网IP');
INSERT INTO `sys_log` VALUES (854, 'MrBird', '新增任务', 548, 'cc.mrbird.job.controller.JobController.addJob()', 'job: cc.mrbird.job.domain.Job@b404b16', '127.0.0.1', '2018-03-29 10:27:11', 'XX内网IP');
INSERT INTO `sys_log` VALUES (855, 'MrBird', '修改任务', 442, 'cc.mrbird.job.controller.JobController.updateJob()', 'job: cc.mrbird.job.domain.Job@49f25426', '127.0.0.1', '2018-03-29 10:29:18', 'XX内网IP');
INSERT INTO `sys_log` VALUES (856, 'MrBird', '删除任务', 520, 'cc.mrbird.job.controller.JobController.deleteJob()', 'ids: 20', '127.0.0.1', '2018-03-29 10:41:20', 'XX内网IP');
INSERT INTO `sys_log` VALUES (857, 'MrBird', '修改用户', 449, 'cc.mrbird.system.controller.UserController.updateUser()', 'user: cc.mrbird.system.domain.User@68355f70  rolesSelect: [Ljava.lang.Long;@80ce783', '127.0.0.1', '2018-03-29 16:18:26', 'XX内网IP');
INSERT INTO `sys_log` VALUES (858, 'MrBird', '修改用户', 686, 'cc.mrbird.system.controller.UserController.updateUser()', 'user: cc.mrbird.system.domain.User@784012be  rolesSelect: [Ljava.lang.Long;@368eb59f', '127.0.0.1', '2018-03-29 16:18:37', 'XX内网IP');
INSERT INTO `sys_log` VALUES (859, 'MrBird', '删除用户', 200, 'cc.mrbird.system.controller.UserController.deleteUsers()', 'ids: 41,68,92,125,161,162', '127.0.0.1', '2018-04-02 17:29:50', 'XX内网IP');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `parent_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父类id',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `menu_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `sort` tinyint(2) NULL DEFAULT NULL COMMENT '排序',
  `icon` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `perms` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('25d0981f-2a5e-4700-b517-7aa6cb7c94a2', '0', '/admin/menu', '菜单管理', 2, '&#xe647;', NULL, 'sys:menu:view', 'admin', '2019-07-08 23:58:55', NULL, NULL, '1', NULL);
INSERT INTO `sys_menu` VALUES ('3595de6e-6b0d-49b9-90f2-625ae9210f02', '0', '/admin/dict', '数据字典', 3, '&#xe705;', NULL, 'sys:system:dict', 'admin', '2019-07-10 19:34:58', NULL, NULL, '1', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编号\r\n',
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称\r\n',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人\r\n',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间\r\n',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间\r\n',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人\r\n',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注\r\n',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志\r\n\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (3, 58);
INSERT INTO `sys_role_menu` VALUES (3, 59);
INSERT INTO `sys_role_menu` VALUES (3, 61);
INSERT INTO `sys_role_menu` VALUES (3, 81);
INSERT INTO `sys_role_menu` VALUES (3, 82);
INSERT INTO `sys_role_menu` VALUES (3, 83);
INSERT INTO `sys_role_menu` VALUES (3, 86);
INSERT INTO `sys_role_menu` VALUES (3, 87);
INSERT INTO `sys_role_menu` VALUES (3, 88);
INSERT INTO `sys_role_menu` VALUES (3, 89);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (3, 3);
INSERT INTO `sys_role_menu` VALUES (3, 4);
INSERT INTO `sys_role_menu` VALUES (3, 5);
INSERT INTO `sys_role_menu` VALUES (3, 6);
INSERT INTO `sys_role_menu` VALUES (3, 64);
INSERT INTO `sys_role_menu` VALUES (3, 2);
INSERT INTO `sys_role_menu` VALUES (3, 8);
INSERT INTO `sys_role_menu` VALUES (3, 10);
INSERT INTO `sys_role_menu` VALUES (3, 101);
INSERT INTO `sys_role_menu` VALUES (3, 102);
INSERT INTO `sys_role_menu` VALUES (3, 109);
INSERT INTO `sys_role_menu` VALUES (63, 58);
INSERT INTO `sys_role_menu` VALUES (63, 81);
INSERT INTO `sys_role_menu` VALUES (63, 82);
INSERT INTO `sys_role_menu` VALUES (63, 83);
INSERT INTO `sys_role_menu` VALUES (24, 8);
INSERT INTO `sys_role_menu` VALUES (24, 2);
INSERT INTO `sys_role_menu` VALUES (24, 10);
INSERT INTO `sys_role_menu` VALUES (65, 86);
INSERT INTO `sys_role_menu` VALUES (65, 88);
INSERT INTO `sys_role_menu` VALUES (65, 89);
INSERT INTO `sys_role_menu` VALUES (65, 58);
INSERT INTO `sys_role_menu` VALUES (65, 61);
INSERT INTO `sys_role_menu` VALUES (2, 81);
INSERT INTO `sys_role_menu` VALUES (2, 61);
INSERT INTO `sys_role_menu` VALUES (2, 24);
INSERT INTO `sys_role_menu` VALUES (2, 82);
INSERT INTO `sys_role_menu` VALUES (2, 83);
INSERT INTO `sys_role_menu` VALUES (2, 58);
INSERT INTO `sys_role_menu` VALUES (2, 59);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 8);
INSERT INTO `sys_role_menu` VALUES (2, 10);
INSERT INTO `sys_role_menu` VALUES (23, 11);
INSERT INTO `sys_role_menu` VALUES (23, 12);
INSERT INTO `sys_role_menu` VALUES (23, 13);
INSERT INTO `sys_role_menu` VALUES (23, 3);
INSERT INTO `sys_role_menu` VALUES (23, 1);
INSERT INTO `sys_role_menu` VALUES (25, 1);
INSERT INTO `sys_role_menu` VALUES (25, 3);
INSERT INTO `sys_role_menu` VALUES (1, 59);
INSERT INTO `sys_role_menu` VALUES (1, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (1, 67);
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (1, 6);
INSERT INTO `sys_role_menu` VALUES (1, 20);
INSERT INTO `sys_role_menu` VALUES (1, 21);
INSERT INTO `sys_role_menu` VALUES (1, 22);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 8);
INSERT INTO `sys_role_menu` VALUES (1, 58);
INSERT INTO `sys_role_menu` VALUES (1, 66);
INSERT INTO `sys_role_menu` VALUES (1, 11);
INSERT INTO `sys_role_menu` VALUES (1, 12);
INSERT INTO `sys_role_menu` VALUES (1, 64);
INSERT INTO `sys_role_menu` VALUES (1, 13);
INSERT INTO `sys_role_menu` VALUES (1, 14);
INSERT INTO `sys_role_menu` VALUES (1, 65);
INSERT INTO `sys_role_menu` VALUES (1, 15);
INSERT INTO `sys_role_menu` VALUES (1, 16);
INSERT INTO `sys_role_menu` VALUES (1, 17);
INSERT INTO `sys_role_menu` VALUES (1, 18);
INSERT INTO `sys_role_menu` VALUES (1, 23);
INSERT INTO `sys_role_menu` VALUES (1, 81);
INSERT INTO `sys_role_menu` VALUES (1, 82);
INSERT INTO `sys_role_menu` VALUES (1, 83);
INSERT INTO `sys_role_menu` VALUES (1, 19);
INSERT INTO `sys_role_menu` VALUES (1, 24);
INSERT INTO `sys_role_menu` VALUES (1, 61);
INSERT INTO `sys_role_menu` VALUES (1, 86);
INSERT INTO `sys_role_menu` VALUES (1, 87);
INSERT INTO `sys_role_menu` VALUES (1, 88);
INSERT INTO `sys_role_menu` VALUES (1, 89);
INSERT INTO `sys_role_menu` VALUES (1, 101);
INSERT INTO `sys_role_menu` VALUES (1, 102);
INSERT INTO `sys_role_menu` VALUES (1, 103);
INSERT INTO `sys_role_menu` VALUES (1, 104);
INSERT INTO `sys_role_menu` VALUES (1, 105);
INSERT INTO `sys_role_menu` VALUES (1, 106);
INSERT INTO `sys_role_menu` VALUES (1, 107);
INSERT INTO `sys_role_menu` VALUES (1, 108);
INSERT INTO `sys_role_menu` VALUES (1, 109);
INSERT INTO `sys_role_menu` VALUES (1, 110);
INSERT INTO `sys_role_menu` VALUES (64, 59);
INSERT INTO `sys_role_menu` VALUES (64, 58);
INSERT INTO `sys_role_menu` VALUES (1, 113);
INSERT INTO `sys_role_menu` VALUES (1, 114);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id\r\n',
  `role_id` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id\r\n',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人\r\n',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间\r\n',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间\r\n',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人\r\n',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志\r\n',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色_用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '17210210613', '1', NULL, NULL, NULL, NULL, NULL, '0');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名\r\n',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 0锁定 1有效',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('34a92116-39a2-42a4-bf9f-8986315044f9', 'admin', '晟曦', '$2a$10$KWkCGztjP2wYfgjwlHMZ3eeK4Pd6ldriHAY6hbIVv5jqeODgWBKIi', '1', '2019-05-19 01:25:34', NULL, NULL, NULL, NULL, '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '测试表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('21324564964', '焰皓', 2, '0');

SET FOREIGN_KEY_CHECKS = 1;

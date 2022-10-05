/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 05/10/2022 19:50:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `countryname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `countrycode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '中国', 'CN');
INSERT INTO `country` VALUES (2, '美国', 'US');
INSERT INTO `country` VALUES (3, '俄罗斯', 'RU');
INSERT INTO `country` VALUES (4, '英国', 'GB');
INSERT INTO `country` VALUES (5, '法国', 'FR');
INSERT INTO `country` VALUES (6, '123', '132');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `privilege_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `privilege_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES (1, '用户管理', '/users');
INSERT INTO `sys_privilege` VALUES (2, '用户管理', '/roles');
INSERT INTO `sys_privilege` VALUES (3, '系统日志', '/logs');
INSERT INTO `sys_privilege` VALUES (4, '人员维护', '/persons');
INSERT INTO `sys_privilege` VALUES (5, '单位维护', '/companies');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `enabled` int NULL DEFAULT NULL COMMENT '有效标志',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 1, 1, '2016-04-01 17:02:14');
INSERT INTO `sys_role` VALUES (2, '普通用户', 1, 1, '2016-04-01 17:06:14');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege`  (
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `privilege_id` bigint NULL DEFAULT NULL COMMENT '权限ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES (1, 1);
INSERT INTO `sys_role_privilege` VALUES (1, 3);
INSERT INTO `sys_role_privilege` VALUES (1, 2);
INSERT INTO `sys_role_privilege` VALUES (2, 4);
INSERT INTO `sys_role_privilege` VALUES (2, 5);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'test@mybatis.tk' COMMENT '邮箱',
  `user_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `head_img` blob NULL COMMENT '头像',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1014 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '123456', 'test@mybatis.tk', '管理员', NULL, '2020-04-01 17:00:00');
INSERT INTO `sys_user` VALUES (1001, 'test', '123456', 'test@mybatis.tk', '测试用户', NULL, '2020-04-01 17:10:00');
INSERT INTO `sys_user` VALUES (1013, 'test3123', '123456', 'test@mybatis.tk', 'test info', 0x010203, '2022-09-13 14:40:26');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (1001, 2);

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee` VALUES (1, 'tom', '0', '123@qq.com');
INSERT INTO `tbl_employee` VALUES (2, 'jack', '0', '456@qq.com');
INSERT INTO `tbl_employee` VALUES (3, 'mick', '1', '213@qq.com');
INSERT INTO `tbl_employee` VALUES (4, 'tckm', '1', '1231@qq.com');
INSERT INTO `tbl_employee` VALUES (7, 'jtc', '0', 'qq31@qq.com');

SET FOREIGN_KEY_CHECKS = 1;

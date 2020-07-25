/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : dev

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/07/2020 13:47:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aauth_groups
-- ----------------------------
DROP TABLE IF EXISTS `aauth_groups`;
CREATE TABLE `aauth_groups`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `definition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aauth_groups
-- ----------------------------
INSERT INTO `aauth_groups` VALUES ('ADMIN', 'ROLE_ADMIN', 'ini admin');
INSERT INTO `aauth_groups` VALUES ('SUPER_ADMIN', 'ROLE_SUPER_ADMIN', 'ini super admin');
INSERT INTO `aauth_groups` VALUES ('USER', 'ROLE_USER', 'ini user');

-- ----------------------------
-- Table structure for aauth_perm_to_group
-- ----------------------------
DROP TABLE IF EXISTS `aauth_perm_to_group`;
CREATE TABLE `aauth_perm_to_group`  (
  `perm_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`perm_id`, `group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aauth_perms
-- ----------------------------
DROP TABLE IF EXISTS `aauth_perms`;
CREATE TABLE `aauth_perms`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `aauth_perms` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `definition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for aauth_user_to_groups
-- ----------------------------
DROP TABLE IF EXISTS `aauth_user_to_groups`;
CREATE TABLE `aauth_user_to_groups`  (
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`, `group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aauth_user_to_groups
-- ----------------------------
INSERT INTO `aauth_user_to_groups` VALUES ('test1', 'ADMIN');
INSERT INTO `aauth_user_to_groups` VALUES ('test1', 'SUPER_ADMIN');
INSERT INTO `aauth_user_to_groups` VALUES ('test1', 'USER');
INSERT INTO `aauth_user_to_groups` VALUES ('test2', 'USER');

-- ----------------------------
-- Table structure for aauth_users
-- ----------------------------
DROP TABLE IF EXISTS `aauth_users`;
CREATE TABLE `aauth_users`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `banned` int(11) NULL DEFAULT NULL,
  `last_login` datetime(6) NULL DEFAULT NULL,
  `date_created` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aauth_users
-- ----------------------------
INSERT INTO `aauth_users` VALUES ('test1', NULL, '123', '001', 'Ferdinand', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `aauth_users` VALUES ('test2', NULL, '456', '002', 'user', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

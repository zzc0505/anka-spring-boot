/*
 Navicat Premium Data Transfer

 Source Server         : anka
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : anka

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 09/11/2019 12:05:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for core_menu
-- ----------------------------
DROP TABLE IF EXISTS `core_menu`;
CREATE TABLE `core_menu`  (
  `CRME_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `CRME_PARENT_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父UUID',
  `CRME_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `CRME_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `CRME_TARGET` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示方式',
  `CRME_ICON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标CLASS',
  `CRME_TYPE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单类型',
  `CRME_STATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `CRME_CDATE` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `CRME_UDATE` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `CRME_ORD` int(255) NULL DEFAULT NULL COMMENT '排序',
  `CRME_REMARK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`CRME_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_menu
-- ----------------------------
INSERT INTO `core_menu` VALUES ('AA60D193DA314E67885E554C790DE669', '0', '测试菜单', 'http://asdasd', '1', '.asdasd', '1', '1', '2019-05-01 22:00:15', '2019-05-01 22:00:15', NULL, NULL);

-- ----------------------------
-- Table structure for core_orginaze
-- ----------------------------
DROP TABLE IF EXISTS `core_orginaze`;
CREATE TABLE `core_orginaze`  (
  `CROR_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CROR_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CROR_CDATE` datetime(0) NULL DEFAULT NULL,
  `CROR_UDATE` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`CROR_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for core_role
-- ----------------------------
DROP TABLE IF EXISTS `core_role`;
CREATE TABLE `core_role`  (
  `CRRE_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `CRRE_NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `CRRE_KEY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '唯一标识',
  `CRRE_NOTE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色说明',
  `CRRE_STATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `CRRE_CDATE` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CRRE_UDATE` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `CRRE_ORD` int(255) NULL DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`CRRE_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_role
-- ----------------------------
INSERT INTO `core_role` VALUES ('13263FCE426811E9AB12BC5FF4B51602', 'asdasd', 'ddd', 'asd', '0', '2019-03-09 20:36:51', '2019-03-09 20:36:51', 1);
INSERT INTO `core_role` VALUES ('423E3C8B426111E9AB12BC5FF4B51602', '测试', 'fff', '123', '0', '2019-03-09 19:48:18', '2019-03-09 19:48:18', 123);

-- ----------------------------
-- Table structure for core_role_user
-- ----------------------------
DROP TABLE IF EXISTS `core_role_user`;
CREATE TABLE `core_role_user`  (
  `CRUE_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `CRUE_CRUR_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户UUID',
  `CRUE_CRRE_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色UUID',
  PRIMARY KEY (`CRUE_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for core_user
-- ----------------------------
DROP TABLE IF EXISTS `core_user`;
CREATE TABLE `core_user`  (
  `CRUR_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid',
  `CRUR_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `CRUR_PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码 ',
  `CRUR_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 1男2女3保密',
  `CRUR_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `CRUR_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固话号码',
  `CRUR_EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件地址',
  `CRUR_POST` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `CRUR_CROR_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属机构uuid',
  `CRUR_CROR_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属机构name',
  `CRUR_LOGTYPE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆方式',
  `CRUR_STATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户状态 0启用1禁用',
  `CRUR_ORD` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `CRUR_LOCKPASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锁屏密码',
  `CRUR_NATURE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性质',
  `CRUR_PINYIN` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼音简写',
  `CRUR_PASSWORDEXPTIME` datetime(4) NULL DEFAULT NULL COMMENT '密码过期时间',
  `CRUR_CDATE` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CRUR_UDATE` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `CRUR_REMARKERS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CRUR_LOCKSTATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锁屏状态 0未锁1已锁',
  PRIMARY KEY (`CRUR_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of core_user
-- ----------------------------
INSERT INTO `core_user` VALUES ('C1E05449D37640E69444456758A55746', '十六', '4ql1TElZF3U=', '3', '13566687779', NULL, 'azsdasd@qq.com', NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, '2019-03-09 21:18:52', NULL, NULL, '0');
INSERT INTO `core_user` VALUES ('C627F2EE250311E98815BC5FF4B51602', 'admin', '4ql1TElZF3U=', '2', '17605882455', NULL, 'zzc0505@qq.com', '超级管理员', NULL, '', NULL, '0', NULL, '123123', NULL, NULL, NULL, '2019-01-31 10:56:15', '2019-01-31 10:56:15', '我很懒', '0');

SET FOREIGN_KEY_CHECKS = 1;

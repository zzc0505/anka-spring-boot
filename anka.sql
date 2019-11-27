/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : localhost:3306
 Source Schema         : anka

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 27/11/2019 16:53:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for core_grant
-- ----------------------------
DROP TABLE IF EXISTS `core_grant`;
CREATE TABLE `core_grant`  (
  `CRGR_UUID` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `CRGR_NAME` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `CRGR_KEY` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `CRGR_NOTE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `CRGR_STATUS` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `CRGR_CDATE` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CRGR_UDATE` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `CRGR_ORD` int(255) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`CRGR_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Compact;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of core_menu
-- ----------------------------
INSERT INTO `core_menu` VALUES ('00C3442DEEE849B3BDD3F2C7A8459C77', '0DCAE759A88C42749809EF0E3595D1A0', '用户列表', '/core/user/userlist', '2', '', '2', '0', '2019-11-27 15:04:52', '2019-11-27 15:04:52', 10, NULL);
INSERT INTO `core_menu` VALUES ('0DCAE759A88C42749809EF0E3595D1A0', 'E92B62EC170C445FBAEFB75B50467C46', '用户设置', '', '2', '', '1', '0', '2019-11-27 15:04:03', '2019-11-27 15:04:03', 5, NULL);
INSERT INTO `core_menu` VALUES ('1014F82839054AD7A1F1053F715D112A', '', '首页', '', '2', '', '0', '0', '2019-11-27 15:02:23', '2019-11-27 15:02:23', 1, NULL);
INSERT INTO `core_menu` VALUES ('12FCFC31151848E696E2485343BC33BC', 'E92B62EC170C445FBAEFB75B50467C46', '字典设置', '', '2', '', '1', '0', '2019-11-27 15:04:09', '2019-11-27 15:04:09', 6, NULL);
INSERT INTO `core_menu` VALUES ('2906B9C730CF41FFA91F75BF7B6DEC34', '1014F82839054AD7A1F1053F715D112A', '首页', '', '2', '', '1', '0', '2019-11-27 15:05:08', '2019-11-27 15:05:08', 13, NULL);
INSERT INTO `core_menu` VALUES ('3C048FA166FE43289C0DA1395E3DE9C7', 'E92B62EC170C445FBAEFB75B50467C46', '组织设置', '', '2', '', '1', '0', '2019-11-27 14:57:01', '2019-11-27 14:57:01', 24, NULL);
INSERT INTO `core_menu` VALUES ('4547D11208AA4C34AE0734B98DC475F6', 'CECC013D3E8744AFA5251D9A73D3F2BF', '菜单列表', '/core/menu/menulist', '2', '', '2', '0', '2019-11-27 15:04:53', '2019-11-27 15:04:53', 11, NULL);
INSERT INTO `core_menu` VALUES ('4AD1C56BFC954C5BB3F7BAF803D4E820', '', '邮件', '', '2', '', '0', '0', '2019-11-27 15:02:34', '2019-11-27 15:02:34', 2, NULL);
INSERT INTO `core_menu` VALUES ('65827834162048B19D56FC7395326D53', 'E92B62EC170C445FBAEFB75B50467C46', '定时设置', '', '2', '', '1', '0', '2019-11-27 14:57:32', '2019-11-27 14:57:32', 25, NULL);
INSERT INTO `core_menu` VALUES ('69B1CC00B2D8406FBE433DF36BD038BF', '9A2346A0B9AC445DA1603EB17407D270', '角色列表', '/core/role/rolelist', '2', '', '2', '0', '2019-11-27 15:05:00', '2019-11-27 15:05:00', 12, NULL);
INSERT INTO `core_menu` VALUES ('9A2346A0B9AC445DA1603EB17407D270', 'E92B62EC170C445FBAEFB75B50467C46', '角色设置', '', '2', '', '1', '0', '2019-11-27 15:04:20', '2019-11-27 15:04:20', 7, NULL);
INSERT INTO `core_menu` VALUES ('B9608534D5594F79A36347556F3DDC46', '2906B9C730CF41FFA91F75BF7B6DEC34', '首页界面', '/home', '2', '', '2', '0', '2019-11-27 15:04:43', '2019-11-27 15:04:43', 9, NULL);
INSERT INTO `core_menu` VALUES ('CECC013D3E8744AFA5251D9A73D3F2BF', 'E92B62EC170C445FBAEFB75B50467C46', '菜单设置', '', '2', '', '1', '0', '2019-11-27 15:04:24', '2019-11-27 15:04:24', 8, NULL);
INSERT INTO `core_menu` VALUES ('E92B62EC170C445FBAEFB75B50467C46', '', '系统设置', '', '2', '', '0', '0', '2019-11-27 15:02:43', '2019-11-27 15:02:43', 4, NULL);
INSERT INTO `core_menu` VALUES ('F7C451B4530745F482D9A756F23E4F82', '', '短信', '', '2', '', '0', '0', '2019-11-27 15:02:39', '2019-11-27 15:02:39', 3, NULL);

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of core_role
-- ----------------------------
INSERT INTO `core_role` VALUES ('501A893B0AB111EA8D4300FF59783978', 'asdsd', 'asdasd', 'asdasd', '0', NULL, NULL, 1);

-- ----------------------------
-- Table structure for core_role_grant
-- ----------------------------
DROP TABLE IF EXISTS `core_role_grant`;
CREATE TABLE `core_role_grant`  (
  `CRRG_UUID` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `CRRG_CRRE_UUID` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色UUID',
  `CRRG_CRGR_UUID` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限UUID',
  PRIMARY KEY (`CRRG_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for core_role_user
-- ----------------------------
DROP TABLE IF EXISTS `core_role_user`;
CREATE TABLE `core_role_user`  (
  `CRUE_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `CRUE_CRUR_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户UUID',
  `CRUE_CRRE_UUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色UUID',
  PRIMARY KEY (`CRUE_UUID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for core_seq
-- ----------------------------
DROP TABLE IF EXISTS `core_seq`;
CREATE TABLE `core_seq`  (
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '序列名',
  `start_value` int(11) NOT NULL COMMENT '初始值',
  `increment_value` int(11) NOT NULL DEFAULT 1 COMMENT '步长',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '自增序列表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of core_seq
-- ----------------------------
INSERT INTO `core_seq` VALUES ('NEXT', 26, 1);

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of core_user
-- ----------------------------
INSERT INTO `core_user` VALUES ('5B7D18F2C35345AFA709237A4210E31B', '李四', '7c1ae7d5516285f7b37d5d9b48c3e9fa', '1', '17605882458', NULL, 'zzc0505@qq.com', NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, '2019-11-19 10:30:47', '2019-11-19 10:30:47', NULL, '0');
INSERT INTO `core_user` VALUES ('60B8D719CF3E463AB9C0873B8544E981', '张三', '7c1ae7d5516285f7b37d5d9b48c3e9fa', '1', '17605882456', NULL, 'zzc0505@qq.com', NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, '2019-11-19 10:30:16', '2019-11-19 10:30:16', NULL, '0');
INSERT INTO `core_user` VALUES ('8860B6B14B5A4F9A8B05CC2D072E7A6B', 'admin', '6abaf34f27994907ba31467a3504944a', '1', '17605882455', NULL, 'zzc0505@qq.com', NULL, NULL, NULL, NULL, '0', NULL, NULL, NULL, NULL, NULL, '2019-11-19 10:28:33', '2019-11-19 12:34:59', NULL, '0');

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
delimiter ;;
CREATE FUNCTION `nextval`(str varchar(50))
 RETURNS int(11)
begin
	declare i int;
	set i=(select start_value from core_seq where name=str);
	update core_seq
		set start_value=i+increment_value
	where name=str;
return i;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

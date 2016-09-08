/*
Navicat MySQL Data Transfer

Source Server         : 第二个链接
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2016-09-08 18:16:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) default NULL COMMENT '区域编码',
  `type` char(1) default NULL COMMENT '区域类型',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) default NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL default '0' COMMENT '删除标记',
  PRIMARY KEY  (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of sys_area
-- ----------------------------
INSERT INTO `sys_area` VALUES ('1', '0', '中国', '10', '100000', '1', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('2', '1', '山东省', '20', '110000', '2', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('3', '2', '济南市', '30', '110101', '3', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('4', '3', '历城区', '40', '110102', '4', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('5', '3', '历下区', '50', '110104', '4', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_area` VALUES ('6', '3', '高新区', '60', '110105', '4', '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(100) NOT NULL,
  `parentid` varchar(100) default NULL,
  `menuname` varchar(100) default NULL,
  `url` varchar(200) default NULL,
  `permission` varchar(100) default NULL,
  `status` varchar(10) default NULL,
  `icon` varchar(200) default NULL,
  `createman` varchar(50) default NULL,
  `createtime` datetime default NULL,
  `order` varchar(10) default NULL,
  `remark` varchar(200) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0', '', '系统菜单', null, null, '0', null, '系统管理员', '2016-07-18 11:32:07', '1', '顶级菜单', '0');
INSERT INTO `sys_menu` VALUES ('10', '3', '角色管理', 'jsp/sys/rolemanager.jsp', null, '0', null, '系统管理员', '2016-07-20 13:43:16', '102', '二级菜单', '0');
INSERT INTO `sys_menu` VALUES ('11', '8', '查看用户', null, 'sys:user:query', '1', null, '系统管理员', '2016-07-20 13:43:21', '1000', '查询用户信息', '1');
INSERT INTO `sys_menu` VALUES ('12', '8', '新增用户', null, 'sys:user:add', '1', null, '系统管理员', '2016-07-20 13:43:25', '1001', '新增用户信息', '1');
INSERT INTO `sys_menu` VALUES ('13', '8', '删除用户', null, 'sys:user:delete', '1', null, '系统管理员', '2016-07-20 13:43:30', '1002', '删除用户信息', '1');
INSERT INTO `sys_menu` VALUES ('14', '8', '编辑用户', null, 'sys:user:edit', '1', null, '系统管理员', '2016-07-29 10:35:34', '1003', '编辑用户信息', '1');
INSERT INTO `sys_menu` VALUES ('15', '0', '财务管理', null, null, '0', null, '系统管理员', '2016-08-04 16:08:30', '10', '一级菜单', '0');
INSERT INTO `sys_menu` VALUES ('16', '15', '预付款充值', 'jsp/finance/recharge.jsp', null, '0', null, '系统管理员', '2016-08-04 16:10:48', '105', '二级菜单', '0');
INSERT INTO `sys_menu` VALUES ('17', '10', '查看角色', null, 'sys:role:query', '1', null, '系统管理员', '2016-09-03 17:31:48', '1004', '查询角色信息', '1');
INSERT INTO `sys_menu` VALUES ('18', '10', '新增角色', null, 'sys:role:add', '1', null, '系统管理员', '2016-09-03 17:31:48', '1005', '新增角色信息', '1');
INSERT INTO `sys_menu` VALUES ('19', '10', '编辑角色', null, 'sys:role:edit', '1', null, '系统管理员', '2016-09-03 17:31:48', '1006', '编辑角色信息', '1');
INSERT INTO `sys_menu` VALUES ('2', '0', '监控中心', null, null, '0', null, '系统管理员', '2016-07-18 11:37:52', '12', '一级菜单', '0');
INSERT INTO `sys_menu` VALUES ('20', '10', '删除角色', null, 'sys:role:delete', '1', null, '系统管理员', '2016-09-03 17:31:48', '1007', '删除角色信息', '1');
INSERT INTO `sys_menu` VALUES ('21', '10', '资源分配', null, 'sys:role:empower', '1', null, '系统管理员', '2016-09-03 17:31:48', '1007', '角色分配菜单资源', '1');
INSERT INTO `sys_menu` VALUES ('3', '0', '系统设置', null, null, '0', null, '系统管理员', '2016-07-18 11:39:13', '11', '一级菜单', '0');
INSERT INTO `sys_menu` VALUES ('4', '3', '机构管理', 'jsp/sys/officemanager.jsp', null, '0', null, '系统管理员', '2016-07-18 11:40:06', '20', '二级菜单', '0');
INSERT INTO `sys_menu` VALUES ('6', '2', '登陆日志管理', null, null, '0', null, '系统管理员', '2016-07-18 11:45:03', '103', '二级菜单', '0');
INSERT INTO `sys_menu` VALUES ('7', '2', '数据库监控', null, null, '0', null, '系统管理员', '2016-07-18 11:45:49', '104', '二级菜单', '0');
INSERT INTO `sys_menu` VALUES ('8', '3', '用户管理', 'jsp/sys/usermanager.jsp', null, '0', null, '系统管理员', '2016-07-18 11:46:43', '100', '二级菜单', '0');
INSERT INTO `sys_menu` VALUES ('9', '3', '资源管理', 'jsp/sys/menumanager.jsp', null, '0', null, '系统管理员', '2016-07-20 13:45:10', '101', '二级菜单', '0');

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `status` decimal(1,0) default NULL,
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) NOT NULL COMMENT '归属区域',
  `code` varchar(100) default NULL COMMENT '区域编码',
  `type` char(1) NOT NULL COMMENT '机构类型',
  `grade` char(1) NOT NULL COMMENT '机构等级',
  `address` varchar(255) default NULL COMMENT '联系地址',
  `zip_code` varchar(100) default NULL COMMENT '邮政编码',
  `master` varchar(100) default NULL COMMENT '负责人',
  `phone` varchar(200) default NULL COMMENT '电话',
  `fax` varchar(200) default NULL COMMENT '传真',
  `email` varchar(200) default NULL COMMENT '邮箱',
  `USEABLE` varchar(64) default NULL COMMENT '是否启用',
  `PRIMARY_PERSON` varchar(64) default NULL COMMENT '主负责人',
  `DEPUTY_PERSON` varchar(64) default NULL COMMENT '副负责人',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) default NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL default '0' COMMENT '删除标记',
  PRIMARY KEY  (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of sys_office
-- ----------------------------
INSERT INTO `sys_office` VALUES ('0', '', '敏思达深圳总部', '1', '10', '2', '100000', '1', '1', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('10', '0', '综合管理部', null, '30', '3', '200003', '2', '2', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('11', '0', '方案产品中心', null, '40', '3', '200004', '2', '2', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('12', '0', 'E3系统市场部', null, '0', '4', '201000', '1', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('13', '0', '领导决策者', null, '10', '4', '201001', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('14', '6', '项目中心', null, '20', '4', '201002', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('15', '6', '财务部', null, '30', '4', '201003', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('16', '5', '运维部', null, '40', '4', '201004', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('17', '6', '综合管理部门', null, '40', '5', '201010', '1', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('18', '8', '集成交流', null, '10', '5', '201011', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('19', '8', '同城系列产品市场部', null, '20', '5', '201012', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('2', '6', '研发部', null, '10', '2', '100001', '2', '1', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('20', '6', 'E2产品系列市场部', null, '30', '5', '201013', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('21', '6', '测试中心', null, '40', '5', '201014', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('22', '5', '公司领导', null, '50', '6', '201010', '1', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('23', '5', '技术部', null, '10', '6', '201011', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('24', '5', '行政管理', null, '20', '6', '201012', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('25', '5', '财务部', null, '30', '6', '201013', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('26', '5', '市场部', null, '40', '6', '201014', '2', '3', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('5', '0', '敏思达技术有限公司', null, '40', '2', '100004', '2', '1', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('6', '0', '深圳敏思达信息技术有限公司', null, '50', '2', '100005', '2', '1', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('8', '0', '深圳时代启华', null, '10', '3', '200001', '2', '2', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');
INSERT INTO `sys_office` VALUES ('9', '8', '综合部', null, '20', '3', '200002', '2', '2', null, null, null, null, null, null, '1', null, null, '1', '2013-05-27 08:00:00', '1', '2013-05-27 08:00:00', null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(128) NOT NULL,
  `available` char(1) default NULL COMMENT '是否可用,1：可用，0不可用',
  `belongoffice` varchar(50) default NULL,
  `englishname` varchar(50) default NULL,
  `roletype` varchar(50) default NULL,
  `userid` varchar(50) default NULL,
  `createperson` varchar(50) default NULL,
  `createdate` datetime default NULL,
  `remark` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系统管理员', '1', '敏思达深圳总部', 'manageruser', '管理员', null, '李易峰', '2016-09-03 17:21:46', '这是系统管理员的最高权限');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(36) NOT NULL,
  `sys_role_id` varchar(32) NOT NULL COMMENT '角色id',
  `sys_permission_id` varchar(32) NOT NULL COMMENT '权限id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `sys_role_permission` VALUES ('10', '1', '10');
INSERT INTO `sys_role_permission` VALUES ('11', '1', '11');
INSERT INTO `sys_role_permission` VALUES ('12', '1', '12');
INSERT INTO `sys_role_permission` VALUES ('13', '1', '13');
INSERT INTO `sys_role_permission` VALUES ('14', '1', '14');
INSERT INTO `sys_role_permission` VALUES ('15', '1', '0');
INSERT INTO `sys_role_permission` VALUES ('16', '1', '15');
INSERT INTO `sys_role_permission` VALUES ('17', '1', '16');
INSERT INTO `sys_role_permission` VALUES ('18', '1', '17');
INSERT INTO `sys_role_permission` VALUES ('19', '1', '18');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `sys_role_permission` VALUES ('20', '1', '19');
INSERT INTO `sys_role_permission` VALUES ('21', '1', '20');
INSERT INTO `sys_role_permission` VALUES ('22', '1', '21');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '3');
INSERT INTO `sys_role_permission` VALUES ('4', '1', '4');
INSERT INTO `sys_role_permission` VALUES ('5', '1', '5');
INSERT INTO `sys_role_permission` VALUES ('6', '1', '6');
INSERT INTO `sys_role_permission` VALUES ('7', '1', '7');
INSERT INTO `sys_role_permission` VALUES ('8', '1', '8');
INSERT INTO `sys_role_permission` VALUES ('9', '1', '9');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `usercode` varchar(32) NOT NULL COMMENT '账号',
  `username` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(100) default NULL,
  `phone` varchar(50) default NULL,
  `email` varchar(100) default NULL,
  `salt` varchar(64) default NULL COMMENT '盐',
  `locked` char(1) default NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  `officeid` varchar(100) default NULL,
  `birthday` date default NULL,
  `address` varchar(200) default NULL,
  `createdate` datetime default NULL,
  `remark` varchar(500) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('201406011744500672', 'A002', 'lixfadmin', '6c19f060886d43482b83aad95cc2e74b', '廉伟娇', '13776854385', 'lixfadmin@163.com', '33e3ce3f29dafff6971af8c1496f062c', '0', '0', '2016-07-04', '测试的地址信息', '2016-07-20 17:23:05', '打算啦的数据');
INSERT INTO `sys_user` VALUES ('201406011744500673', 'A001', 'msdadmin', '6c19f060886d43482b83aad95cc2e74b', '李易峰', '15246584685', 'msdadmin@163.com', '33e3ce3f29dafff6971af8c1496f062c', '0', '0', '2016-07-16', '测试的数据', '2016-07-16 17:23:00', '哈哈哈');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `sys_user_id` varchar(32) NOT NULL,
  `sys_role_id` varchar(32) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f28', '201406011744500673', '1');
INSERT INTO `sys_user_role` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f28', 'lisi', 'ebc9d647-c6f9-11e4-b137-0adc305c');

-- ----------------------------
-- Table structure for tab_pay_record
-- ----------------------------
DROP TABLE IF EXISTS `tab_pay_record`;
CREATE TABLE `tab_pay_record` (
  `id` int(11) NOT NULL COMMENT '主键',
  `recordno` varchar(50) default NULL COMMENT '支付记录好',
  `payclient` varchar(100) NOT NULL COMMENT '支付客户',
  `payfee` float NOT NULL COMMENT '付款金额',
  `paytime` timestamp NULL default NULL COMMENT '交易时间',
  `payaddress` varchar(50) default NULL COMMENT '发起请求的IP地址',
  `currency` varchar(10) default NULL COMMENT '币种',
  `paytype` varchar(20) default NULL COMMENT '支付类型',
  `payway` varchar(20) default NULL COMMENT '支付方式',
  `payflag` int(11) default NULL COMMENT '支付标识(0-成功，1-失败)',
  `remark` varchar(200) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_pay_record
-- ----------------------------
INSERT INTO `tab_pay_record` VALUES ('1', '20160805001', '15654558695', '0.01', '2016-08-04 02:57:02', '192.168.2.16', 'RMB', '充值', '微信', '0', '预付款充值');

-- ----------------------------
-- View structure for account_manage
-- ----------------------------
DROP VIEW IF EXISTS `account_manage`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `account_manage` AS ( SELECT
    t1.id,
    t1.account,
    t5.name dep_name,
    t5.parent_id dep_parent_id,
    t5.id dep_id
  FROM account t1 
      LEFT JOIN department_account t4 on t4.account_id=t1.id
    LEFT JOIN department t5 on t5.id=t4.dep_id) ;

-- ----------------------------
-- Function structure for getChildList
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getChildList`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
	DECLARE
		sChildList VARCHAR (1000);

DECLARE
	sChildTemp VARCHAR (1000);


SET sChildTemp = cast(rootId AS CHAR);


WHILE sChildTemp IS NOT NULL DO

IF (sChildList IS NOT NULL) THEN

SET sChildList = concat(sChildList, ',', sChildTemp);


ELSE

SET sChildList = concat(sChildTemp);


END
IF;

SELECT
	group_concat(id) INTO sChildTemp
FROM
	sys_office
WHERE
	FIND_IN_SET(parent_id, sChildTemp) > 0;


END
WHILE;

RETURN sChildList;


END
;;
DELIMITER ;

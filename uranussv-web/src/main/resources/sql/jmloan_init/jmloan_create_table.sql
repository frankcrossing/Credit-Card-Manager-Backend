/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.17 : Database - jmloan
*********************************************************************
*/

/*Table structure for table `address_blacklist` */

DROP TABLE IF EXISTS `address_blacklist`;

CREATE TABLE `address_blacklist` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL COMMENT 'ocr身份证地址',
  `addAdminId` int(11) DEFAULT '0' COMMENT '添加管理员标识',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `removeAdminId` int(11) DEFAULT '0' COMMENT '移除管理员标识',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `address` (`address`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='户籍地址黑名单';

/*Table structure for table `allow_bank_info` */

DROP TABLE IF EXISTS `allow_bank_info`;

CREATE TABLE `allow_bank_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `payType` enum('CJPAY','QT') DEFAULT 'CJPAY' COMMENT '类型 CJPAY畅捷支付',
  `bankCode` varchar(30) DEFAULT NULL COMMENT '银行编码',
  `bankName` varchar(50) DEFAULT NULL COMMENT '银行名称',
  `singleLimitAmount` decimal(11,2) DEFAULT '0.00' COMMENT '单笔限额',
  `dayLimitAmount` decimal(11,2) DEFAULT '0.00' COMMENT '每日限额',
  PRIMARY KEY (`id`),
  KEY `payType` (`payType`),
  KEY `bankCode` (`bankCode`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='支持银行信息管理';

/*Table structure for table `app_config` */

DROP TABLE IF EXISTS `app_config`;

CREATE TABLE `app_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `intefaceType` varchar(20) DEFAULT NULL COMMENT 'app类型',
  `intefaceTypeName` varchar(20) DEFAULT NULL COMMENT 'app类型名称',
  `smsSign` varchar(20) DEFAULT NULL COMMENT '短信签名',
  `jsonString` text COMMENT 'json数据',
  `iosTestPhone` bigint(20) DEFAULT NULL COMMENT '苹果测试号码',
  `addTime` int(11) DEFAULT NULL COMMENT '添加时间',
  `updateTime` int(11) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `intefaceType` (`intefaceType`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Table structure for table `area_info` */

DROP TABLE IF EXISTS `area_info`;

CREATE TABLE `area_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `areaCode` int(11) NOT NULL DEFAULT '0' COMMENT '地区编码',
  `areaName` varchar(50) NOT NULL COMMENT '地区名称',
  `parentCode` int(11) DEFAULT '0' COMMENT '父级code',
  `areaDeep` int(1) DEFAULT '0' COMMENT '1省 2市 3区/县',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3524 DEFAULT CHARSET=utf8 COMMENT='省份信息表';

/*Table structure for table `bank_card_bin` */

DROP TABLE IF EXISTS `bank_card_bin`;

CREATE TABLE `bank_card_bin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `bankName` varchar(50) DEFAULT NULL COMMENT '银行名称',
  `bankNo` varchar(20) DEFAULT NULL COMMENT '银行编码',
  `insituNo` int(11) DEFAULT NULL COMMENT '机构号',
  `cardName` varchar(30) DEFAULT NULL COMMENT '卡名',
  `cardLen` int(10) DEFAULT NULL COMMENT '卡号长度',
  `cardBin` varchar(20) DEFAULT NULL COMMENT '卡bin',
  `cardSpecies` varchar(30) DEFAULT NULL COMMENT '卡种',
  `cardSpeciesType` enum('1','2','3','4') DEFAULT NULL COMMENT '卡种 1借记卡 2准贷记卡 3贷记卡 4预付费卡',
  PRIMARY KEY (`id`),
  KEY `bankName` (`bankName`),
  KEY `cardBin` (`cardBin`)
) ENGINE=InnoDB AUTO_INCREMENT=16519 DEFAULT CHARSET=utf8 COMMENT='银行信息';

/*Table structure for table `buried_logs` */

DROP TABLE IF EXISTS `buried_logs`;

CREATE TABLE `buried_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `source` varchar(20) DEFAULT NULL COMMENT '渠道号',
  `userId` int(11) DEFAULT '0' COMMENT '用户id',
  `buriedType` varchar(50) DEFAULT NULL COMMENT '埋点类别',
  `buriedName` varchar(100) DEFAULT NULL COMMENT '埋点名称',
  `mobileType` varchar(10) DEFAULT NULL COMMENT '类型 IOS ANDROID H5 QT',
  `deviceCode` varchar(50) DEFAULT NULL COMMENT '设备唯一标识',
  `mobileBrand` varchar(50) DEFAULT NULL COMMENT '手机品牌型号 例iphone5s',
  `addTime` int(11) DEFAULT '0' COMMENT '记录时间',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `source` (`source`),
  KEY `deviceCode` (`deviceCode`)
) ENGINE=InnoDB AUTO_INCREMENT=6855 DEFAULT CHARSET=utf8 COMMENT='埋点信息管理';

/*Table structure for table `channel_info` */

DROP TABLE IF EXISTS `channel_info`;

CREATE TABLE `channel_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '渠道名称',
  `channelNo` varchar(30) DEFAULT NULL COMMENT '渠道号',
  `promoteUrl` varchar(512) DEFAULT '' COMMENT '推广链接',
  `operation` varchar(128) NOT NULL COMMENT '运营人员',
  `loginAccount` varchar(128) NOT NULL COMMENT '登录账号',
  `loginPassword` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `adminId` int(11) NOT NULL COMMENT '当前操作人',
  `stat` enum('ON','OFF') NOT NULL COMMENT '状态 ON上架 OFF下架',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `channelNo` (`channelNo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='渠道商信息';

/*Table structure for table `dictionary_data` */

DROP TABLE IF EXISTS `dictionary_data`;

CREATE TABLE `dictionary_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `typeCode` varchar(20) NOT NULL COMMENT '类型编码',
  `code` varchar(20) NOT NULL COMMENT '字典数据码',
  `text` varchar(255) NOT NULL COMMENT '字典数据内容',
  `sort` int(3) NOT NULL COMMENT '排序',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='字典数据';

/*Table structure for table `dictionary_info` */

DROP TABLE IF EXISTS `dictionary_info`;

CREATE TABLE `dictionary_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `typeCode` varchar(20) NOT NULL COMMENT '类型编码',
  `typeName` varchar(64) NOT NULL COMMENT '类型名',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `typeCode` (`typeCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='字典信息';

/*Table structure for table `loan_audit_log` */

DROP TABLE IF EXISTS `loan_audit_log`;

CREATE TABLE `loan_audit_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `cardId` int(11) NOT NULL COMMENT '银行卡标识',
  `orderNo` varchar(30) NOT NULL COMMENT '订单号',
  `adminId` int(11) DEFAULT '0' COMMENT '审批人',
  `auditStat` enum('AUTO_REFUSE','AUTO_PASS','MANUAL_REFUSE','MANUAL_PASS','AUDIT_PASS','AUDITING','QT') NOT NULL COMMENT '审批状态 AUTO_REFUSE机审拒绝 AUTO_PASS机审通过 MANUAL_REFUSE 人审拒绝 MANUAL_PASS人审通过 AUDIT_PASS审核通过 AUDITING审核中 QT其他',
  `remark` varchar(1024) DEFAULT '' COMMENT '备注',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `order` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单审核信息';

/*Table structure for table `loan_collection_log` */

DROP TABLE IF EXISTS `loan_collection_log`;

CREATE TABLE `loan_collection_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(30) NOT NULL COMMENT '订单号',
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `cardId` int(11) NOT NULL COMMENT '银行卡标识',
  `adminId` int(11) DEFAULT '0' COMMENT '当前催收人',
  `stat` enum('DOING','WOULD_PAY','SUCCESS','BED_DEBT') NOT NULL COMMENT '催收状态 DOING催收中 WOULD_PAY承诺还款 SUCCESS催收成功 BED_DEBT坏账',
  `collectionWay` enum('CALL','SMS','QT') NOT NULL COMMENT '催收方式 CALL电话 SMS短信 QT其他',
  `remark` varchar(1024) DEFAULT '' COMMENT '备注',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `order` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='催收记录信息';

/*Table structure for table `loan_limit_config` */

DROP TABLE IF EXISTS `loan_limit_config`;

CREATE TABLE `loan_limit_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `creditLimit` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '信用额度',
  `priority` int(11) DEFAULT '0' COMMENT '优先级',
  `stat` enum('N','C') DEFAULT 'N' COMMENT '状态 N启用 C关闭',
  `firstLoan` enum('Y','N') DEFAULT 'Y' COMMENT '是否首借 Y是 N不是',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='全局借款额度表';

/*Table structure for table `loan_order_log` */

DROP TABLE IF EXISTS `loan_order_log`;

CREATE TABLE `loan_order_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `cardId` int(11) NOT NULL COMMENT '银行卡标识',
  `orderNo` varchar(30) DEFAULT NULL COMMENT '订单号',
  `amount` decimal(10,2) NOT NULL COMMENT '申请金额',
  `loanTerm` int(11) NOT NULL COMMENT '借款期限',
  `shouldRepayTime` int(11) DEFAULT '0' COMMENT '应还款时间',
  `settleRepayTime` int(11) DEFAULT '0' COMMENT '结清还款时间',
  `loanFee` decimal(10,2) NOT NULL COMMENT '借款服务费',
  `interest` decimal(10,2) NOT NULL COMMENT '借款利息',
  `ovdFee` decimal(10,2) DEFAULT '0.00' COMMENT '逾期费用',
  `shouldRepayAmount` decimal(10,2) NOT NULL COMMENT '应还金额',
  `actualRepayAmount` decimal(10,2) NOT NULL COMMENT '实际还款金额',
  `auditAdminId` int(11) DEFAULT '0' COMMENT '当前审批人',
  `approvalStatus` enum('MR','MP','MRP') DEFAULT 'MR' COMMENT '审核类型 MR机审 MP人审 MRP机审+人审',
  `stat` enum('APPROVE','TO_PAY','PAYED','PART_REPAY','REPAYED','OVERDUE','PAY_FAILED','BAD_DEBT','REPAY_FAILED','AUDIT_REFUSE','REPAYING') NOT NULL DEFAULT 'APPROVE' COMMENT '订单状态 APPROVE审核中 TO_PAY放款中 PAYED已放款 PART_REPAY部分还款 REPAYED 已还款 REPAY_FAILED还款失败 OVERDUE逾期 PAY_FAILED放款失败 BAD_DEBT坏账 AUDIT_REFUSE审核失败 REPAYING还款中',
  `auditStat` enum('AUTO_REFUSE','AUTO_PASS','MANUAL_REFUSE','MANUAL_PASS','AUDIT_PASS','AUDITING','QT') NOT NULL DEFAULT 'AUDITING' COMMENT '审批状态 AUTO_REFUSE机审拒绝 AUTO_PASS机审通过 MANUAL_REFUSE 人审拒绝 MANUAL_PASS人审通过 AUDIT_PASS审核通过 AUDITING审核中 QT其他',
  `payStat` enum('PAYED','NOTPAY') NOT NULL DEFAULT 'PAYED' COMMENT '支付状态 PAYED已支付 NOTPAY未支付',
  `refuseRemark` varchar(500) DEFAULT NULL COMMENT '风控拒绝理由',
  `repayType` enum('LINE','MANU','QTHE','FINA') DEFAULT 'LINE' COMMENT '还款方式 LINE线上自主还款 MANU线下还款 OTHE其他还款凡是 FINA财务代扣',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`),
  KEY `audit` (`auditAdminId`),
  KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='订单信息';

/*Table structure for table `loan_overdue_log` */

DROP TABLE IF EXISTS `loan_overdue_log`;

CREATE TABLE `loan_overdue_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(30) NOT NULL COMMENT '订单号',
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `cardId` int(11) NOT NULL COMMENT '银行卡标识',
  `shouldRepayTime` int(11) DEFAULT '0' COMMENT '应还款时间',
  `collectionAdminId` int(11) DEFAULT '0' COMMENT '当前催收人',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `order` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='逾期订单信息';

/*Table structure for table `loan_pay_log` */

DROP TABLE IF EXISTS `loan_pay_log`;

CREATE TABLE `loan_pay_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `payOrderNo` varchar(50) DEFAULT NULL COMMENT '支付订单号',
  `userOrderNo` varchar(30) DEFAULT NULL COMMENT '流水单号',
  `orderNo` varchar(30) NOT NULL COMMENT '订单号',
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `cardId` int(11) NOT NULL COMMENT '银行卡标识',
  `amount` decimal(10,2) NOT NULL COMMENT '支付金额',
  `stat` enum('PAYED','NOT_PAY') NOT NULL DEFAULT 'NOT_PAY' COMMENT '支付状态 PAYED已支付 NOT_PAY未支付',
  `payWay` enum('REMITTANCE','REPAY','WITHHOLD','OVDREPAY') NOT NULL DEFAULT 'REMITTANCE' COMMENT '支付类型 REMITTANCE打款 REPAY还款 WITHHOLD代扣 OVDREPAY催收代扣',
  `payTime` int(11) DEFAULT '0' COMMENT '支付时间',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  `logString` text COMMENT '支付返回结果',
  PRIMARY KEY (`id`),
  KEY `order` (`orderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='支付订单信息';

/*Table structure for table `loan_repay_log` */

DROP TABLE IF EXISTS `loan_repay_log`;

CREATE TABLE `loan_repay_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `repayOrderNo` varchar(30) DEFAULT NULL COMMENT '还款订单号',
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `cardId` int(11) NOT NULL COMMENT '银行卡标识',
  `orderNo` varchar(30) NOT NULL COMMENT '订单号',
  `adminId` int(11) DEFAULT '0' COMMENT '当前操作人',
  `shouldRepayAmount` decimal(10,2) NOT NULL COMMENT '应还金额',
  `actualRepayAmount` decimal(10,2) NOT NULL COMMENT '实际还款金额',
  `stat` enum('REPAYING','NOT_REPAY','REPAYED','PART_REPAY','REPAY_FAILED') NOT NULL DEFAULT 'REPAYING' COMMENT '还款状态 REPAYING还款中 NOT_REPAY未还款 REPAYED已还款 PART_REPAY部分还款 REPAY_FAILED还款失败',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `order` (`orderNo`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='还款订单信息';

/*Table structure for table `loan_repay_oper_log` */

DROP TABLE IF EXISTS `loan_repay_oper_log`;

CREATE TABLE `loan_repay_oper_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `repayOrderNo` varchar(30) NOT NULL COMMENT '还款订单号',
  `adminId` int(11) DEFAULT '0' COMMENT '操作人',
  `remark` varchar(1024) DEFAULT '' COMMENT '备注',
  `repayAmount` decimal(10,2) NOT NULL COMMENT '还款金额',
  `repayWay` enum('ACTIVE','WITHHOLD','QT') NOT NULL COMMENT '还款方式 ACTIVE主动 WITHHOLD代扣 QT其他',
  `bankSerialNumber` varchar(255) DEFAULT '' COMMENT '银行流水号',
  `voucher` varchar(255) DEFAULT '' COMMENT '打款凭证',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `repay` (`repayOrderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='还款订单操作信息';

/*Table structure for table `logs` */

DROP TABLE IF EXISTS `logs`;

CREATE TABLE `logs` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=1417 DEFAULT CHARSET=utf8 COMMENT='日志管理';

/*Table structure for table `logs_api` */

DROP TABLE IF EXISTS `logs_api`;

CREATE TABLE `logs_api` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=35730 DEFAULT CHARSET=utf8 COMMENT='接口请求日志';

/*Table structure for table `logs_jgpush` */

DROP TABLE IF EXISTS `logs_jgpush`;

CREATE TABLE `logs_jgpush` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='极光推送日志';

/*Table structure for table `logs_opera` */

DROP TABLE IF EXISTS `logs_opera`;

CREATE TABLE `logs_opera` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=259 DEFAULT CHARSET=utf8 COMMENT='运营商日志';

/*Table structure for table `logs_risk` */

DROP TABLE IF EXISTS `logs_risk`;

CREATE TABLE `logs_risk` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='风控审核日志';

/*Table structure for table `logs_send_msg` */

DROP TABLE IF EXISTS `logs_send_msg`;

CREATE TABLE `logs_send_msg` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COMMENT='短信发送/极光推送日志';

/*Table structure for table `logs_task` */

DROP TABLE IF EXISTS `logs_task`;

CREATE TABLE `logs_task` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COMMENT='跑批任务日志';

/*Table structure for table `logs_user_certification` */

DROP TABLE IF EXISTS `logs_user_certification`;

CREATE TABLE `logs_user_certification` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=1116 DEFAULT CHARSET=utf8 COMMENT='用户OCR/实名/活体日志';

/*Table structure for table `logs_user_cjpay` */

DROP TABLE IF EXISTS `logs_user_cjpay`;

CREATE TABLE `logs_user_cjpay` (
  `logid` int(10) NOT NULL AUTO_INCREMENT,
  `logDate` varchar(100) NOT NULL,
  `logTime` varchar(100) NOT NULL,
  `logIp` varchar(100) NOT NULL,
  `logString` longtext NOT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=379 DEFAULT CHARSET=utf8 COMMENT='支付通道日志';

/*Table structure for table `manage_admin_logs` */

DROP TABLE IF EXISTS `manage_admin_logs`;

CREATE TABLE `manage_admin_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `adminId` int(11) DEFAULT '0' COMMENT '操作人id',
  `adminName` varchar(30) DEFAULT NULL COMMENT '管理员名称',
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `content` longtext COMMENT '操作内容',
  `adminUrl` varchar(50) DEFAULT NULL COMMENT '操作地址',
  `adminIp` varchar(30) DEFAULT NULL COMMENT '操作人ip',
  `addDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`),
  KEY `adminId` (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台管理员操作日志';

/*Table structure for table `manage_department` */

DROP TABLE IF EXISTS `manage_department`;

CREATE TABLE `manage_department` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `departName` varchar(30) DEFAULT NULL COMMENT '部门名称',
  `departLevel` int(11) DEFAULT '0' COMMENT '部门等级',
  `departParentId` int(11) DEFAULT '0' COMMENT '父级id',
  `departSort` int(11) DEFAULT '0' COMMENT '排序 顺序排序',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `departLevel` (`departLevel`),
  KEY `departParentId` (`departParentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*Table structure for table `manage_group` */

DROP TABLE IF EXISTS `manage_group`;

CREATE TABLE `manage_group` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `departId` int(11) DEFAULT '0' COMMENT '部门id',
  `groupName` varchar(30) DEFAULT NULL COMMENT '权限分组名称',
  `authIds` varchar(255) DEFAULT NULL COMMENT '权限id',
  `idDefault` int(1) DEFAULT '0' COMMENT '是否默认 1是 0否',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `groupName` (`groupName`),
  KEY `departId` (`departId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='权限分组管理';

/*Table structure for table `manage_menu` */

DROP TABLE IF EXISTS `manage_menu`;

CREATE TABLE `manage_menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menuLevel` int(11) DEFAULT '1' COMMENT '菜单等级',
  `menuSort` int(11) DEFAULT '0' COMMENT '菜单排序',
  `menuParentId` int(11) DEFAULT '0' COMMENT '父级id',
  `menuIsShow` tinyint(1) DEFAULT '1' COMMENT '是否显示 1是 0否',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `menuLevel` (`menuLevel`),
  KEY `menuParentId` (`menuParentId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Table structure for table `manage_menu_power` */

DROP TABLE IF EXISTS `manage_menu_power`;

CREATE TABLE `manage_menu_power` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `menuId` int(11) DEFAULT '0' COMMENT '菜单id',
  `actionPath` varchar(100) DEFAULT NULL COMMENT '请求地址',
  `adtionMethod` varchar(10) DEFAULT NULL COMMENT '请求类型 GET POST INPUT',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `menuId` (`menuId`),
  KEY `actionPath` (`actionPath`),
  KEY `adtionMethod` (`adtionMethod`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='菜单地址管理';

/*Table structure for table `manage_user` */

DROP TABLE IF EXISTS `manage_user`;

CREATE TABLE `manage_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) DEFAULT NULL COMMENT '用户名',
  `mobile` bigint(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `pwdSalt` varchar(30) DEFAULT NULL COMMENT '密码加密随机串',
  `userStatus` enum('NOR','DEL','HAN','QT') DEFAULT 'NOR' COMMENT '用户状态 NOR正常 DEL删除 HAN挂起 QT其他',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `mobile` (`mobile`,`email`),
  KEY `userStatus` (`userStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员用户管理';

/*Table structure for table `manage_user_group` */

DROP TABLE IF EXISTS `manage_user_group`;

CREATE TABLE `manage_user_group` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT '0' COMMENT '管理员id',
  `groupId` int(11) DEFAULT '0' COMMENT '分组id',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `groupId` (`groupId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户分组管理';

/*Table structure for table `risk_config` */

DROP TABLE IF EXISTS `risk_config`;

CREATE TABLE `risk_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `configKey` varchar(64) NOT NULL COMMENT '配置项名',
  `configValue` text NOT NULL COMMENT '配置项值',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='风控参数配置';

/*Table structure for table `risk_control_rule` */

DROP TABLE IF EXISTS `risk_control_rule`;

CREATE TABLE `risk_control_rule` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ruleType` varchar(12) NOT NULL COMMENT '规则类别:CERT身份/LOCATION位置/MOBILE手机/CARRIER运营商/DEVICE设备/REPORT风控报告',
  `ruleImpl` varchar(255) NOT NULL COMMENT '规则实现',
  `ruleName` varchar(50) NOT NULL COMMENT '规则名称',
  `ruleDesc` varchar(255) NOT NULL COMMENT '规则描述',
  `param1` varchar(20) DEFAULT '' COMMENT '参数1',
  `param2` varchar(20) DEFAULT '' COMMENT '参数2',
  `sort` int(3) NOT NULL COMMENT '排序',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='风控规则';

/*Table structure for table `risk_score_config` */

DROP TABLE IF EXISTS `risk_score_config`;

CREATE TABLE `risk_score_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `varName` varchar(40) NOT NULL COMMENT '变量名',
  `ruleType` varchar(12) NOT NULL COMMENT '规则类别:CARRIER运营商 REPORT风控报告',
  `config` varchar(400) NOT NULL COMMENT '配置json:各分箱和对应的分数',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='风控评分配置';

/*Table structure for table `risk_user_carrier_score` */

DROP TABLE IF EXISTS `risk_user_carrier_score`;

CREATE TABLE `risk_user_carrier_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `orderId` varchar(30) NOT NULL COMMENT '订单号',
  `jxlRegDays` varchar(20) NOT NULL COMMENT '手机注册距今天数',
  `discreteSmsCnt5m` varchar(20) NOT NULL COMMENT '最近5个月短信数目变异系数',
  `discreteCallInCnt5m` varchar(20) NOT NULL COMMENT '最近5个月被叫次数变异系数',
  `varianceCallOutInCnt5m` varchar(20) NOT NULL COMMENT '最近5个月(主叫次数/被叫次数)方差',
  `discreteCallOutInCnt5m` varchar(20) NOT NULL COMMENT '最近5个月(主叫次数/被叫次数)变异系数',
  `contactNight` varchar(20) NOT NULL COMMENT '夜间活动情况',
  `regions` varchar(20) NOT NULL COMMENT '通话地区总数',
  `searchedOrgCnt` varchar(20) NOT NULL COMMENT '查询过该用户的相关企业数量',
  `intercept` decimal(10,4) NOT NULL COMMENT '截距',
  `score` decimal(10,4) NOT NULL COMMENT '总分',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_order` (`userId`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='风控用户运营商评分';

/*Table structure for table `risk_user_handle_log` */

DROP TABLE IF EXISTS `risk_user_handle_log`;

CREATE TABLE `risk_user_handle_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `orderId` varchar(30) NOT NULL COMMENT '订单号',
  `resultStat` varchar(12) NOT NULL COMMENT '结果状态:PASS通过 REJECT拒绝',
  `rejectRuleId` int(11) DEFAULT '0' COMMENT '拒绝规则id',
  `reason` varchar(255) DEFAULT '' COMMENT '拒绝原因',
  `rejectParam` varchar(128) DEFAULT '' COMMENT '拒绝参数',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_order` (`userId`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=211 DEFAULT CHARSET=utf8 COMMENT='风控用户处理日志';

/*Table structure for table `risk_user_score` */

DROP TABLE IF EXISTS `risk_user_score`;

CREATE TABLE `risk_user_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `orderId` varchar(30) NOT NULL COMMENT '订单号',
  `authIndirectPeernumRatio180d` varchar(12) NOT NULL COMMENT '近180天引起间接联系人授权的直接联系人数占比',
  `authIntimateIndirectnum180d` varchar(12) NOT NULL COMMENT '近180天授权过的亲密间接联系人个数',
  `authIndirectPeernumRatio30d` varchar(12) NOT NULL COMMENT '近30天引起间接联系人授权的直接联系人数占比',
  `authIndirectnumRatio90d` varchar(12) NOT NULL COMMENT '近90天授权过的间接联系人个数占比',
  `authIndirectnumRatio180d` varchar(12) NOT NULL COMMENT '近180天授权过的间接联系人个数占比',
  `cashLoan15d` varchar(12) NOT NULL COMMENT '近15天贷款的次数',
  `blackContactnumRatio180d` varchar(12) NOT NULL COMMENT '近180天命中黑名单的直接联系人个数占比',
  `age` varchar(12) NOT NULL COMMENT '年龄',
  `loanOrgCntAll` varchar(12) NOT NULL COMMENT '借贷机构数（去重）',
  `contactnum30d` varchar(12) NOT NULL COMMENT '近30天直接联系人个数',
  `score` int(5) NOT NULL COMMENT '总分',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_order` (`userId`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='风控用户评分';

/*Table structure for table `risk_user_tpos_data` */

DROP TABLE IF EXISTS `risk_user_tpos_data`;

CREATE TABLE `risk_user_tpos_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `orderId` varchar(30) NOT NULL COMMENT '订单号',
  `ruleType` varchar(12) NOT NULL COMMENT '规则类别:CARRIER运营商 REPORT风控报告 CREDIT资信报告',
  `source` varchar(12) NOT NULL COMMENT 'MOXIE魔蝎',
  `jsonData` mediumtext COMMENT 'Json数据',
  `filePath` mediumtext COMMENT '文件路径json数据',
  `otherToken` text COMMENT '其他token信息',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_order` (`userId`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='风控用户第三方数据';

/*Table structure for table `scheduler_info` */

DROP TABLE IF EXISTS `scheduler_info`;

CREATE TABLE `scheduler_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `taskName` varchar(64) NOT NULL COMMENT '任务名称',
  `taskCronExp` varchar(128) NOT NULL COMMENT 'cron表达式',
  `apiUrl` varchar(256) NOT NULL COMMENT 'api访问地址',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='调度任务信息';

/*Table structure for table `sendmsg_config` */

DROP TABLE IF EXISTS `sendmsg_config`;

CREATE TABLE `sendmsg_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sendType` varchar(30) DEFAULT NULL COMMENT '发送类型 ',
  `sendTypeName` varchar(50) DEFAULT NULL COMMENT '发送类型名称',
  `sendContent` varchar(500) DEFAULT NULL COMMENT '发送内容',
  `sendCost` decimal(11,2) DEFAULT '0.00' COMMENT '成本单价',
  PRIMARY KEY (`id`),
  KEY `sendType` (`sendType`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='发送短信/app通知配置信息';

/*Table structure for table `sms_send_log` */

DROP TABLE IF EXISTS `sms_send_log`;

CREATE TABLE `sms_send_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` bigint(20) NOT NULL COMMENT '手机号码',
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `type` varchar(10) NOT NULL COMMENT '类型 注册，通知等 R注册 F忘记密码',
  `content` varchar(512) NOT NULL COMMENT '内容',
  `cost` decimal(11,2) NOT NULL COMMENT '成本',
  `stat` enum('SUCCESS','FAILED') NOT NULL COMMENT '状态 SUCCESS发送成功 FAILED发送失败',
  `supplier` varchar(32) NOT NULL COMMENT '渠道名称',
  `logString` text COMMENT '返回结果集',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='短信记录';

/*Table structure for table `user_address_book` */

DROP TABLE IF EXISTS `user_address_book`;

CREATE TABLE `user_address_book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT '0' COMMENT '用户id',
  `appType` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT 'app标识',
  `deviceCode` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备唯一标识',
  `addressBook` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '通讯录数据 json格式',
  `batchNo` int(11) DEFAULT '1' COMMENT '批次号',
  `addressType` enum('OLD','NEW') CHARACTER SET utf8 DEFAULT 'OLD' COMMENT '类型 OLD历史记录 NEW最新数据',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `deviceCode` (`deviceCode`),
  KEY `appType` (`appType`),
  KEY `addressType` (`addressType`)
) ENGINE=InnoDB AUTO_INCREMENT=676 DEFAULT CHARSET=utf8mb4 COMMENT='用户通讯录信息管理';

/*Table structure for table `user_base_info` */

DROP TABLE IF EXISTS `user_base_info`;

CREATE TABLE `user_base_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` bigint(20) NOT NULL COMMENT '手机号码',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `pwdSalt` varchar(30) DEFAULT NULL COMMENT '密码加密随机串',
  `nickName` varchar(255) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT '' COMMENT '头像',
  `channelId` varchar(20) NOT NULL COMMENT '渠道',
  `userType` enum('NEW','OLD') DEFAULT 'NEW' COMMENT '新客老客 NEW新客 OLD老客',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`),
  KEY `channel` (`channelId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户基本信息';

/*Table structure for table `user_blacklist` */

DROP TABLE IF EXISTS `user_blacklist`;

CREATE TABLE `user_blacklist` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户标识',
  `orderNo` varchar(30) DEFAULT '0' COMMENT '申请中订单号',
  `addAdminId` int(11) DEFAULT '0' COMMENT '添加管理员标识',
  `stat` enum('NOR','DEL') DEFAULT 'NOR' COMMENT '状态 NOR正常 DEL移除',
  `removeAdminId` int(11) DEFAULT '0' COMMENT '移除管理员标识',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户黑名单';

/*Table structure for table `user_blacklist_remark` */

DROP TABLE IF EXISTS `user_blacklist_remark`;

CREATE TABLE `user_blacklist_remark` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(20) NOT NULL COMMENT '用户标识',
  `blacklistId` int(11) NOT NULL COMMENT '黑名单标识',
  `operate` enum('ADD','DEL') NOT NULL COMMENT '类型 ADD添加 DEL移除',
  `remark` varchar(1024) DEFAULT '' COMMENT '备注',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `blacklist` (`blacklistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户黑名单备注信息';

/*Table structure for table `user_card_info` */

DROP TABLE IF EXISTS `user_card_info`;

CREATE TABLE `user_card_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(20) DEFAULT NULL COMMENT 'app标识',
  `bankName` varchar(128) DEFAULT NULL COMMENT '银行名称',
  `cardType` enum('DC','CC','QT') DEFAULT 'DC' COMMENT '卡类型 DC借记卡 CC贷记卡 QT其他',
  `bankShortName` varchar(128) DEFAULT NULL COMMENT '银行简称',
  `cardBin` varchar(16) DEFAULT NULL COMMENT '卡bin',
  `cardNo` varchar(1000) DEFAULT NULL COMMENT '银行卡号',
  `isDefault` enum('Y','N') DEFAULT 'Y' COMMENT '是否默认卡 Y默认卡 N不是默认卡 一个用户只能有一张默认卡',
  `bankMobile` varchar(20) DEFAULT NULL COMMENT '银行预留手机号',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`),
  KEY `appType` (`appType`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='用户银行卡信息';

/*Table structure for table `user_config` */

DROP TABLE IF EXISTS `user_config`;

CREATE TABLE `user_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `configName` varchar(30) DEFAULT NULL COMMENT '配置名称',
  `configType` enum('EDU','AMR','CAR','COT','COTT') DEFAULT NULL COMMENT '类型 EDU学历 AMR婚姻 CAR职业 COT紧急联系人类型 COTT紧急联系人类型',
  `parentId` int(11) DEFAULT '0' COMMENT '父级id',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`),
  KEY `configType` (`configType`),
  KEY `configName` (`configName`)
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='基本信息配置';

/*Table structure for table `user_device_info` */

DROP TABLE IF EXISTS `user_device_info`;

CREATE TABLE `user_device_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(20) DEFAULT '' COMMENT 'app标识',
  `deviceType` enum('IOS','ANDROID','H5','UNKNOWN') DEFAULT 'UNKNOWN' COMMENT '设备类型 IOS苹果 ANDROID安卓 H5HTML5页面 UNKNOWN未知',
  `deviceNo` varchar(255) DEFAULT NULL COMMENT '设备号',
  `phoneType` varchar(127) DEFAULT '' COMMENT '手机类型，华为小米等',
  `userAgent` text COMMENT '手机信息',
  `systemType` varchar(255) DEFAULT NULL COMMENT '手机系统该信息 phone5 android4.0',
  `phoneStorage` decimal(11,2) DEFAULT '0.00' COMMENT '手机内存信息 单位G',
  `phoneDisk` decimal(11,2) DEFAULT '0.00' COMMENT '手机磁盘信息 单位G',
  `ip` varchar(24) DEFAULT '' COMMENT 'ip',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`),
  KEY `appType` (`appType`),
  KEY `deviceType` (`deviceType`),
  KEY `phoneType` (`phoneType`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='用户设备信息';

/*Table structure for table `user_emergency_contract` */

DROP TABLE IF EXISTS `user_emergency_contract`;

CREATE TABLE `user_emergency_contract` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(20) DEFAULT NULL COMMENT 'app标识',
  `contractType` varchar(50) DEFAULT NULL COMMENT '紧急联系人类型 PARENT父母 PARTNER配偶 SIBLING兄弟姐妹',
  `contractName` varchar(24) DEFAULT NULL COMMENT '紧急联系人姓名',
  `contractPhone` varchar(32) DEFAULT NULL COMMENT '紧急联系人电话',
  `contactStatus` enum('OLD','NEW') DEFAULT 'NEW' COMMENT '状态 OLD老数据 NEW更新数据',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='用户联系人信息';

/*Table structure for table `user_feedback` */

DROP TABLE IF EXISTS `user_feedback`;

CREATE TABLE `user_feedback` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `memo` text NOT NULL COMMENT '反馈内容',
  `createTime` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `intefaceType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户反馈表';

/*Table structure for table `user_jgpush_message` */

DROP TABLE IF EXISTS `user_jgpush_message`;

CREATE TABLE `user_jgpush_message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `source` varchar(255) DEFAULT NULL COMMENT '渠道',
  `userId` int(11) DEFAULT '0' COMMENT '用户id',
  `orderNo` varchar(50) DEFAULT NULL COMMENT '订单号',
  `pushTitle` varchar(255) DEFAULT NULL COMMENT '标题',
  `pushContent` text COMMENT '推送内容',
  `pushUrl` varchar(500) DEFAULT NULL COMMENT '推送连接',
  `pushType` varchar(50) DEFAULT NULL COMMENT '推送类型',
  `staffId` int(11) DEFAULT '0' COMMENT '操作人id',
  `staffName` varchar(30) DEFAULT NULL COMMENT '操作人姓名',
  `pushTime` int(11) DEFAULT '0' COMMENT '推送时间',
  `isSend` tinyint(1) DEFAULT '2' COMMENT '推送状态 1已推送 2未推送',
  `isRead` tinyint(1) DEFAULT '2' COMMENT '是否已读 1是 2否',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `source` (`source`),
  KEY `userId` (`userId`),
  KEY `pushType` (`pushType`),
  KEY `staffId` (`staffId`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='极光推送信息管理';

/*Table structure for table `user_life_info` */

DROP TABLE IF EXISTS `user_life_info`;

CREATE TABLE `user_life_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(20) DEFAULT NULL COMMENT 'APP标识',
  `education` varchar(16) DEFAULT NULL COMMENT '学历 初中，高中，大专，本科，研究生，博士，其他',
  `province` varchar(16) DEFAULT NULL COMMENT '省',
  `city` varchar(16) DEFAULT NULL COMMENT '市',
  `area` varchar(16) DEFAULT NULL COMMENT '区',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `companyProvince` varchar(16) DEFAULT NULL COMMENT '公司地址-省',
  `companyCity` varchar(16) DEFAULT NULL COMMENT '公司地址-市',
  `companyArea` varchar(16) DEFAULT NULL COMMENT '公司地址-区',
  `companyAddress` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `company` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `companyPhone` varchar(64) DEFAULT NULL COMMENT '单位电话',
  `marriage` varchar(16) DEFAULT NULL COMMENT '婚姻状态 已婚，未婚，未知',
  `career` varchar(64) DEFAULT NULL COMMENT '职业 私营企业，民营/乡镇企业 上市公司 机关/事业单位 国有企业 三资企业',
  `jobTitle` varchar(255) DEFAULT NULL COMMENT '岗位',
  `incomeMonthlyYuan` int(11) DEFAULT '0' COMMENT '月收入(元)',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`userId`),
  KEY `appType` (`appType`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户基本生活信息';

/*Table structure for table `user_loan_config` */

DROP TABLE IF EXISTS `user_loan_config`;

CREATE TABLE `user_loan_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `creditLimit` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '信用额度',
  `loanTerm` int(11) DEFAULT '0' COMMENT '借款期限',
  `feeRate` varchar(127) DEFAULT NULL COMMENT '借款费用比例',
  `dailyRate` varchar(127) DEFAULT '' COMMENT '借款日利率',
  `delayRate` varchar(127) NOT NULL COMMENT '借款罚息率',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户借款配置';

/*Table structure for table `user_location_info` */

DROP TABLE IF EXISTS `user_location_info`;

CREATE TABLE `user_location_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(20) DEFAULT NULL COMMENT 'app类型',
  `longitude` varchar(32) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) DEFAULT NULL COMMENT '纬度',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `logString` mediumtext COMMENT '详情结果',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`),
  KEY `appType` (`appType`)
) ENGINE=InnoDB AUTO_INCREMENT=943 DEFAULT CHARSET=utf8 COMMENT='用户定位信息';

/*Table structure for table `user_login_log` */

DROP TABLE IF EXISTS `user_login_log`;

CREATE TABLE `user_login_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT '0' COMMENT '用户id',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `appType` varchar(20) DEFAULT NULL COMMENT 'app标识',
  `deviceType` enum('IOS','ANDROID','H5','UNKNOWN') DEFAULT NULL COMMENT '设备类型 设备类型 IOS苹果 ANDROID安卓 H5HTML5页面 UNKNOWN未知',
  `deviceNo` varchar(50) DEFAULT NULL COMMENT '设备号',
  `logTime` int(11) DEFAULT '0' COMMENT '登陆时间',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`,`mobile`),
  KEY `appType` (`appType`),
  KEY `deviceType` (`deviceType`),
  KEY `deviceNo` (`deviceNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1204 DEFAULT CHARSET=utf8 COMMENT='用户登录日志信息管理';

/*Table structure for table `user_real_name` */

DROP TABLE IF EXISTS `user_real_name`;

CREATE TABLE `user_real_name` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(10) DEFAULT NULL COMMENT 'app类型',
  `realName` varchar(1000) DEFAULT NULL COMMENT '真实姓名',
  `certNo` varchar(1000) DEFAULT NULL COMMENT '身份证号',
  `certPositive` varchar(255) DEFAULT NULL COMMENT '身份证正面照片',
  `certOpposite` varchar(255) DEFAULT NULL COMMENT '身份证反面照片',
  `certHand` varchar(255) DEFAULT NULL COMMENT '手持照片',
  `certLive` varchar(255) DEFAULT NULL COMMENT '活体照片',
  `certLiveLog` text COMMENT '活体照片集合',
  `address` varchar(100) DEFAULT NULL COMMENT 'ocr身份证地址',
  `nationlity` varchar(10) DEFAULT NULL COMMENT 'ocr民族',
  `police` varchar(100) DEFAULT NULL COMMENT '发证所在地公安局',
  `startExpireTime` bigint(20) DEFAULT '0' COMMENT '有效期开始日期',
  `endExpireTime` bigint(20) DEFAULT '0' COMMENT '有效期结束日期',
  `verifyTime` int(11) DEFAULT '0' COMMENT '认证时间',
  `ficaStatus` enum('IC','OF','LF','PA','AF') DEFAULT 'IC' COMMENT '认证状态 IC认证中 OFocr识别失败 LF活体认证失败 AF人证认证失败 PA认证通过',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`userId`),
  KEY `intefaceType` (`appType`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户实名信息';

/*Table structure for table `user_token_info` */

DROP TABLE IF EXISTS `user_token_info`;

CREATE TABLE `user_token_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '用户标识',
  `appType` varchar(20) DEFAULT '' COMMENT 'app标识',
  `deviceType` enum('IOS','ANDROID','H5','UNKNOWN') DEFAULT 'UNKNOWN' COMMENT '设备类型 IOS苹果 ANDROID安卓 H5HTML5页面 UNKNOWN未知',
  `deviceNo` varchar(255) DEFAULT NULL COMMENT '设备号',
  `token` varchar(255) DEFAULT '' COMMENT 'token',
  `realNameVerify` enum('Y','N') DEFAULT 'N' COMMENT '是否实名 Y是 N否',
  `baseInfoVerify` enum('Y','N') DEFAULT 'N' COMMENT '基本信息是否完善 Y是 N否',
  `contactVerify` enum('Y','N') DEFAULT 'N' COMMENT '紧急联系人是否完善 Y是 N否',
  `operatorVerify` enum('Y','N') DEFAULT 'N' COMMENT '是否认证运营商 Y是 N否',
  `bankCardVerify` enum('Y','N') DEFAULT 'N' COMMENT '是否绑卡 Y是 N否',
  `ip` varchar(24) DEFAULT '' COMMENT 'ip',
  `expireTime` int(11) DEFAULT '0' COMMENT '登录过期时间',
  `lastLoginTime` int(11) DEFAULT '0' COMMENT '最后登录时间',
  `addTime` int(11) DEFAULT '0' COMMENT '添加时间',
  `updateTime` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user` (`userId`),
  KEY `appType` (`appType`),
  KEY `deviceType` (`deviceType`),
  KEY `token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='用户登录信息';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

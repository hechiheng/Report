/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : report

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2017-11-18 16:10:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_about`
-- ----------------------------
DROP TABLE IF EXISTS `t_about`;
CREATE TABLE `t_about` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `content` text NOT NULL,
  `updatetime` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `userid` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_about
-- ----------------------------
INSERT INTO `t_about` VALUES ('1', '<p>联系地址：石家庄市新华区11&nbsp;</p><p>电话：15176190900</p>', '<p>欢迎光临222！</p><p><img src=\"/Report/uploads/image/20171029/1509254978596076462.jpg\" title=\"1509254978596076462.jpg\" alt=\"46c824448d32f4dfc69b0b94cc0775f9.jpg\"/></p><p>&nbsp;</p><p>公司地址：云南省昆明市北京路299<br/>&nbsp;</p><p>公司电话：0871-100000</p><p>售前咨询客服QQ-01：<br/>售前咨询客服QQ-02：<br/>客户售前咨询热线：<br/>客户售后服务热线：<br/>客服信箱：</p><p>&nbsp;</p><p>&nbsp;</p>', '1509257907', '1');

-- ----------------------------
-- Table structure for `t_access`
-- ----------------------------
DROP TABLE IF EXISTS `t_access`;
CREATE TABLE `t_access` (
  `roleid` smallint(6) unsigned NOT NULL,
  `menuid` smallint(6) unsigned NOT NULL,
  KEY `groupId` (`roleid`),
  KEY `nodeId` (`menuid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_access
-- ----------------------------
INSERT INTO `t_access` VALUES ('1', '43');
INSERT INTO `t_access` VALUES ('1', '42');
INSERT INTO `t_access` VALUES ('1', '33');
INSERT INTO `t_access` VALUES ('1', '32');
INSERT INTO `t_access` VALUES ('1', '4');
INSERT INTO `t_access` VALUES ('1', '14');
INSERT INTO `t_access` VALUES ('1', '38');
INSERT INTO `t_access` VALUES ('1', '20');
INSERT INTO `t_access` VALUES ('1', '2');
INSERT INTO `t_access` VALUES ('1', '30');
INSERT INTO `t_access` VALUES ('1', '3');
INSERT INTO `t_access` VALUES ('1', '63');
INSERT INTO `t_access` VALUES ('1', '62');
INSERT INTO `t_access` VALUES ('1', '61');
INSERT INTO `t_access` VALUES ('1', '60');
INSERT INTO `t_access` VALUES ('1', '59');
INSERT INTO `t_access` VALUES ('1', '15');
INSERT INTO `t_access` VALUES ('1', '51');
INSERT INTO `t_access` VALUES ('1', '13');
INSERT INTO `t_access` VALUES ('1', '48');
INSERT INTO `t_access` VALUES ('2', '50');
INSERT INTO `t_access` VALUES ('2', '13');
INSERT INTO `t_access` VALUES ('2', '48');
INSERT INTO `t_access` VALUES ('2', '47');
INSERT INTO `t_access` VALUES ('2', '46');
INSERT INTO `t_access` VALUES ('2', '1');
INSERT INTO `t_access` VALUES ('2', '51');
INSERT INTO `t_access` VALUES ('2', '15');
INSERT INTO `t_access` VALUES ('1', '47');
INSERT INTO `t_access` VALUES ('1', '46');
INSERT INTO `t_access` VALUES ('1', '1');

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '登录名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `factname` varchar(20) NOT NULL DEFAULT '',
  `sex` tinyint(1) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT '',
  `tel` varchar(50) DEFAULT NULL,
  `usertype` tinyint(4) NOT NULL DEFAULT '0',
  `regtime` int(10) DEFAULT NULL,
  `logintime` int(10) unsigned DEFAULT NULL COMMENT '登录时间',
  `updatetime` int(10) DEFAULT NULL,
  `isvalid` tinyint(1) DEFAULT '1',
  `islock` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '锁定状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='网站后台管理员表';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'c4ca4238a0b923820dcc509a6f75849b', '超级管理员', '1', '23232222', '333', '2322222', '9', null, '1477469251', '1509502296', '1', '0');
INSERT INTO `t_admin` VALUES ('6', 'q', '7694f4a66316e53c8cdd9d9954bd611d', 'q', '1', '', '', '', '0', '1509378359', null, null, '1', '0');
INSERT INTO `t_admin` VALUES ('3', 'bbb', '698d51a19d8a121ce581499d7b701668', 'dfd地方', '0', '23323333', '2323111111111', '232322', '0', '1509377284', null, '1509377386', '1', '0');
INSERT INTO `t_admin` VALUES ('4', 'ccc', 'c4ca4238a0b923820dcc509a6f75849b', '1', '2', '1212', '1212', '12', '0', '1509377475', null, null, '1', '0');
INSERT INTO `t_admin` VALUES ('5', 'fff', 'c4ca4238a0b923820dcc509a6f75849b', 'dfdf', '1', 'sd', 'sdf', 'sdf', '0', '1509377494', null, null, '1', '0');
INSERT INTO `t_admin` VALUES ('7', '111', 'c4ca4238a0b923820dcc509a6f75849b', '111', '1', '', '', '', '0', '1509466764', null, null, '1', '0');

-- ----------------------------
-- Table structure for `t_announce`
-- ----------------------------
DROP TABLE IF EXISTS `t_announce`;
CREATE TABLE `t_announce` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `starttime` int(10) unsigned NOT NULL DEFAULT '0',
  `endtime` int(10) unsigned NOT NULL DEFAULT '0',
  `isvalid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `publishtime` int(10) unsigned NOT NULL DEFAULT '0',
  `ispublish` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否发布',
  `updatetime` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `userid` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_announce
-- ----------------------------
INSERT INTO `t_announce` VALUES ('1', '手机版网站开通', '<p>手机版网站开通，用手机版网站开通手机访问http://demo.0871k.com 即可访问手机站</p>', '0', '1525048560', '1', '1396399014', '0', '0', '0');
INSERT INTO `t_announce` VALUES ('2', '公告xxxxx', '萨的发生地方', '1475311680', '1476521280', '1', '1476434880', '0', '1476521354', '0');
INSERT INTO `t_announce` VALUES ('3', 'DDDD水电费', '是对方的事', '1508848845', '1508948845', '1', '1476521358', '0', '1476521365', '0');
INSERT INTO `t_announce` VALUES ('4', 'asdas苏打水', '<p>啊大叔大叔大叔</p>', '1476521856', '1477904220', '0', '1476521856', '0', '1476521866', '1');
INSERT INTO `t_announce` VALUES ('5', '啊的说法是大方', '<p>啊的说法的事</p>', '1475312340', '1477904340', '1', '1475312340', '0', '1476535268', '0');
INSERT INTO `t_announce` VALUES ('6', '高富帅公司的', '撒都发大水发大水啊的说法是对方的事\r\n啊东方大厦\r\n啊大水法', '1475313660', '1477905660', '1', '1475313660', '0', '1476535245', '0');
INSERT INTO `t_announce` VALUES ('7', '得得得', '啊多少范德萨发的大师傅多撒', '1504273260', '1519825260', '1', '1509244860', '0', '1509247215', '0');
INSERT INTO `t_announce` VALUES ('11', '大师傅', '大师傅', '1506568800', '1506741600', '1', '1507778400', '0', '1509247275', '0');
INSERT INTO `t_announce` VALUES ('8', 'afasfd师傅说的分手的', '水电费水电费的事adfasdf上发生的发生大幅撒地方撒地方的萨芬三大发生的', '1475307600', '1477899600', '1', '1476517200', '0', '1476604324', '0');
INSERT INTO `t_announce` VALUES ('10', '顶顶顶顶', '是的范德萨大师傅', '1509158640', '1511491440', '1', '1509158640', '0', '1509245113', '0');
INSERT INTO `t_announce` VALUES ('12', '的撒范德萨', '大师傅多撒但是', '1506828180', '1509852180', '1', '1509247380', '1', '1509247457', '1');

-- ----------------------------
-- Table structure for `t_codelist`
-- ----------------------------
DROP TABLE IF EXISTS `t_codelist`;
CREATE TABLE `t_codelist` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code_name` varchar(20) NOT NULL,
  `code_value` int(11) NOT NULL,
  `code_type` varchar(20) NOT NULL,
  `codetype_name` varchar(20) NOT NULL,
  `pid` int(10) unsigned NOT NULL DEFAULT '0',
  `isvalid` int(1) unsigned NOT NULL DEFAULT '1',
  `sort` smallint(6) NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_codelist
-- ----------------------------
INSERT INTO `t_codelist` VALUES ('1', '图片', '1', 'flagtype', '文档属性', '0', '1', '1', '');
INSERT INTO `t_codelist` VALUES ('2', '头条', '2', 'flagtype', '文档属性', '0', '1', '2', '');
INSERT INTO `t_codelist` VALUES ('3', '推荐', '4', 'flagtype', '文档属性', '0', '1', '3', '');
INSERT INTO `t_codelist` VALUES ('4', '特荐', '8', 'flagtype', '文档属性', '0', '1', '4', '');
INSERT INTO `t_codelist` VALUES ('5', '幻灯', '16', 'flagtype', '文档属性', '0', '1', '5', '');
INSERT INTO `t_codelist` VALUES ('6', '跳转', '32', 'flagtype', '文档属性', '0', '1', '6', '');
INSERT INTO `t_codelist` VALUES ('7', '其他', '64', 'flagtype', '文档属性', '0', '1', '7', '');
INSERT INTO `t_codelist` VALUES ('11', '国产', '1', 'softtype', '软件类型', '0', '1', '1', '');
INSERT INTO `t_codelist` VALUES ('12', '中文版', '1', 'softlanguage', '软件语言', '0', '1', '1', '');
INSERT INTO `t_codelist` VALUES ('13', '英文版', '2', 'softlanguage', '软件语言', '0', '1', '2', '');
INSERT INTO `t_codelist` VALUES ('14', '多语言版', '3', 'softlanguage', '软件语言', '0', '1', '3', '');
INSERT INTO `t_codelist` VALUES ('15', 'WinXP', '1', 'ostype', '操作系统类型', '0', '1', '1', '');
INSERT INTO `t_codelist` VALUES ('16', 'Win7', '2', 'ostype', '操作系统类型', '0', '1', '2', '');
INSERT INTO `t_codelist` VALUES ('17', 'Win8', '4', 'ostype', '操作系统类型', '0', '1', '3', '');
INSERT INTO `t_codelist` VALUES ('18', 'Win8.1', '8', 'ostype', '操作系统类型', '0', '1', '4', '');
INSERT INTO `t_codelist` VALUES ('19', 'WinVista', '16', 'ostype', '操作系统类型', '0', '1', '5', '');
INSERT INTO `t_codelist` VALUES ('20', 'Win2003', '32', 'ostype', '操作系统类型', '0', '1', '6', '');
INSERT INTO `t_codelist` VALUES ('21', 'Win2008', '64', 'ostype', '操作系统类型', '0', '1', '7', '');
INSERT INTO `t_codelist` VALUES ('22', 'Win2008R2', '128', 'ostype', '操作系统类型', '0', '1', '8', '');
INSERT INTO `t_codelist` VALUES ('23', 'Win10', '256', 'ostype', '操作系统类型', '0', '1', '9', '');
INSERT INTO `t_codelist` VALUES ('46', '图片', '1', 'filetype', '文件类型', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('47', '文件', '2', 'filetype', '文件类型', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('48', '免费版', '1', 'copytype', '软件授权', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('49', '共享版', '2', 'copytype', '软件授权', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('50', '破解版', '3', 'copytype', '软件授权', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('51', 'default', '1', 'themestyle', '主题样式', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('52', '初级会员', '1', 'grouplevel', '会员级别', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('53', '中级会员', '2', 'grouplevel', '会员级别', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('54', '高级会员', '3', 'grouplevel', '会员级别', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('55', '男', '1', 'sex', '性别', '0', '1', '0', null);
INSERT INTO `t_codelist` VALUES ('56', '女', '2', 'sex', '性别', '0', '1', '0', null);

-- ----------------------------
-- Table structure for `t_copyfrom`
-- ----------------------------
DROP TABLE IF EXISTS `t_copyfrom`;
CREATE TABLE `t_copyfrom` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sitename` varchar(30) NOT NULL DEFAULT '',
  `siteurl` varchar(200) NOT NULL DEFAULT '',
  `sort` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_copyfrom
-- ----------------------------

-- ----------------------------
-- Table structure for `t_guestbook`
-- ----------------------------
DROP TABLE IF EXISTS `t_guestbook`;
CREATE TABLE `t_guestbook` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '',
  `phone` varchar(50) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `qq` varchar(15) DEFAULT '',
  `ip` varchar(20) DEFAULT '',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `content` text NOT NULL,
  `posttime` int(10) unsigned NOT NULL DEFAULT '0',
  `reply` text,
  `replytime` int(10) unsigned DEFAULT '0',
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guestbook
-- ----------------------------
INSERT INTO `t_guestbook` VALUES ('1', '小平', '', '', '', '112.115.215.93', '手动阀的说法', '网站不错，很喜欢！！！', '1396244141', '谢谢支持！', null, '1', '0');
INSERT INTO `t_guestbook` VALUES ('2', '明明', '', '', '', '112.115.192.30', '地地道道的', '蓝色很大气，模板很好看！', '1396337906', '撒地方了吗死了都放假了受打击了', '1477187481', '1', '1');
INSERT INTO `t_guestbook` VALUES ('3', '啊东方大厦', '', '', '', '', '啊东方大厦', '啊的说法的说法', '1477216042', null, '0', '1', '0');
INSERT INTO `t_guestbook` VALUES ('4', '阿萨德发大水', '', '', '', '', '三分大赛', '水电费水电费水电费的说法', '1477216359', null, '0', '1', '0');
INSERT INTO `t_guestbook` VALUES ('5', '234', '', '', '', '127.0.0.1', '23432', '234234', '1477231732', null, '0', '1', '0');
INSERT INTO `t_guestbook` VALUES ('6', 'adfasdf', 'adsfsdaf', 'sdfds', 'sdf', '127.0.0.1', 'sdfsd', 'dsfsdfd', '1477398060', '知道了。。。。圣达菲啊第三方的萨弗蒂撒发的萨法啊说的发生打发打发的萨法\r\n啊大幅度撒发的撒富士达分撒分三大发生的\r\n啊是的方式大幅度撒发\r\n啊是的方式大幅度撒发啊大幅度撒', '1477398140', '1', '1');

-- ----------------------------
-- Table structure for `t_link`
-- ----------------------------
DROP TABLE IF EXISTS `t_link`;
CREATE TABLE `t_link` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `url` varchar(255) NOT NULL DEFAULT '',
  `logo` varchar(255) DEFAULT '',
  `description` varchar(255) DEFAULT '' COMMENT '描述',
  `updatetime` int(10) unsigned NOT NULL,
  `sort` smallint(5) NOT NULL DEFAULT '0',
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `userid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_link
-- ----------------------------
INSERT INTO `t_link` VALUES ('1', '百度', 'http://www.baidu.com', '', '', '1396255203', '1', '1', null);
INSERT INTO `t_link` VALUES ('2', '腾讯', 'http://www.qq.com', '', '', '1396255203', '1', '1', null);
INSERT INTO `t_link` VALUES ('3', '360搜索', 'http://www.so.com', '', '', '1396255203', '1', '1', null);
INSERT INTO `t_link` VALUES ('4', '阿德发生的是对方的事', 'http://222233333', '/cms/uploads/img/201609/57e92b6d531a9.png', '啊地方撒地方说阿德发生的发生', '1476668040', '1', '1', '1');
INSERT INTO `t_link` VALUES ('5', '啊大水法', 'http://', '/cms/uploads/img/201609/57e92b6d758ce.png', '啊的说法答复', '1476668229', '2', '1', '1');
INSERT INTO `t_link` VALUES ('6', 'AAAAAAA', 'http://dddddd', '/cms/uploads/img/201609/57e92b6d6c35b.png', '啊东方大厦', '1477138528', '1', '1', '1');
INSERT INTO `t_link` VALUES ('7', '的撒阿凡达33', '  22222333', '', '撒地方的萨芬', '1509288348', '3', '0', '1');
INSERT INTO `t_link` VALUES ('8', '2', '2  ', '', '', '1509287856', '0', '1', '1');
INSERT INTO `t_link` VALUES ('9', '大师傅', '  222', '', '232323', '1509288440', '4', '1', '1');

-- ----------------------------
-- Table structure for `t_matchapply`
-- ----------------------------
DROP TABLE IF EXISTS `t_matchapply`;
CREATE TABLE `t_matchapply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `annualmatch` varchar(4) NOT NULL DEFAULT '',
  `matchid` int(10) NOT NULL,
  `name` varchar(400) NOT NULL DEFAULT '',
  `unitname` varchar(400) NOT NULL DEFAULT '',
  `authors` varchar(400) NOT NULL DEFAULT '',
  `teachers` varchar(400) NOT NULL DEFAULT '',
  `description` text,
  `filepath` varchar(400) DEFAULT NULL,
  `filename` varchar(400) DEFAULT NULL,
  `filesize` int(10) DEFAULT NULL,
  `physicalpath` varchar(400) DEFAULT NULL,
  `updatetime` int(10) unsigned NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '0',
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `memberid` int(10) DEFAULT NULL,
  `checkuserid` int(10) DEFAULT NULL,
  `checktime` int(10) unsigned DEFAULT NULL,
  `orgcode` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_matchapply
-- ----------------------------
INSERT INTO `t_matchapply` VALUES ('14', '2017', '10', '是的范德萨', '士大夫', '大师傅', '撒地方的萨芬的', '<p>是的范德萨</p>', null, null, null, null, '1509845957', '3', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('15', '2017', '10', '大方的萨芬的', '似懂非懂', '是的范德萨', '是的范德萨', '<p>是的范德萨</p><p>是的范德萨</p><p>水电费水电费多少</p>', null, null, null, null, '1509848707', '0', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('16', '2017', '10', '是的范德萨', '是的范德萨', '是非得失', '撒地方的萨芬', '<p>撒地方的萨芬</p>', null, null, null, null, '1509848831', '0', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('18', '2016', '10', '是的范德萨22', '大师傅22', '是否22', '是的范德萨22', '<p>撒地方的萨芬</p><p>似懂非懂</p><p>撒地方的萨芬222</p><p>撒地方的萨芬</p><p><br/></p><p>是的范德萨范德萨</p><p>似懂非懂<img src=\"/Report/uploads/image/20171105/1509849950443032445.png\" title=\"1509849950443032445.png\" alt=\"QQ图片20171102171441.png\"/></p>', null, null, null, null, '1509857751', '0', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('19', '2016', '10', '是的范德萨22', '是的范德萨22', '第三方的22', '似懂非懂2', '<p>是的范德萨22</p><p>是的范德萨</p><p>的说法都是顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶的顶顶顶顶顶的顶顶顶顶顶的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶</p><p>大师傅大师傅<img src=\"/Report/uploads/image/20171105/1509852379630047954.png\" title=\"1509852379630047954.png\" alt=\"QQ图片20171102171441.png\"/></p>', null, null, null, null, '1509857725', '2', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('23', '2017', '10', '似懂非懂', '的点点滴滴', '的顶顶顶顶顶', '顶顶顶顶顶顶顶顶顶顶顶顶顶顶', '<p>设定点的的顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶</p><p>是顶顶顶顶顶顶顶顶顶顶顶顶顶顶</p><p><br/></p><p>士大夫第三方士大夫</p><p>所发生的</p><p>是的范德萨<img src=\"/Report/uploads/image/20171105/1509891664404031262.png\" title=\"1509891664404031262.png\" alt=\"QQ图片20171102171441.png\"/></p><p><br/></p><p>是的范德萨士大夫</p><p><br/></p><p><br/></p><p>士大夫</p><p><br/></p><p><br/></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_doc.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171105/1509891691474004559.docx\" title=\"20171016_医疗服务监控系统各地市情况说明.docx\">20171016_医疗服务监控系统各地市情况说明.docx</a></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171105/1509891691528020823.xlsx\" title=\"2016和2017上半年门诊慢性病统计.xlsx\">2016和2017上半年门诊慢性病统计.xlsx</a></p><p><br/></p>', null, null, null, null, '1509891699', '3', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('21', '2017', '10', '士大夫222', '多带点222', '顶顶顶顶222', '是非得失22', '<p>删掉防守打法士大夫22</p>', null, null, null, null, '1509857959', '0', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('22', '2017', '10', '阿士大夫的撒2222', '是的范德萨', '大师傅大师傅都是', '是的范德萨', '<p>是的范德萨范德萨sdfsdsdf</p>', null, null, null, null, '1509877760', '2', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('24', '2017', '10', '啊啊啊啊啊啊啊', '顶顶顶顶', '啊啊啊', '啊啊啊啊啊啊', '<p>的说法都是<br/></p><p>似懂非懂</p><p>是的范德萨发的</p><p>是的范德萨范德萨</p><p>是的范德萨</p>', 'c:/tmp/uploads/files/1510845530768.txt', '新建文本文档.txt', '13', null, '1510845530', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('25', '2017', '10', '是是是', '少时诵诗书', '算得上是多', '颠三倒四', '<p>是的范德萨</p>', 'c:/tmp/uploads/files/1510845900024.txt', '新建文本文档.txt', '13', null, '1510845900', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('26', '2017', '0', '是否', '水电费', '水电费', '水电费', '<p>是的范德萨</p>', null, null, '0', null, '1510846046', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('27', '2017', '10', '似懂非懂', '水电费', '速度', '大幅', '<p>第三方</p>', 'c:/tmp/uploads/files/1510846326654.txt', '新建文本文档.txt', '13', null, '1510846326', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('28', '2017', '10', '阿斯蒂芬', '水电费', '水电费', '水电费', '<p>水电费</p>', 'c:/tmp/uploads/files/1510846389694.', '', '0', null, '1510846389', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('29', '2017', '10', '水电费', '水电费', '是否', '速度', '<p>水电费</p>', 'c:/tmp/uploads/files/1510846894407.txt', '新建文本文档.txt', '13', null, '1510846894', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('30', '2017', '10', '的说法都是', '大师傅', '士大夫', '士大夫', '<p>是的范德萨</p>', null, null, '0', null, '1510926492', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('31', '2017', '10', '是的范德萨', '士大夫22222', '士大夫22', '士大夫', '<p>删掉防守打法</p>', '/Report/uploads/files/1510926525778.gif', 'warning.gif', '860', null, '1510926525', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('32', '2017', '10', '士大夫', '大师傅', '删掉', '大师傅', '<p>撒地方的萨芬</p>', '/Report/uploads/files/1510926978154.gif', 'warning.gif', '860', null, '1510926978', '2', '1', '4', '1', '1510928875', '');
INSERT INTO `t_matchapply` VALUES ('33', '2017', '10', '阿士大夫', '士大夫', '士大夫', '是的范德萨', '<p>是的范德萨</p>', '/Report/uploads/files/1510927454551.txt', 'pkg_t_data_bd.txt', '260376', null, '1510927454', '2', '1', '4', '1', null, '');
INSERT INTO `t_matchapply` VALUES ('34', '2017', '10', '士大夫都是删掉', '似懂非懂', '似懂非懂', '士大夫', '<p>是的范德萨</p>', '/Report/uploads/files/1510927507923.xls', '保定城乡居民医疗服务监控实施计划.xls', '256000', null, '1510927507', '2', '1', '4', '1', null, '');
INSERT INTO `t_matchapply` VALUES ('35', '2017', '10', '士大夫', '士大夫', '士大夫', '士大夫', '<p>是的范德萨</p>', '/Report/uploads/files/1510978481506.docx', '2016-09-02使用过程中反应的问题.docx', '29173', null, '1510978481', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('36', '2017', '10', '多带点', '定点', '定点', '定点', '<p>地方</p>', '/Report/uploads/files/1510978876881.docx', '2016-09-02使用过程中反应的问题.docx', '29173', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja4tserr-9q/Report.war//uploads/files/1510978876881.docx', '1510978876', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('37', '2017', '10', '是的范德萨', '士大夫', '是的范德萨', '是的范德萨', '<p>是的范德萨</p>', '/Report/uploads/files/1510989431465.docx', '2016-09-02使用过程中反应的问题.docx', '29173', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja502gtj-9s/Report.war//uploads/files/1510989431465.docx', '1510989431', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('38', '2017', '10', '士大夫', '士大夫', '士大夫', '删掉', '<p>士大夫<br/></p>', '/Report/uploads/files/1510989455451.xlsx', '2016和2017上半年门诊慢性病统计.xlsx', '12770', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja502gtj-9s/Report.war//uploads/files/1510989455451.xlsx', '1510989455', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('39', '2017', '10', '大师傅', '大师傅', '士大夫', '士大夫', '<p>是的范德萨</p>', '/Report/uploads/files/1510989628691.docx', '2016-09-02使用过程中反应的问题.docx', '29173', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja505fgh-9u/Report.war//uploads/files/1510989628691.docx', '1510989628', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('40', '2017', '10', '分', '的', '的', '的', '<p>地方</p>', '/Report/uploads/files/1510989643746.xlsx', '2016和2017上半年门诊慢性病统计.xlsx', '12770', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja505fgh-9u/Report.war//uploads/files/1510989643746.xlsx', '1510989643', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('41', '2017', '10', '大师傅', '发', '的', '的', '<p>士大夫</p>', '/Report/uploads/files/1510991057528.docx', '2016-09-02使用过程中反应的问题.docx', '29173', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja511ouc-9w/Report.war//uploads/files/1510991057528.docx', '1510991057', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('42', '2017', '10', '士大夫', '士大夫', '士大夫', '士大夫', '<p>士大夫</p>', '/Report/uploads/files/1510991075073.xlsx', '2016和2017上半年门诊慢性病统计.xlsx', '12770', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja511ouc-9w/Report.war//uploads/files/1510991075073.xlsx', '1510991075', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('43', '2017', '10', '士大夫', '士大夫', '大师傅', '发是', '<p>胜多负少的</p>', '/Report/uploads/files/1510991095957.txt', 'aaa.txt', '61970', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja511ouc-9w/Report.war//uploads/files/1510991095957.txt', '1510991095', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('44', '2017', '10', '士大夫', '士大夫', '士大夫', '删掉', '<p>士大夫</p>', '/Report/uploads/files/1510991718841.docx', '2016-09-02使用过程中反应的问题.docx', '29173', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja51rezq-a2/Report.war//uploads/files/1510991718841.docx', '1510991718', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('45', '2017', '10', '士大夫', '大师傅', '是否', '删掉', '<p>士大夫</p>', '/Report/uploads/files/1510991734715.xlsx', '2016和2017上半年门诊慢性病统计.xlsx', '12770', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja51rezq-a2/Report.war//uploads/files/1510991734715.xlsx', '1510991734', '1', '1', '4', null, null, '');
INSERT INTO `t_matchapply` VALUES ('46', '2017', '10', '士大夫', '士大夫', '删掉发是', '士大夫', '<p>士大夫</p>', '/Report/uploads/files/1510991751212.txt', 'aaa.txt', '61970', 'D:/jboss-5.1.0.GA/server/default/tmp/5c4o422-igbiaq-ja4qry2t-1-ja51rezq-a2/Report.war//uploads/files/1510991751212.txt', '1510991751', '1', '1', '4', null, null, '');

-- ----------------------------
-- Table structure for `t_matchinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_matchinfo`;
CREATE TABLE `t_matchinfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `annualmatch` varchar(4) NOT NULL DEFAULT '',
  `name` varchar(300) NOT NULL DEFAULT '',
  `matchtype` int(10) NOT NULL,
  `begindate` int(10) unsigned NOT NULL,
  `enddate` int(10) unsigned NOT NULL,
  `optunitname` varchar(300) NOT NULL DEFAULT '',
  `description` text,
  `content` text,
  `updatetime` int(10) unsigned NOT NULL,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `userid` int(10) DEFAULT NULL,
  `orgcode` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_matchinfo
-- ----------------------------
INSERT INTO `t_matchinfo` VALUES ('10', '2017', '打算范德萨发222', '11', '1509724800', '1514044800', '撒地方的萨芬2222', '<p>撒范德萨范德萨222222</p>', '<p>是的范德萨范德萨分<img src=\"/Report/uploads/image/20171104/1509762791728061494.png\" title=\"1509762791728061494.png\" alt=\"QQ图片20171102171441.png\"/></p><p><br/></p><p>sdfdsf胜多负少大丰收大222222222</p><p><br/></p><p><br/></p><p>是的范德萨范德萨2222222</p>', '1509764486', '1', '0', '');
INSERT INTO `t_matchinfo` VALUES ('11', '2017', '删掉防守打法', '11', '1509465600', '1510934400', '撒地方的萨芬', '<p>删掉防守打法</p>', '<p>撒地方的萨芬是的范德萨<img src=\"/Report/uploads/image/20171104/1509764192280020042.png\" title=\"1509764192280020042.png\" alt=\"QQ图片20171102171441.png\"/></p><p><br/></p><p>双方都第三方</p><p>sdfdsf水电费水电费多少</p><p>水电费水电费多少</p>', '1509764199', '0', '0', '');
INSERT INTO `t_matchinfo` VALUES ('12', '2017', '撒地方的萨芬', '11', '1509724800', '1510243200', '是的范德萨', '<p>是的范德萨</p>', '<p>撒地方的萨芬<br/></p><p>是的范德萨</p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_doc.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171104/1509793362521017172.docx\" title=\"20171016_医疗服务监控系统各地市情况说明.docx\">20171016_医疗服务监控系统各地市情况说明.docx</a></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171104/1509793373652022966.xlsx\" title=\"2016和2017上半年门诊慢性病统计.xlsx\">2016和2017上半年门诊慢性病统计.xlsx</a></p><p><br/></p>', '1509793382', '1', '0', '');
INSERT INTO `t_matchinfo` VALUES ('13', '2017', '阿士大夫的撒', '11', '1510329600', '1509638400', '是的范德萨', '<p>是的范德萨</p>', '<p>是的范德萨</p><p>似懂非懂</p><p><br/></p><p>撒地方的萨芬</p><p>是的范德萨</p><p>胜多负少的</p><p><br/></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171104/1509793579209041342.xlsx\" title=\"2016和2017上半年门诊慢性病统计.xlsx\">2016和2017上半年门诊慢性病统计.xlsx</a></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_doc.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171104/1509793579205005759.docx\" title=\"2016-09-02使用过程中反应的问题.docx\">2016-09-02使用过程中反应的问题.docx</a></p><p><br/></p>', '1509793583', '1', '0', '');
INSERT INTO `t_matchinfo` VALUES ('14', '2017', '胜多负少的', '11', '1509724800', '1509724800', '是的范德萨', '<p>是的范德萨</p>', '<p>是的范德萨<img src=\"/Report/uploads/image/20171105/1509850326091004315.jpg\" title=\"1509850326091004315.jpg\" alt=\"事前监控接口测试.jpg\"/></p>', '1509850329', '1', '0', '');
INSERT INTO `t_matchinfo` VALUES ('15', '2017', '是的范德萨', '11', '1510156800', '1509638400', '似懂非懂', '<p>是非得失</p>', '<p>撒地方的萨芬的<img src=\"/Report/uploads/image/20171105/1509850894715008676.png\" title=\"1509850894715008676.png\" alt=\"QQ图片20171102171441.png\"/></p>', '1509850896', '1', '0', '');
INSERT INTO `t_matchinfo` VALUES ('16', '2017', '士大夫2222', '11', '1510848000', '1510329600', '大师傅', '<p>士大夫</p>', '<p>胜多负少的</p>', '1509858004', '1', '0', '');

-- ----------------------------
-- Table structure for `t_matchresult`
-- ----------------------------
DROP TABLE IF EXISTS `t_matchresult`;
CREATE TABLE `t_matchresult` (
  `id` int(10) unsigned NOT NULL,
  `score` int(10) DEFAULT NULL,
  `ranking` varchar(400) DEFAULT NULL,
  `awards` varchar(400) DEFAULT NULL,
  `updatetime` int(10) unsigned NOT NULL,
  `ispublish` tinyint(1) NOT NULL DEFAULT '0',
  `publishtime` int(10) DEFAULT NULL,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `resultuserid` int(10) DEFAULT NULL,
  `orgcode` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_matchresult
-- ----------------------------
INSERT INTO `t_matchresult` VALUES ('22', '10', '等等', '是的范德萨', '1509979429', '1', '1510929780', '1', '1', '');
INSERT INTO `t_matchresult` VALUES ('19', '200', '水电费', '是的范德萨', '1510928921', '0', '1510405620', '1', '1', '');
INSERT INTO `t_matchresult` VALUES ('32', '100', '士大夫', '是的范德萨', '1510928908', '1', '1510324080', '1', '1', '');

-- ----------------------------
-- Table structure for `t_matchtype`
-- ----------------------------
DROP TABLE IF EXISTS `t_matchtype`;
CREATE TABLE `t_matchtype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL DEFAULT '',
  `description` varchar(255) DEFAULT '' COMMENT '描述',
  `updatetime` int(10) unsigned NOT NULL,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `isdisabled` tinyint(1) DEFAULT '0',
  `userid` int(10) DEFAULT NULL,
  `orgcode` varchar(20) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_matchtype
-- ----------------------------
INSERT INTO `t_matchtype` VALUES ('10', '测试类型222', '水电费第三方第三方的说法都是2222', '1509545829', '0', '0', '0', '');
INSERT INTO `t_matchtype` VALUES ('11', '是的范德萨', '的说法是否撒地方的萨芬撒地方的萨芬', '1509545607', '1', '0', '0', '');
INSERT INTO `t_matchtype` VALUES ('12', '阿士大夫', '士大夫第三方士大夫', '1509762032', '1', '0', '0', '');
INSERT INTO `t_matchtype` VALUES ('13', '的方法', '撒地方的萨芬', '1509762038', '1', '0', '0', '');

-- ----------------------------
-- Table structure for `t_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `accountid` varchar(50) NOT NULL,
  `password` char(32) NOT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `factname` varchar(50) NOT NULL DEFAULT '',
  `idcard` varchar(20) DEFAULT NULL,
  `birthday` varchar(20) DEFAULT '',
  `address` varchar(100) DEFAULT '0' COMMENT '积分',
  `qq` varchar(20) DEFAULT '' COMMENT '头像',
  `email` varchar(30) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `regtime` int(10) unsigned NOT NULL DEFAULT '0',
  `updatetime` int(10) DEFAULT NULL,
  `logintime` int(10) DEFAULT NULL,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `state` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES ('1', 'hch@qq.com', 'd31fa2d0f3cef21b3b53f1e4db56597e', '1', 'hch', null, '', '0', '', null, null, '1471524159', null, null, '1', '0');
INSERT INTO `t_member` VALUES ('2', '111', '111', '2', '111定点', '2323', '2017-09-28', '0', '12', '2323', '1212', '1477466340', '1509376658', null, '1', '0');
INSERT INTO `t_member` VALUES ('4', '333', 'c4ca4238a0b923820dcc509a6f75849b', '1', '三三', '3333344', '2017-09-29', '33水电费', '33333', '3333', '333', '1508942916', '1510143335', '1510992379', '1', '1');
INSERT INTO `t_member` VALUES ('5', '444', '670b14728ad9902aecba32e22fa4f6bd', '1', '水电费', '2323', '2017-10-11', '???????????', '23', '23', '23', '1508944535', null, null, '1', '0');
INSERT INTO `t_member` VALUES ('6', '666', 'c4ca4238a0b923820dcc509a6f75849b', '1', '的说法都是', '232', '2017-10-24', '大师傅大师傅', '2323', '2323', '23', '1508945896', null, null, '1', '0');
INSERT INTO `t_member` VALUES ('7', '1111', '670b14728ad9902aecba32e22fa4f6bd', '2', '地方', '2323', '2017-10-26', '第三方第三方第三方', '23323', '2323', '3223', '1509366534', null, '1510929720', '1', '1');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `pid` int(10) unsigned NOT NULL DEFAULT '0',
  `isshow` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '显示',
  `sort` smallint(6) NOT NULL DEFAULT '100',
  `isvalid` tinyint(1) NOT NULL DEFAULT '1',
  `url` varchar(50) DEFAULT NULL,
  `updatetime` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '内容管理', '0', '1', '1', '1', '', '1509463872');
INSERT INTO `t_menu` VALUES ('48', '报名须知', '1', '1', '3', '1', 'load4NoticeModify.do', null);
INSERT INTO `t_menu` VALUES ('47', '通知管理', '1', '1', '2', '1', 'load4MessageIndex.do', null);
INSERT INTO `t_menu` VALUES ('13', '公告管理', '1', '1', '4', '1', 'load4AnnounceIndex.do', null);
INSERT INTO `t_menu` VALUES ('14', '友情链接', '2', '1', '3', '1', 'load4LinkIndex.do', null);
INSERT INTO `t_menu` VALUES ('2', '系统设置', '0', '1', '5', '1', null, null);
INSERT INTO `t_menu` VALUES ('20', '网站设置', '2', '1', '1', '1', 'load4WebsiteModify.do', null);
INSERT INTO `t_menu` VALUES ('3', '会员管理', '0', '1', '3', '1', '', '1509541225');
INSERT INTO `t_menu` VALUES ('30', '会员管理', '3', '1', '1', '1', 'load4MemberIndex.do', null);
INSERT INTO `t_menu` VALUES ('4', '管理员管理', '0', '1', '4', '1', '', '1509541237');
INSERT INTO `t_menu` VALUES ('32', '用户管理', '4', '1', '1', '1', 'load4UserIndex.do', null);
INSERT INTO `t_menu` VALUES ('33', '岗位管理', '4', '1', '2', '1', 'load4RoleIndex.do', null);
INSERT INTO `t_menu` VALUES ('38', '菜单管理', '2', '1', '2', '1', 'load4MenuIndex.do', null);
INSERT INTO `t_menu` VALUES ('46', '新闻管理', '1', '1', '1', '1', 'load4NewsIndex.do', '1509463877');
INSERT INTO `t_menu` VALUES ('42', '修改资料', '4', '1', '3', '1', 'load4UserModify.do', null);
INSERT INTO `t_menu` VALUES ('43', '修改密码', '4', '1', '4', '1', 'load4UserPwdModify.do', null);
INSERT INTO `t_menu` VALUES ('63', '参赛结果管理', '59', '1', '4', '1', 'load4MatchresultIndex.do', null);
INSERT INTO `t_menu` VALUES ('51', '联系我们', '1', '1', '6', '1', 'load4AboutModify.do', null);
INSERT INTO `t_menu` VALUES ('59', '参赛管理', '0', '1', '2', '1', '', '1509541208');
INSERT INTO `t_menu` VALUES ('60', '参赛分类管理', '59', '1', '1', '1', 'load4MatchtypeIndex.do', '1509541261');
INSERT INTO `t_menu` VALUES ('61', '参赛项目管理', '59', '1', '2', '1', 'load4MatchinfoIndex.do', '1509541277');
INSERT INTO `t_menu` VALUES ('62', '参赛报名审核', '59', '1', '3', '1', 'load4MatchapplyIndex.do', '1509541442');

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(30) DEFAULT NULL,
  `content` text NOT NULL,
  `isvalid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `publishtime` int(10) unsigned DEFAULT '0',
  `ispublish` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否发布',
  `updatetime` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `userid` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES ('1', '通知手机版网站开通', null, '<p>手机版网站开通，用手机版网站开通手机访问http://demo.0871k.com 即可访问手机站</p>', '1', '1508996825', '1', '0', '0');
INSERT INTO `t_message` VALUES ('2', '通知公告xxxxx', null, '萨的发生地方', '1', '1508996825', '1', '1476521354', '1');
INSERT INTO `t_message` VALUES ('3', 'DDDD水电费', null, '是对方的事大使馆的时光是大法官的发生过是大法官的发生过分单方事故讽德诵功的发生过的发生过的发送给对方是个法师的广东佛山', '1', '1508996825', '1', '1476521365', '1');
INSERT INTO `t_message` VALUES ('4', 'asdas苏打水', null, '<p>啊大叔大叔大叔</p>', '0', '1508996825', '0', '1476521866', '1');
INSERT INTO `t_message` VALUES ('5', '啊的说法是大方', null, '<p>啊的说法的事</p>', '1', '1475312340', '0', '1476535268', '1');
INSERT INTO `t_message` VALUES ('6', '高富帅公司的', null, '撒都发大水发大水啊的说法是对方的事\r\n啊东方大厦\r\n啊大水法', '1', '1475313660', '0', '1476535245', '1');
INSERT INTO `t_message` VALUES ('7', '啊分撒发生的', null, '啊的说法的说法是打发发生的阿萨德范德萨发生的发多少啊撒地方撒地方士大夫士大夫的事啊啥地方撒地方撒地方撒的啊是放大范德萨发生大丰收的', '1', '1476538881', '1', '1476604503', '1');
INSERT INTO `t_message` VALUES ('8', 'afasfd师傅说的分手的', null, '水电费水电费的事adfasdf上发生的发生大幅撒地方撒地方的萨芬三大发生的', '1', '1476517200', '0', '1476604324', '1');
INSERT INTO `t_message` VALUES ('9', '是的范德萨', '水电费', '<p>士大夫的所发生的<img src=\"/Report/uploads/image/20171028/1509187227802007212.png\" title=\"1509187227802007212.png\" alt=\"logo.png\"/></p>', '1', '1509187200', '1', '1509187233', '1');
INSERT INTO `t_message` VALUES ('10', '阿道夫', '大幅度', '<p>大师傅大师傅都是是的范德萨</p><p><img src=\"/Report/uploads/image/20171028/1509187383047022866.jpg\" style=\"\" title=\"1509187383047022866.jpg\"/></p><p><img src=\"/Report/uploads/image/20171028/1509187383047046918.png\" style=\"\" title=\"1509187383047046918.png\"/></p><p><br/></p>', '1', '1509187320', '1', '1509187395', '1');
INSERT INTO `t_message` VALUES ('11', '是打发第三方', '是非得失', '<p>是的范德萨范德萨</p><p style=\"display:none;\" data-background=\"background-repeat:no-repeat; background-position:center center; background-color:#E36C09;\"><br/></p>', '1', '1509187500', '1', '1509252672', '1');

-- ----------------------------
-- Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL DEFAULT '' COMMENT '标题',
  `color` char(10) DEFAULT '' COMMENT '标题颜色',
  `author` varchar(30) DEFAULT '',
  `keywords` varchar(50) DEFAULT '' COMMENT '关键字',
  `content` text COMMENT '内容',
  `description` varchar(255) DEFAULT '' COMMENT '摘要描述',
  `publishtime` int(10) unsigned DEFAULT NULL COMMENT '发布时间',
  `ispublish` tinyint(1) NOT NULL DEFAULT '0',
  `updatetime` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '更新时间',
  `isvalid` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `userid` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '风投界不能只盯着“独角兽”式的公司', '', '', '风投界', '<p>　　每一家获得10亿美元估值的非上市公司都非常了不起。要知道，十年前，这些公司就算是在创始人本人的眼中也是前景难料。因此，在此向所有这些成功者致敬，然后继续进行跟踪报道。</p><p>　　但有一个问题有点开始困扰我：我们这样关注阶段性估值庞大的公司，可能导致我们一定程度上忽视那些估值未达到10位数但财务数据更好的公司。我们报道投资人时，这一点尤其突出。</p><p>　　我的意思是：假设ABC风投对一家交易后估值10亿美元的公司投资了5,000万美元，获得5%股份(是的，这里我进行了简化分析)。随后，这家公司上市，获得估值20亿美元，然后二级市场市值升到了50亿美元。突然之间，这笔投资的价值达到了2.50亿美元。太棒了。另外，假设123风投对一家交易后估值2,500万美元的公司投资500万美元，这家公司被雅虎以2.50亿美元收购(因此向123风投支付5,000万美元)。在我看来，123风投的交易似乎更划算，因为它实现了10倍的投资回报，而ABC风投仅实现了5倍投资回报。</p><p>　　但媒体不会公开为123风投唱颂歌，因为他们没有逮住“独角兽”。不过，现实是投资10亿美元以上公司的风投大部分也没有抓住“独角兽”。当然，有些公司确实捕获了“独角兽”(往往投资时间很早)，但大多数进入很晚，只是搭一段顺风车。</p><p>　　以《福布斯》杂志年度最佳创投人排行榜为例，这份排行榜宣称对全球顶尖的科技风投人进行排行。排行计算的主要依据是退出成本(即收购或IPO)，但同时也收录了几家尚未上市的独角兽公司(这可以解释为什么Accel的吉姆?布雷耶即使是在Facebook上市前也能在排行榜上占据榜首位置)。就算123风投有十几家账面市盈率达到两位数的未上市公司也没用，因为这些公司没有一家的估值达到了10亿美元。相比持有一家籍籍无名的生物科技公司的Series A优先股(刚刚以1.50亿美元或2亿美元的估值完成了D轮融资)，不如参与Airbnb大规模的C轮融资。</p><p>　　是的，风投是一项关于关注度的生意。每只基金都需要一、两家表现特别出众的公司来实现他们向投资者承诺的回报率。但可能我们都需要更加努力地来找到这些表现出众的公司，而不只是痴迷于那些独角兽。</p><p></p>', '每一家获得10亿美元估值的非上市公司都非常了不起。要知道，十年前，这些公司就算是在创始人本人的眼中也是前景难料。', '1508996825', '0', '1396244325', '1', '0');
INSERT INTO `t_news` VALUES ('2', '阿里53.7亿投资银泰 线下百货或面临站队', '', '', '阿里', '<p>　　【亿邦动力网讯】 3月31日上午消息，阿里巴巴集团与银泰商业集团共同宣布，阿里巴巴集团将以53.7亿元港币对银泰商业进行战略投资。双方将打通线上线下的未来商业基础设施体系，并将组建合资公司。双方约定在未来三年内，阿里集团最终在银泰商业的持股比例不低于25%。</p><p>　　马云与沈国军的“视野”</p><p>　　合作中，阿里集团将以认购银泰商业新股及可转换债券的方式进行投资，总投资额53.7亿元港币。交易完成后，阿里集团将持有银泰商业9.9%的股份及总额约37.1亿元港币的可转换债券。</p><p>　　双方约定在未来三年内，在相关法律法规许可的前提下，阿里集团可将可转换债券转换为银泰商业的普通股股份，从而使得阿里集团最终在银泰商业的持股比例不低于25%。</p><p>　　阿里和银泰的合作将主要在三个方面，阿里与银泰将全面打通会员体系、支付体系，同时将实现商品体系对接。</p><p>　　在此基础上，双方将构建一套打通线上线下商业的基础体系，实现线上线下的商品交易、会员营销及会员服务无缝联通。这套体系将对全社会开放，为所有的线下各大商业集团、零售品牌及零售商服务。</p><p>　　“收购银泰，剥离地产业务，整合线上线下资源，打造真正的O2O商业品牌输出值得期待。”有业内人士称。</p><p>　　“无论哪种形式，零售环节的存在是要让整个价值链增值，否则不会长久。”面对阿里投资银泰的动作，也有人士直接指出了零售最需要担任的角色。</p><p>　　不过，有支付宝内部人士猜测，阿里入股银泰有可能对百货零售业产生明显的蝴蝶效应，线下百货可能要面临“站队”问题，单纯的依靠原有线下零售模式难以应对O2O的变局。</p><p>　　当然，在其看来不论万达方式、京东方式亦或阿里银泰方式，双方面的资源整合至少提速了线下零售的信息化进程。</p><p>　　事实上，这次的阿里银泰联姻早有征兆。每年的天猫双十一，银泰总以一副全力支持的表情出现，亿邦动力网此前与银泰网、银泰百货负责人的多次接触时也早有体会。</p><p>　　去年的天猫双十一，银泰作为天猫O2O的线下练兵场投入重兵作战，阿里掌门人马云和银泰掌门人沈国军合推菜鸟网络，也是让银泰与阿里的关系更加亲密。</p><p>　　银泰集团在信息化过程中，已经有多路布兵，线下购物中心和百货商场铺设免费WIFI，而电商业务中，除了上线官方商城银泰网外，还在多电商平台入驻开店。</p><p>　　“不断创新变革，追求开放合作，期待‘新银泰’率先进入未来零售时空。”银泰掌门人沈国军信心满满；而在阿里首席运营官张勇看来，商业未来趋势是走向电子化，实体经济与互联网经济将基于大数据、云计算等技术实现融合互补，希望阿里银泰的合作能最终将所有百货企业、购物中心以及其他零售业态实现实体经济和互联网经济的融通。</p><p></p>', '3月31日上午消息，阿里巴巴集团与银泰商业集团共同宣布，阿里巴巴集团将以53.7亿元港币对银泰商业进行战略投资。', '1508996825', '1', '1396244454', '0', '0');
INSERT INTO `t_news` VALUES ('3', '58同城完成首次增发 融资7600万美元', '', '', '58同城', '<p>　　新浪科技讯 3月31日上午消息，58同城(纽交代码：WUBA)于上周五晚间发布公告宣布完成了IPO之后的首次增发。</p><p>　　根据公告显示，此次增发总计规模为600万股ADS，其中400万股来自之前的投资机构，200万股为新发股份。此次增发价格为38元每股ADS，按此价格计算此次交易规模为2.28亿美元。</p><p>　　此次58同城的增发，新发ADS200万股，融资7600万美元。根据之前媒体报道判断，58同城手中持有的现金约为4亿美元。</p><p>　　据悉，此次增发老股配售的部分占到了三分之二，均来自于之前的风险投资机构：软银赛富、DCM和华平投资。其中，软银赛富配售了约136万股ADS，DCM配售了约67万股ADS、华平投资配售了约197万股ADS，对应的金额合计约为1.52亿美元。</p><p>　　公司增发可以稳妥地为早期投资者提供退出机会。此次58同城增发，三家VC部分退出，并未进行较大规模的配售。而近期花期集团发布的关于58同城的研报告中分析师将58同城的目标价调高至59.6美元，仍然给予了买入评级。业内人士分析称，58同城完成此次增发，或将加速市场整合。</p><p>　　2月28日，58同城已经披露未经审计的2013年度财务数据，主营业务收入14570万美元，同比增长67.3%；实现净利润近1960万美元，同时净利润率提升5个百分点达到约25%的水平。(扬子)</p><p></p>', '58同城(纽交代码：WUBA)于上周五晚间发布公告宣布完成了IPO之后的首次增发。', '1508996825', '0', '1396244532', '1', '0');
INSERT INTO `t_news` VALUES ('4', '对于电商而言，比特币的未来会是什么样?', '', '', '比特币', '<p>　　随着比特币价值的急剧上涨，引起了普通大众对这个数字货币的注意，在2013年，比特币的价值就从13美元上涨到了1000美元。我们可以看到，许多主流经济学家在讨论这个数字货币，全球多个国家也在质疑比特币的合法性，不仅如此，一些知名的对冲基金也在他们的投资组合中购买了比特币，这些行为，多少让人感觉比特币存在一定的投机性。去年，对比特币来说，绝对算的上是最热闹的一年。</p><p>　　不过，对于企业和电子商务网站而言，现在是否是一个合适的时间开始接受比特币，并把它作为一种支付手段呢?</p><p>　　“在零售行业里，我们已经看到有些企业对比特币充满了好感。一些零售商相信，他们只是商人，只要能把商品销售出去，他们并不排斥任何形式的支付交易形式，” Mahesh Gandhe说道,他是Rackspace Digital公司的产品营销经理， “然而另外一方面，一些人对比特币则持怀疑态度，他们认为，在正式接纳、采用比特币之前，联邦政府应该对它进行规范化。”</p><p>　　在线零售商在决定是否采用比特币作为支付方式的时候，可以考虑一下本文提到的一些要点：</p><p>　　花掉从庄家那里赢来的钱</p><p>　　那些早期拥有比特币的投资人是非常幸运的，因为他们可以看到这些数字货币忽然一下子成为了一种真实的有形资产。当比特币的价值从几分钱陡增到几百美元，许多早期比特币持有者一下子获得了一大笔意外之财。</p><p>　　本质上来说，这种感觉就像是忽然捡到了一大笔钱，也像是一个在拉斯维加斯的赌徒，在连续赢钱的时候，就会大把大把的花掉口袋里从庄家那里赢来的钱。</p><p>　　实际上，许多早期的比特币持有者很容易被情绪所支配，虽然获得了一大笔意外之财，但是他们并不满足，最近，他们希望比特币可以变成一个主流货币。这对于那些在电子商务网站上使用比特币处理支付的早期用户来说，也许意味着是一种福利。</p><p>　　这里有一个不错的例子，那就是电商网站Overstock.com，他们最近接受了比特币。就在他们正式接受比特币作为支付手段不到一天的时间，该公司首席执行官Patrick Byrne就在推特上发布了一条推文，上面写道，他们公司已经收到了超过780份使用比特币支付的订单，总销售额超过12.4万美元。对于商户而言，他们只不过是提供了一个渠道，让那些充满激情的比特币用户能够花掉自己新获得的财富，显然，在这场刚刚开始的比特币盛宴中，那些走在前面的电子商务公司会得到一定的利益。</p><p>　　免费宣传</p><p>　　现在，那些接受比特币这种数字货币的零售商数量还比较少，也就是说，比特币在电商网站上应用支付还处于初级阶段，因此，如果你的电商网站接受了比特币支付，那么就会引起媒体大批量的报道。Roger Wu是Cooperatize.com的联合创始人，目前这个网站也开始接受比特币支付了。在最近一篇《福布斯》杂志的文章中，他提到，“接受比特币支付既是一件新鲜的事务，也存在一定风险，但是它也会带给你一定的曝光率，就像是经营最初的公共关系一样。”</p><p>　　在线约会网站OKCupid也是第一批接受比特币支付的大公司之一，他们是在2013年四月份开始接受比特币的。实际上，OKCupid使用比特币作为支付所带来的销售额并不是太大，大约只有一千人用比特币在其网站上进行支付，但是该公司却得到了大量的免费宣传，互联网上有许多文章都在介绍他们，因为他们是第一家接受比特币支付的约会网站。</p><p>　　当然啦，当越来越多的企业开始接受比特币，那么相应的新闻报道数量也会随之减少，但是就最近而言，如果你的公司接受比特币支付，那么仍然有很大机会获得一些媒体曝光。</p><p>　　比特币价值的不稳定性</p><p>　　比特币目前的价值是非常不稳定的，那些接受比特币支付的企业现在还不能实时地把这个数字货币兑换成本国货币，因此在这中间就存在了一定风险，因为有可能，比特币的价值会挥发掉，当然它也存在升值的可能性。</p><p>　　不仅如此，比特币还存在一种失控的可能性，在电子商务开源解决方案平台PrestaShop上，Gary Le Masson描述了一种具体情况，并将这种可能性赋予了一个名词，比特币失控(Bitcoin Crack)。基本上，这个名词的含义就是说，比特币价格会出现一种急剧下跌的情况，有可能在一天时间内下跌百倍，但是比特币也可能随后出现实物“买涨”的情况，价值又出现上浮，总而言之，比特币价值不够稳定，难以控制。</p><p>　　比特币持有人并不会用他们贬值的比特币去兑换美元，取而代之的是，他们会赶紧登上你的电子商务网站，用这个数字货币去购买一些有形商品。如果你的网站无法实时更新关联的比特币价格，那么作为一家电子商务公司，结果就很可能是下面这种情况：你收到了洪水般的购买订单，但是在结账的时候，你会发现，自己收到的却是已经贬值的货币。</p><p>　　货币安全</p><p>　　如今，几乎所有的东西都数字化了，因此，比特币的持有人必须要为他们的数字资产采取一定的预防措施。对于比特币钱包而言，现在已经部署了许多安全防范措施，其中最好的做法之一，就是把绝大部分资金存放在离线，加密的钱包之中。</p><p>　　正如Bitcoin.org网站给出的建议，他们认为，“比特币钱包就像是一个装满现金的钱包，举个例子，你肯定不会在自己的钱包里面装上一千美元，因为这笔现金太多了，也很危险，事实上，比特币钱包也一样，你也应该有同样的考虑。”</p><p>　　如果你使用比特币离线存储策略，那么当务之急就是要赶紧备份好自己的钱包，最好可能进行多个备份。举个例子，如果你的硬盘驱动器坏了，那么里面存储的数字照片可能会丢失，比特币钱包也一样，如果发生硬件故障，那么你的钱包也可能丢失。备份多个离线数字钱包是非常关键的，因为这么做可以有效的保护你的数字资产。</p><p>　　减轻波动性，增强安全性</p><p>　　许多在线零售商户都非常担心比特币的波动性和安全性，为了帮助他们消除相关方面的顾虑，笔者在此提供一些工具和平台，也许会对电商公司有所帮助。举个例子，Coinbase就是这样一个平台，它可以帮助商户便捷地接受比特币作为支付手段。另外，为了不受比特币价格波动的影响，电商商户可以特别指明自己所提供的商品或服务所对应的本国货币价格。</p><p>　　在日终结算的时候，Coinbase可以帮助商户将所有比特币交易的商品和销售额进行汇总，然后算出一个总销售额，并把这笔钱打入到商户的账户里面，Coinbase会收取一定的手续费，但是这笔手续费不会超过总交易金额的1%。</p><p>　　“举个例子，商户可以给一台烤面包机定价为30美元，在后台，这个金额会兑换成对应数量的比特币，然后用户就可以用比特币进行支付，Coinbase会把用户支付的比特币实时转换成美元，”Fred Ehrsam在SXSW大会上说道，他是Coinbase公司的联合创始人，“对于商户来说，不存在汇率风险，整个支付过程看上去只是给商户多了一个支付选择，而且速度更快，费用也更低。”</p><p>　　不仅如此，由于可以把商户每天的比特币销售额转换成本国货币，在线零售商也不用担心比特币的安全性问题了，也不用担心自己的比特币钱包内的资金太多。</p><p>　　不过，电子商务公司在选择第三方支付平台的时候，必须要做到非常谨慎。今年二月底，全球最大的比特币交易所Mt.Gox倒闭了，他们估算约有744，408个比特币单元下落不明。由于比特币不受监管的特性，导致比特币变成了一把双刃剑，如果你的电商公司决定使用比特币，那么比较要非常谨慎的去评估每一个比特币交易所和比特币平台，这点非常重要。</p><p>　　未来货币或金融架构?</p><p>　　虽然目前比特币还不能被看作是一个真正意义上的货币，但是它的使用范围正在变得越来越广泛，势头也很强劲。随着这种势头，比特币的未来似乎要朝着两条路发展。一条路是它有机会变成一种主流货币，人们可以实际购买，出售，并持有比特币，无需折腾来折腾去，不断地把比特币兑换成本国货币使用。</p><p>　　第二条路，就是比特币会变成一种协议，专门为在线货币兑换服务，这样的话，像Coinbase这样的比特币交易平台就会在买家和卖家之间提供兑换服务，就当下普遍情况来看，比特币交易平台收取的手续费率一般不会超过2.5%。如今，不管商户是否接受比特币，对于电子商务公司和在线商户而言，这场趋势所带来的变革绝对是非常有趣的。</p><p>　　（via tnw 译/快鲤鱼）</p><p></p>', '随着比特币价值的急剧上涨，引起了普通大众对这个数字货币的注意，在2013年，比特币的价值就从13美元上涨到了1000美元。', '1508996825', '1', '1396245747', '1', '1');
INSERT INTO `t_news` VALUES ('5', 'Facebook披露Connectivity Labs，推进无人机计划', '', '', '无人机', '<p>　　【Facebook披露Connectivity Labs，推进无人机计划】前不久，Facebook刚刚收购了无人机制造商Titan Aerospace，他们计划用无人机技术把互联网带到世界上任何一个角落，让没有网络的地方也能连上网。今日，Mark Zuckerberg 宣布已经为其“连接实验室(Connectivity Lab)”项目找来了来自美国宇航局的喷气推进实验室和艾姆斯研究中心的航空和通信专家们。</p><p>　　据资料显示，这种无人机能够利用太阳能在高纬度航行数月。Facebook此前联合爱立信、诺基亚、高通、三星等企业推出了Internet.org计划，与电信运营商进行合作，让人们连接互联网变得更容易。谷歌也在试图“连接世界”。该公司计划利用太阳能热气球向偏远地区人们提供互联网接入服务。</p><p>　　【微软正式发布iPad 版Office应用套件】在新CEO Satya Nadella 上任后，微软正在进行改革。微软一改此前态度，推出iPad版Office套件。微软周四宣布，iPad用户即日起可通过苹果公司的应用商店下载或购买其包含Word、Excel和PowerPoint在内的Office应用套件。iPad版Office还支持触摸屏控制，用户们可以通过拖拽操作。</p><p>　　【苹果新专利：蓝宝石玻璃防油污涂层】本周四披露的专利显示，苹果获得了“蓝宝石玻璃防油污涂层”专利。这种技术可以应用在手机、平板电脑和其他便携式设备上。此举或说明苹果正在积极研发蓝宝石玻璃相关的技术，iPhone6有望配备蓝宝石显示屏。 今日有媒体称苹果公司或将在9月发布“iPhone 6”，提供4.7英寸和5.5英寸两种显示屏尺寸。</p><p>　　【流媒体音乐服务商Spotify有望今年秋季IPO】流媒体音乐服务商Spotify已经开始接触投行，并且有可能会在今年秋季IPO。Spotify由两位瑞典企业家创建于2008年，现在已经成了成长最快的音乐流媒体服务之一。对于华尔街而言，Spotify或许会很受欢迎：因为它有85%的收入来自订阅费用而不是广告。其最大竞争对手Pandora在2011年就上市了。</p><p>　　【英特尔入股大数据初创企业Cloudera】英特尔周四表示，公司投资大数据软件初创公司Cloudera，并已成为该公司最大的战略股东。英特尔希望通过此投资来扩大其服务器业务，以抵消个人电脑市场下滑所带来的冲击。</p><p>　　英特尔指出，入股Cloudera是其在数据中心领域所完成的最大规模的一次投资。但该公司未公布具体的交易金额。</p><p>　　Cloudera是一家专注于帮助企业客户利用Hadoop管理大数据的初创公司。英特尔将推广Cloudera的Hadoop解决方案。</p><p></p>', 'Facebook刚刚收购了无人机制造商Titan Aerospace，他们计划用无人机技术把互联网带到世界上任何一个角落', '1508996825', '1', '1396245823', '1', '0');
INSERT INTO `t_news` VALUES ('6', '外卖送餐服务Sprig获A轮融资1000万美金，现做热乎饭菜20分钟内送上门', '', '', '', '<p>　　外卖送餐服务Sprig刚刚获得 A 轮融资 1000 万美金，领投方为 Greylock Partners，Accel Partners 和 Battery Ventures 参投。此前获得天使轮 200 万美金。</p><p>　　Sprig 在食材上选择当地应季的健康原材料，算是它跟其它服务的一个差异；每天用户可选套餐为 3 种，每日更换菜谱，20 分钟内将热乎乎的现做饭菜送上门，通过应用内预订和支付完成交易。每个套菜订价 10 美元，外加 2 美元快递费。有需要的话，用户也提出择无麸质和素食这样的条件。服务时间段为 5:30pm-9:30pm，看来服务人群像是没人给做饭吃的单身上班族。</p><p>　　如此看来 Sprig 的服务及时、健康、价格合理。个人认为，做好 O2O 服务的关键就是要把整个流程标准化，从菜品策划、烹饪、送餐等环节概莫能外。</p><p>　　此外，为 Sprig 增光的另一个事实在于它的主厨曾是负责 Google 当年的大厨 Nate Keller。</p><p>　　Sprig 目前仅服务于旧金山的各个社区，不知拿到这笔融资会不会把这个服务复制到其它城市。送餐服务是个竞争很激烈的市场，Square 也在旧金山小范围测试午餐服务Pickup， 仅限订餐、送达服务。</p><p>　　该公司联合创始人为 Gagan Biyani，是开放式在线教育 Udemy的创始团队的一员，也曾是私家家共享服务 Lyft 向洛山矶扩张时的顾问。</p><p>　　[36氪，作者: Chloe]</p><p></p>', '外卖送餐服务Sprig刚刚获得 A 轮融资 1000 万美金，领投方为 Greylock Partners，Accel Partners 和 Battery Ventures 参投。此前获得天使轮 200 万美金。', '1508996825', '1', '1396245943', '0', '1');
INSERT INTO `t_news` VALUES ('7', '付费应用营收正以惊人速度收缩', '', '', '', '<p>　　现在的移动应用充满了程序内购买和广告，让人心生厌恶，但又无处可逃。据应用跟踪机构App Annie所提供的调查结果显示，现在整个应用市场都在走向免费增值服务模式(Freemium)。</p><p>　　该调查还发现，付费应用在2013年的总营收较上年下降了惊人的29%。此外，采用免费增值模式的应用的总营收则在同期增长了210%。这也从另一个角度解释了为何整个移动应用产业向免费增值服务快速靠拢。据悉，这些数据是该机构对苹果iOS和谷歌(微博)Google Play应用商店综合调研做出的判断。</p><p>　　调查还显示，付费应用对全球应用营收的贡献在2013年为4%，而这一比例在2012年还是8%。App Annie认为应用内广告在未来几年将因免费增值模式应用而得到极大的发展。到2017年，应用内广告增长速度在美国、欧洲和巴西能达到60%。</p><p>　　不过，有趣的是，这一现象难以在全球最大的应用市场——日本得到复制。在日本，应用内广告营收比重可能仍占据应用内销售额的四成左右。这可能与日本消费者热衷进行应用内购买的行为有关。日本用户的这一消费行为也令该国成为2013年全球最有利可图的应用市场。</p><p>　　当然，凡是都有例外。在移动引用市场，这一规则依旧成立。瑞典知名游戏开发商Mojang就证明其仍有可能通过付费下载模式产生丰厚的回报。即使风靡全球的Minecraft标价7美元，但付费下载仍然难以阻止其成为Mojang经久不衰的“印钞机”。该游戏去年跻身全美iPhone应用收入前20。值得一提的是，在去年全美iPhone应用收入前80中，只有Minecraft和男同应用Grindr为付费应用，其余的均为免费下载应用。</p><p></p>', '现在的移动应用充满了程序内购买和广告，让人心生厌恶，但又无处可逃。据应用跟踪机构App Annie所提供的调查结果显示，现在整个应用市场都在走向免费增值服务模式(Freemium)。', '1508996825', '1', '1396246027', '1', '0');
INSERT INTO `t_news` VALUES ('8', '吴鹰：移动化推动产业互联网发展', '', '', '', '<p>　　他说，为什么本次峰会取名IT新价值？中国经济发展到今天取得令世界瞩目成绩、令人不可相信的高速增长，但是同时也带来了一些问题，比如雾霾等。经济发展速度能不能可持续，能不能给我们子孙后代带来健康发展，我们下一个经济增长点在哪里，IT将扮演新的重要角色。</p><p>　　他还认为，今天全世界五大互联网公司市值最高的前五大有两家在中国：腾讯、百度。马上可能有第三家了，如果阿里巴巴今年上市成功了，一定是1000亿美金以上的市值。</p><p>　　中国（深圳）IT领袖峰会由深圳市人民政府和数字中国联合会主办，从2009年开始举办，目前已成功举办5届，今年峰会的主题是“IT新价值与产业互联网”。</p><p>　　以下是数字中国联合会主席吴鹰致辞实录：</p><p>　　尊敬的王荣书记、尊敬的刘部长、尊敬的刘副省长，各位嘉宾、各位朋友，大家好！非常高兴又来到每年一度中国（深圳）IT领袖峰会，非常感谢深圳市委市政府对我们的一贯支持，数字中国联合会作为民间非盈利组织一直推动着中国信息产业发展，到今天为止，在深圳的IT领袖峰会已经第六届了，对IT产业新发展、新方向进行了深入探讨。昨天晚上的闭门峰会也是非常精彩，经过企业家很多思想碰撞，对很多问题有了更深理解。对互联网新的发展有了更深的认识。</p><p>　　由于三中全会提出了60项具体的深化改革发展的方案，对中国的企业，对中国的经济打了一剂强心针，特别是前些日子公布的中国网络安全与信息化领导小组组长由习近平总书记亲自担任，对我们做信息产业是很大的鼓舞，这个在我印象中以前的信息化领导小组组长是总理，这次是总书记亲自兼，级别又提高了一步，说明了国家领导人对信息产业高度重视。同时迎来了以移动互联网为引领的对互联网发展的新的浪潮。这次峰会为什么选择IT新价值与产业互联网这样一个主题，可能大家有疑问。为什么说是IT新价值？中国经济发展到今天过去30年取得令世界瞩目、令人不可相信的高速增长，但是同时也带来了一些问题，比如北京雾霾等等。经济发展速度能不能可持续，能不能给我们子孙后代带来健康发展，我们下一个经济增长点在哪里，哪一个是驱动。刚才伍浩先生提到了信息产业对中国经济产业发展是一个重要的驱动力量，我也很受鼓舞。他的观点和看法我非常受鼓舞。麦肯锡一个月前做了一个调查报告，预测2025年的时候移动互联网产生13万亿美元左右的市场份额，是一年。云计算是5-7亿美元的市场。互联网再加上RFID等等又是3万亿市场，这些市场加起来是每年20万亿美元以上的市场，比我们通常预测的还要高。这次浪潮来的时候，移动互联网是以人为单位，中国有13亿人口，这个时候可能是一个优势。互联网上一个浪潮的时候，对人们的个人生活方式带来很大转变，思维方式、生活方式很大改变，已经产生了那么多新的巨型几千亿美元市值的公司。下一个浪潮是什么呢？对产业的改变。产业互联网是什么意思呢？对各个产业的互联网化，将带来各个产业巨大的发展。这次我们举了一个非常重要的例子，个人认为对中国非常绝好的机会，就是互联网金融，带来了巨大机会。</p><p>　　讲到这些机会的时候，我们也不得不认识到刚才伍浩先生提到的这个产业怎么管理、怎么发展，他有媒体一定的属性，但是更重要是一个产业，像管内容一样管，管死了不行。但是安全也很重要。数字中国联合会一直提倡跟政府不对抗，合作、发展、建设。建设过程中怎么来发展？怎么来解决安全的问题也是我们领袖们要探讨的，在哪些行业，各个高端的分论坛上也要进行一个探讨，所以大家有一个很好的期待。有意思的是，IT产业大事很多。今年以来，从互联网公司腾讯、百度，到阿里巴巴，再加上联想都进行了很多收购兼并，有些嘉宾今年没有来，和这个也有关系。但是我讲这个，你不要乱猜，不要以为马云(微博)跟雷军(微博)坐在一起就有其他猜想，这只是会务把他们安排坐在一起。</p><p>　　记得在三年前的时候在这个台上，当年就问李彦宏说你能不能买雅虎？雅虎当时市值200亿，今天大概400亿，很重要原因就是阿里巴巴要上市。今天全世界五大互联网公司市值最高的前五大有两家在中国，腾讯、百度。马上可能有第三家了，如果阿里巴巴今年上市成功了，一定是1000亿美金以上甚至远远高于。所以大家敬请期待我们今天全天精彩内容，我再次感谢深圳市委市政府对IT领袖峰会的支持，我也没有看到一个市长一把手亲自做主持人的情况，没有看到书记亲自坐镇，谢谢深圳市委市政府对我们的支持，也谢谢大家参加IT领袖峰会，谢谢！</p><p></p>', '他说，为什么本次峰会取名IT新价值？中国经济发展到今天取得令世界瞩目成绩、令人不可相信的高速增长，但是同时也带来了一些问题', '1396246101', '1', '1396246101', '1', '0');
INSERT INTO `t_news` VALUES ('9', '解密打车软件大战：巨额补贴背后的低成本扩张', '', '', '', '<p>　　在77天的打车软件补贴大战后，嘀嘀打车交出了一份成绩单：嘀嘀打车用户从2200万增加至1亿，日均订单从35万增长至521.83万，通过微信支付的补贴达到14亿。这意味着嘀嘀每个新用户的获得成本仅为18元左右。</p><p>　　过去的两个月，嘀嘀打车和快的打车上演了过山车式的补贴大战：1月初，补贴潮初涌，2月进入白热化，一周内双方交替提高补贴，但高补贴无法长期维续，3月，双方不约而同降温，进入了后补贴时代。</p><p>　　在嘀嘀宣布微信支付补贴超过14亿后，快的打车对腾讯科技表示目前尚未有新的数据宣布，但双方背后巨头之间的较量仍在继续，不仅给打车软件现金支持，还开放资源和入口，比如嘀嘀接入了多款手机游戏，快的也和阿里的部分O2O业务达成合作，以提高软件的竞争力。</p><p>　　事实证明，尽管补贴总价看似高昂，但单个用户的获取成本很低，唯一的问题是，当打车软件补贴大赛暂告一个段落后，还有哪些业务可以使用类似的活动快速扩张？</p><p>　　补贴大战的逻辑</p><p>　　这场两个月的补贴大战给嘀嘀带来了一份不菲的成绩单。嘀嘀的数据显示了这种变化——1月10 日，全国32个城市日均35万单；2月24日，全国120个城市日均316万单；3月28日，全国178个城市，日均521.83万单。</p><p>　　用户数方面，补贴之前，嘀嘀约为2200万用户，3月27日，嘀嘀打车用户数突破1亿。嘀嘀打车在过去77天里，以日均521.83万的订单量超过了京东13.27万单、淘宝 410.95万单和美团21.91万单，成为了国内最大的移动互联网日均订单交易平台。</p><p>　　按照补贴14亿元，嘀嘀新增7800万用户推算，单个用户获取补贴的成本约为18元。相比较而言， 目前很多移动应用推广单用户获取成本动辄已经上升到40-50元，微信支付获取用户的成本尚算适中。</p><p>　　对微信支付更划算的一点是，至少培养了用户的移动支付习惯。在3月28日深圳举行的互联网金融论坛上，艾瑞金融行业研究分析师王维东表示，腾讯、阿里PK之所以如此激烈，一个核心目的就是培养用户行为习惯。互联网前15年发展过程已经证明，电子商务对于用户和在线金融服务人士具有重要意义，移动支付也是如此。</p><p>　　此外，另一个受益的副产品是消解了人们对移动支付安全的担忧。在嘀嘀打车引入微信支付后，活动最开始的一周内，从嘀嘀打车的后台数据来看，80%左右的出租车司机是收到一笔车费立刻就提现 ，后来降成一天提现一次，现在，近90%司机每3天提现一次。</p><p>　　嘀嘀的相关负责人曾解释，最开始司机不了解微信，担心这种新型支付模式的安全，后续逐步了解，对安全性的担忧减低。</p><p>　　补贴大战实为入口之争</p><p>　　打车软件的补贴大战少不了身后腾讯和阿里支持的功劳，也让创业公司市场占有率的争夺变成大公司的入口之争，双方不断加码补贴。</p><p>　　2014年初，快的打车宣布投入1亿元补贴用户的时候，或许曾未料到一场补贴大战持续上演。</p><p>　　1月9日，在嘀嘀宣布融资后，嘀嘀表示将借助微信支付进行补贴用户的活动。一个月后，双方均交出了一份成绩单：</p><p>　　嘀嘀的官方数据透露，1月10日至2月9日，嘀嘀打车中平均日微信支付订单数为70万单，总微信支付订单约为2100万单，补贴总额达4亿元。活动期间，嘀嘀打车用户突破4000万，较活动前增长了一倍；日均订单为183万单，2月7日节后第一天达到峰值262万单，微信支付订单峰值过200 万单。</p><p>　　2月8日，快的发布的数据显示，截止到当时，日均订单量已达128万，单日最高订单量突破162万 ，其中使用支付宝钱包付车费的日订单数最高突破60万。</p><p>　　后补贴时代迎来监管</p><p>　　在两家打车软件高额补贴迅速引爆市场的同时，也产生了诸多问题，比如：</p><p>　　出租车司机开始挑活儿，原本是提高打车效率的打车软件导致空车拒载的现象愈演愈烈；</p><p>　　一些乘客手机网络差或忘记支付密码；</p><p>　　打车软件后台系统处理不了爆炸式增长的用户需求信息，导致打车软件经常显示支付不成功；</p><p>　　一些司机为了奖励在驾驶途中不断抢单，行车安全无法保障，甚至违背了行驶途中不能打电话的交通法规。</p><p>　　目前，双方已经主动进行补贴降温。嘀嘀从3月初连续4次进行调整随机减免的数额，从最高减20元降至3月18日立减5元。快的从3月22日零点起做出调整，北京、上海、杭州等城市保持每单立减5元、每天2单不变。其他城市的补贴金额调整为每单立减3元，每天2单。</p><p>　　降低补贴也削减了用户在打车软件上的热情，但无伤大局，有司机和乘客明确表示，在补贴软件降到5元以下后，吸引力已经不大，使用打车软件打车的次数会减少，但是仍会使用打车软件。</p><p>　　打车软件兴起之初，交通部门曾有政策上的干预，致使部分打车软件偃旗息鼓，最近，又有新的监管声音响起。</p><p>　　3月28日，交通运输部召开2014年度第二次例行新闻发布会，交通运输部政策研究室副主任李扬在发布会上表示，出租车电召服务中，当前有些企业对使用手机打车软件的乘客和司机都给予了物质奖励，这个可能会对市场的公平性产生影响。</p><p>　　此前，两会期间，交通运输部党组书记、部长杨传堂表示，交通运输部将会同有关部门加快研究制定规范手机召车软件发展的指导性意见，制定出租车电召服务规范化技术标准，支持和引导地级以上的城市建立出租车服务管理的信息系统。</p><p>　　这也意味着，交通部门要出手平抑打车软件造成的不公平了，这对两家打车软件公司未必是一件坏事，但却给背后的腾讯和阿里带来了新问题：</p><p>　　当打车软件补贴大赛暂告一个段落后，还有哪些业务可以使用类似的活动快速扩张？</p><p></p>', '在77天的打车软件补贴大战后，嘀嘀打车交出了一份成绩单：嘀嘀打车用户从2200万增加至1亿，日均订单从35万增长至521.83万', '1396246187', '1', '1396246187', '1', '0');
INSERT INTO `t_news` VALUES ('10', 'iPad版Office内售Office 365 苹果抽成30%', '', '', '', '<p>　　微软不仅令人满意地推出了iPad版Office应用程序，而且还准备在该应用程序内直接销售Office 365订阅服务。Office 365订阅服务可以给微软创造每个用户每年99美元的营收。但是，苹果也将从这款iPad版Office应用程序中获益良多。</p><p>　　科技网站Re/code证实，对于微软在iPad版Office应用程序中销售的Office 365订阅服务，苹果将从其营收中提取30%的提成。这一点并不让人感到意外。苹果要求其他公司支付提成费用的态度一直非常坚决。曾几何时，亚马逊不愿支付这样的费用，结果迫使苹果痛下杀手，取消了亚马逊iOS应用中的所有亚马逊网店链接。</p><p>　　iPad版Office应用程序中包含有Office 365 Home的应用程序内购买设置。Office 365 Home的售价为99.99美元，这意味着如果有用户通过其iTunes账户注册订阅Office 365 Home服务，苹果就能够从中获得30美元的提成。这也很公平：如果用户没有下载或不希望使用iPad版Office软件，他们也不需要订阅Office 365 Home服务。</p><p>　　这也是苹果CEO蒂姆-库克（Tim Cook）立即庆贺Office登陆其应用商店的原因之一。Office登陆iPad不仅有利于微软，而且还是苹果iOS平台的福音。</p><p>　　[腾讯科技]</p><p></p>', '微软不仅令人满意地推出了iPad版Office应用程序，而且还准备在该应用程序内直接销售Office 365订阅服务。', '1396246269', '1', '1396246269', '1', '0');
INSERT INTO `t_news` VALUES ('11', 'Dropbox收购阅读平台 云储存转型内容服务', '', '', '', '<p>　　对于Dropbox、Box等云存储服务商而言，业务单一带来前途渺茫、上市后发展空间不足等风险，实际上，云存储仅仅是谷歌(微博)、亚马逊等云计算巨头中的一个单一产品而言。这些准备上市的云存储服务商，已经开始转型，瞄准了苹果、谷歌、亚马逊的数字内容和媒体模式。最新的消息，是Dropbox即将收购一款数字阅读分享工具。</p><p>　　在此之前，Dropbox已经推出了照片管理和上传功能，产品定位上类似雅虎旗下的Flickr，此外，Dropbox还收购了音乐流媒体公司Audiogalaxy。显然，Dropbox已经不再满足于提供一个空间，让用户进进出出“运输文件”。</p><p>　　据美国科技媒体引述知情人士报道，Dropbox正在和德国柏林的Readmill公司进行收购洽谈，这是一个社交阅读和分享平台。据称，收购价格在800万美元左右。</p><p>　　Readmill公司成立于2010年，当时是作为面向数字图书阅读工具的补充产品，用户可以和好朋友分享数字图书中的精彩章节，使得阅读活动具有更多的社交分享特色。</p><p>　　另外，该公司也推出了一个阅读应用工具，囊括安卓和iOS的手机版，以及iPad版本。在用户界面上，该工具类似Twitter，可以关注其他好友的阅读爱好等。</p><p>　　就在三月中旬，据媒体报道，Dropbox已经收购了一家名为Zulip的公司，其主要研发囊括电脑、手机和平板的企业内部员工聊天协作工具，目前这款工具仍在测试当中，尚未正式发布。该产品的对手包括微软旗下知名的Yammer。</p><p>　　二月份，Dropbox曾经获得了3.5亿美元的风险投资，据称公司估值已经接近100亿美元，这将是上市之前的最后一轮融资。显然，在上市之前，Dropbox必须纳入更多的业务和“概念”，为上市之后的业绩增长，准备好足够的潜力。</p><p>　　Dropbox的竞争对手Box，已经提出了上市申请，计划融资2.5亿美元。</p><p>　　需要指出的是，Dropbox收购音乐流媒体服务商Audiogalaxy之时，外界预计其将很快进入音乐市场，和Pandora、Spotify等厂商竞争。不过时至今日，Dropbox的音乐服务尚未推出，而在去年下半年，谷歌、苹果相继进入了音乐流媒体市场（苹果为免费服务），这一领域竞争惨烈，Twitter的音乐服务就败走麦城，分析人士表示，Dropbox很可能已经错过了进入音乐市场的黄金机会。</p><p>　　面对苹果和亚马逊的巨大成功，数字内容商城的商业模式，正在引起越来越多互联网公司的效仿，谷歌后来的Play商城，收入逐渐攀升，诺基亚、三星电子也都在模仿内容商城的业态，以求硬件一次性的买家，变成源源不断贡献收入的品牌粉丝。</p><p></p>', '对于Dropbox、Box等云存储服务商而言，业务单一带来前途渺茫、上市后发展空间不足等风险，实际上', '1396246329', '1', '1396246329', '1', '0');
INSERT INTO `t_news` VALUES ('12', '智能汽车战场硝烟弥漫 苹果谷歌双雄对决', '', '', '', '<p>　　在不久前召开的“日内瓦车展”（Geneva Motor Show）上，苹果正式发布了备受期待的CarPlay车载智能系统，而包括梅赛德斯奔驰、法拉利、宝马、福特、通用、本田、现代、捷豹、路虎、起亚、三菱、日产、标致雪铁龙、斯巴鲁、铃木以及丰田等知名汽车厂商也都同苹果达成了合作伙伴关系，因此我们有望在不久后问世的新车型中看到这一系统的出现。</p><p>　　在看到这里的时候我们不禁要问，苹果的CarPlay究竟有什么过人之处？</p><p>　　从表面来看，这一产品仅仅是针对汽车厂商推出了一个经过深度定制的车载操作界面而已，这同微软和福特在2007年CES展会上所推出的车载娱乐系统“Ford Sync”非常类似，该系统同样可让驾驶者通过语音指令拨打电话、听取文字信息。驾驶者也可以利用语音指令或方向盘上的按钮播放iPod、Zune等便携设备，甚至读取USB闪存内的音乐文件。</p><p>　　那么，苹果的CarPlay究竟和前者有何不同，为什么需要在整整7年后才姗姗来迟呢？</p><p>　　或许，这部分是由于汽车厂商需要一定的时间才能意识到自己此前对车载信息娱乐系统采取传统做法是注定失败的。在这一产业兴起之初，所谓的“车载信息娱乐系统”仅仅是包含了电台和一部CD播放器而已，因此汽车厂商需要做的仅仅是在自己的产线中增加一道将娱乐系统嵌入中控台的工序而已。但随着软件开始入侵车载中控台，汽车厂商便一下子感到无力招架了。而且，他们为汽车所配备的导航和娱乐系统的实用性相比智能手机和平板电脑应用依旧相去甚远。</p><p>　　当年福特和微软的结盟使得后者得以首次设计一套车载信息系统，但微软却始终没有找到正确的研发方向。当时，微软所开发的“Ford Sync”系统实际上就是一套基于车载中控台运行的车用Windows系统而已，但消费者真正需要的只是将车载系统同智能手机连接在一起而已。</p><p>　　事实上，在拥有一个智能手机、平板电脑接口、电源以及可接入音响系统的操作界面后，汽车用户实际上已经拥有一个熟悉的车载互联网生态环境。在这一环境下，我们可以进行存储音乐、播放流媒体、收听电台、导航、设定提醒事项、查看电话簿和社交媒体更新等操作。汽车消费者不需要另外一部设备来完成这些工作，而是希望能够继续使用我们日常生活中每天都会使用到的设备来进行替代。</p><p>　　毫无疑问的是，苹果很早就意识到了消费者的这一需求，但说服汽车厂商接受这一现实却需要花费更多的精力。通过推出CarPlay，苹果为驾驶者提供了异常简便、安全的在途互联网接入功能。</p><p>　　硝烟弥漫</p><p>　　与此同时，谷歌(微博)则凭借自己在2014年CES展会上宣布的“开放汽车联盟”(Open Auto Alliance)平台朝着相同的方向挺进。目前，谷歌对于这一平台并没有给出太多信息，但我们相信该公司的计划绝对不会是仅仅将Android系统照搬进汽车内部这么单纯。</p><p>　　随着苹果和谷歌加入战局，汽车产业也将迎来翻天覆地的变化。此前那些经常需要多人共用一辆车、时常租车的消费者甚至可以将个性化的车载娱乐和信息系统无缝带到任何一部车辆中。</p><p>　　有分析人士认为，围绕着苹果和谷歌这两大科技巨头车内空间之争的“智能汽车战争”已经拉开帷幕。目前，消费者对于车载娱乐信息系统的需求其实非常简单，他们需要的仅仅是通过一个类似于自己智能手机、平板电脑的操作界面来在驾驶途中（无论是自己的车辆还是租来的车辆）安全的控制导航、音乐和信息系统而已。</p><p>　　而且，由于智能手机已经成为了现代人类生活中不可分割的一部分，汽车厂商也需要避免作出僵化的硬性规定。比如，iOS消费者只能选择宝马，或者只有Andorid用户才能驾驶奥迪车型等。因为家庭中的不同成员可能拥有不同的设备型号，而且他们也会时不时的购买新设备。但显而易见的是，他们绝对不会因为购买了一部新手机而换车。</p><p>　　虽然有关智能汽车操作系统的战争很有可能围绕着苹果和谷歌两大企业之间展开，但汽车厂商却不会从一而终，因为他们都希望自己的车辆能够同尽可能多的设备建立连接。到目前为止，包括本田、通用和现代这些企业都已经同时成为了苹果和谷歌汽车系统阵营中的一员，且我们不认为这些厂商会对试图强制自己“选定阵营”的企图放弃抵抗。在另一方面，虽然为所有设备建立一个统一的汽车界面标准并非难事，但这一设想恐怕还不会在短期内成为现实。</p><p>　　未来远景</p><p>　　从目前的情况来看，苹果和谷歌的目标并不仅仅是占领汽车消费者的车载信息、娱乐系统这么简单，它们希望能够帮助驾驶者建立一个更为先进的自动汽车实时管理系统。换句话说就是，苹果和谷歌希望建立一个围绕汽车的物联网，并最终使车辆达到更安全、燃油经济性更高，且使驾驶者感到更加轻松的目标。要做到这一点的话，这两家公司就首先需要建立一个可以同其他车辆以及外部车流管理系统进行互动、允许车辆检测到其他车辆出现，同时尽可能避免事故发生的机制。</p><p>　　如果以上设想能够在苹果和谷歌的努力下最终成为现实的话，未来的驾驶员或将可以十分惬意的在行驶途中看电影、浏览Facebook更新、甚至闭上眼睛休息。</p><p></p>', '苹果和谷歌希望建立一个围绕汽车的物联网，未来的驾驶员或将可以十分惬意的在行驶途中看电影、浏览Facebook更新、甚至闭上眼睛休息。', '1396246391', '1', '1396246391', '1', '0');
INSERT INTO `t_news` VALUES ('13', '豌豆荚发布应用内搜索技术协议', '', '', '', '<p>　　腾讯科技讯（相欣）3月27日消息，今天豌豆荚正式发布了应用内搜索技术协议，该协议提供了对于应用内内容的检索、收录和调起的标准，并支持移动独有内容。同时，豌豆荚开发者中心同步上线应用内搜索接入申请入口。</p><p>　　豌豆荚产品设计副总裁刘亚平表示，在未来豌豆荚将会加快整合各类移动应用的内容资源，为用户带来更好的手机娱乐搜索体验，并将用户和流量直接导到开发者的产品中，为开发者带来收益。</p><p>　　今年1月，豌豆荚发布了移动内容搜索战略及全新的4.0版本，将搜索扩展到应用、游戏、视频、电子书、壁纸等多个娱乐内容类别，并提出移动搜索的 3 大标准：全面准确、直达行动和情景化。</p><p>　　据了解，发布至今，豌豆荚在应用、游戏品类之外的新增内容品类用户已经超过6000 万，内容消费超过 8 亿次。而这些品类的内容全部凭借应用内搜索、索引自优酷、搜狐视频、掌阅、爱阅读等20余款第三方应用内。目前豌豆荚收录了195万部视频、198万本电子书、248万张壁纸。</p><p>　　刘亚平透露，自应用内搜索技术在豌豆荚视频搜索中首次落地以来，带给第三方应用的直接调起和新用户量均已达到千万量级。</p><p>　　应用内搜索技术协议规定了应用内内容的检索、收录和应用调起的标准，开发者只需通过三个步骤即可接入豌豆荚：描述应用内内容；向豌豆荚提交内容信息，使应用支持外部调起。</p><p>　　与近期 Google 发布的App Indexing 协议及Quixey发布的App URL不同，豌豆荚的应用内搜索技术协议在兼容这两种标准的同时，提供不需要应用与网页绑定的路径、全面支持移动端独有内容的接入。</p><p>　　“我们希望协议更具普适性。因为有很多优秀的移动应用是诞生在移动时代，它们的内容都存在于应用内，并没有与之配套的网站，比如饭本和大众点评的对比。我们希望能够全面接入这些移动的独有内容。”豌豆荚搜索平台技术负责人李大海谈到。</p><p>　　李大海还强调，豌豆荚在“应用内搜索”领域的产品化经验将确保开发者通过豌豆荚持续获得用户和流量；而豌豆荚作为独立平台，将始终保证搜索和推荐结果公正公平、完全依照内容质量和用户使用数据提供，与开发者共同打造开放、共赢的移动内容搜索平台。</p><p></p>', '新协议支持移动独有内容，将用户和流量直接导到开发者的产品中，为开发者带来收益。', '1396246450', '1', '1475759935', '1', '1');
INSERT INTO `t_news` VALUES ('14', '久邦数码总裁张向东：移动互联网竞争已白热化', '', '', '', '<p>　　久邦数码（纳斯达克：GOMO）今天发布的财报显示，第四季度营收9890万元，同比增长63.5%；净利润3080万元，同比增76.4%。</p><p>　　其中，GO系列应用为主的移动应用产品和服务营收占比超50%，这一增长主要是由于GO系列产品相关营销收入增407.6%，及来自付费下载收入增长97.7%带动。</p><p>　　久邦数码总裁张向东(微博)接受腾讯科技采访时表示，GO桌面的收入分为三部分——用户直接付费；广告联盟；直客广告。到目前为止，这三个部分收入占比大约是1:1:1。其中，GO桌面是入口产品，在不破坏用户体验，利用展示位置来获得收入。分发是GO桌面帮助开发者获得用户，分发占GO系列应用30%左右。</p><p>　　截止第四季度，GO桌面全球用户总数突破2.69亿，其中海外用户数达7成，美国、韩国分列第一、二名。根据久邦数码的规划，下一个阶段GO桌面可能变成平台式产品，会尝试与第三方游戏厂商联合运营游戏，和电子商务公司进行销售分成，或尝试做其他分发。增值服务是在免费基础上推出的模式，未来也会成为重要收入来源。</p><p>　　当前，久邦数码上市的最大概念是其GO系列在海外成功运营，久邦数码旗下产品，尤其是GO系列在国内并未获得如海外般影响力，当前其70%的用户都在海外。久邦数码当前产品的研发也以海外优先为主，张向东指出，相比海外市场，国内市场存在过度竞争。</p><p>　　中国人使用手机比国外更频繁</p><p>　　作为一家在海外运营更成功的中国公司，张向东对中外互联网竞争有着不一样的理解。张向东表示，外国人一般吃饭时不会把手机放在桌子上，吃饭时也很少看手机，很多餐厅也不允许客户吃饭时接电话，一般在走道打电话。而很多时候中国人见面很多时候是低头玩手机。</p><p>　　“有人说微博使用频次在下降，我认为到现在为止下降之后才有点正常，才有点像Twitter，国内微博活跃度依然高于Twitter。”张向东说，大部分欧洲人和美国人都认为中国人太过于频繁使用手机。这是非常典型的，亚洲对于手机使用频次高出美国和欧洲很多。</p><p>　　中国移动(微博)互联网市场特点是成长快、频率高，但欧美市场的特点是，用户付费率高，单个用户产生价值比中国高很多。另一方面，中国移动互联网竞争已到“白热化”状态。</p><p>　　张向东说，中国市场已存在过度竞争，包括为占位、抢渠道、挖人等方面无所不用其极，相比较来说，中国市场再大，跟整个世界市场比较起来依然显得小，这使得近年来腾讯、百度、360、金山等公司也纷纷开始走出海外，久邦数码上市前能获得金山和360基石投资。</p><p>　　“我们只是比较早进入海外市场，到现在运作得还不错。在海外做生意还有个好处，那就是逻辑很简单，不需要那么多请客、吃饭、交情，只要这个模式健康，更有效率，能带来更大价值，不会靠伤害来做这些事情，相反，中国有些时候更讲人情和个人利益。”</p><p>　　中国互联网市场还有另一个弊端，即中国用户习惯使用免费互联网产品，一旦一款产品从原来免费到后来要收费，90%以上要遭遇用户抵制或有公司推出不收费的产品，甚至是倒贴钱来参与市场竞争。如果有企业尝试在自己平台上卖广告，会被认为太过于商业化。</p><p>　　对此，张向东说，互联网企业就是商业公司，商业公司当然要商业化，相比来说，美国公司会认为只要不破坏整体体验，能听取用户建议和反映，不过度干扰到用户，大家都能接受。“这些年中国互联网企业生存压力过大，使得我们心态上非常不好。”</p><p>　　收购GetJar是在美国建立桥头堡</p><p>　　今年2月，久邦数码宣布全资收购移动广告平台GetJar。此次收购之前，久邦数码与GetJar合作已久，GetJar是久邦数码在全球仅次于Google AdMob的第二大合作伙伴。</p><p>　　张向东指出，久邦数码现在最重要的价值之一，就是在移动互联网的产业格局中，所占的国际化的位置。不继续扩大国际化的优势，久邦数码的价值就会下降。</p><p>　　GetJar移动广告系统在中国以外的国际市场做得非常好，GO系列体系里也希望建立起来一个广告系统，收购GetJar可以节约一些时间的成本，降低GO系列的风险。</p><p>　　此外，收购GetJar相当于久邦数码在美国建立一个桥头堡，能够帮助公司在北美建立团队，建立产品运营，甚至将来还有技术团队。</p><p>　　谈及GetJar和GO系列如何合作时，张向东说，“GetJar提供的广告系统是产品运营商业化的分享，GetJar网络系统、大数据系统和整个北美团队能让GO商业化成长速度非常快。”</p><p>　　此前，久邦数码官方表示，以530万美元现金和受对赌协议约束的约500万美元股票价格，全资收购GetJar，获得一个成熟稳定的美国本土分公司、可以继续挖掘广告客户、及迫切需要的移动数据分析技术。为GO系列应用从入口模式向平台模式进化，奠定基础。</p><p>　　海外生存法则与国内差异大</p><p>　　当前在国内市场上，360手机助手、91无线、豌豆荚、百度手机助手等在分发市场均占有一席之地，不过，由于政策原因，海内外分发存在较大差异性。</p><p>　　张向东说，国内的分发从本质上是替代了Google Play。在海外市场还没有企业敢于冒犯谷歌(微博)这一点，谷歌虽然对开发者非常开放，但有3件事情开发者不能做：</p><p>　　1，应用不能在谷歌生态里引导用户变成自己的搜索引擎。比如说桌面，默认的搜索引擎是别的搜索引擎，就有问题。但是谷歌很开放，允许用户自己这样做，如用户不喜欢谷歌的默认搜索引擎，换成别的搜索引擎，默认在桌面，这不会违法谷歌的规则。</p><p>　　2，分发是谷歌生态里非常重要的事情，应用所有分发要通过谷歌Play走。中国相当于把安卓给“阉割”，Play没有Store，91、360手机助手才会有Store模式。在海外市场95%都是通过谷歌Play进行下载，如果国内类似应用以当前模式涉足海外可能被下架。</p><p>　　当前GO系列的分发是在谷歌生态中的分发。如跟用户推荐产品，用户选择下载产品是到谷歌Play里下载，而非GO系列服务器上下载。</p><p>　　3，应用必须通过谷歌自己的支付系统，并非自己选择一个支付方式就可以。这也与国内很多厂商纷纷做自己的支付有很大不同。</p><p></p>', '久邦数码当前产品的研发也以海外优先为主，张向东指出，相比海外市场，国内市场存在过度竞争。', '1396246565', '1', '1475767507', '1', '1');
INSERT INTO `t_news` VALUES ('15', '解密Oculus VR：90后辍学者把公司卖了20亿美元', '#00a650', '', '', '<p>　　又是硅谷，又是辍学者，又是车库创业，Oculus VR的故事就像硅谷量产的创富神话。不同的是，这家公司2012年才依靠众筹平台浮出水面，而它的创始人Palmer Luckey年仅21岁。</p><p>　　Facebook今天公布，已经就收购沉浸式虚拟现实技术厂商Oculus VR达成了最终协议。交易总额约为20亿美元，这其中包括4亿美元的现金，以及2.31亿股Facebook普通股票。</p><p>　　Palmer Luckey成了硅谷亿万富翁俱乐部里的最新最小的成员，而他带领的Oculus VR团队仅有80人左右。</p><p>　　众筹起家 游戏开路</p><p>　　Oculus创始人Palmer Luckey是一名90后，根据资料显示，他的出身并非大富之家，15岁左右就进入社区大学学习，后来在加州州立大学长滩分校攻读新闻学学位。也就是在加州州立大学期间，他对游戏和相关电子知识产生浓厚的兴趣，最后选择辍学，创立Oculus。</p><p>　　Oculus成立之初，Palmer Luckey一个人负责所有工作，直到另两位游戏行业内的高管Brendan Iribe和Mike Antonov加入。此后，Mike担任公司首席软件架构师，Brendan担任公司首席执行官，而Palmer Luckey放下管理，彻底专注在虚拟现实头盔上的产品上。</p><p>　　2012年8月1日，Oculus Rift被Oculus 公司摆上众筹平台Kickstarter的货架，这款虚拟现实头盔 Oculus Rift是一款专门用来玩虚拟现实游戏的外设，它的众筹宣言就是要“从此彻底改变玩家对游戏的了解”。</p><p>　　在经过1个月的融资之后，Oculus就获得了9522名消费者的支持，收获243万美元众筹资金，顺利进入开发、生产阶段。这一金额与团队预想的25万美金超出近10倍。2013年9月，Oculus Rift游戏头盔E3大展上获得了“年度最佳游戏硬件”的提名。</p><p>　　1年之后，Oculus成功推出首批硬件产品。2013年8月份，首批Oculus Rift虚拟现实头盔发货。最低价的虚拟现实头盔Oculus Rift限量版为275美元（约合人民币1700元），普通版本为300美元。</p><p>　　在发售硬件的同时，Oculus和Unity、Epic Game、Valve等公司展开合作，SDK开发包放出后，每天都有十数款新的游戏或Demo支持Oculus Rift。在当时来看，不论是SDK的稳定性，还是开发的上手易用性，Oculus VR的产品在软硬件上都交出了高于公众预期的成绩单。</p><p>　　2013年6月，Oculus VR获得A轮融资1600万美元，投资方包括美国经纬和Spark Capital等。当年8月，有着“第一人称射击游戏之父”的John Carmack加入Oculus Rift任CTO。</p><p>　　John Carmack作为游戏界的教父级人物，是id Software 的联合创始人之一，对3D 加速技术的贡献无人能及，代表作有 Quake、Doom 系列和 Wolfenstein3D 等。在他加盟之前，John一直是VR技术的支持者。在Oculus Rift还处于原型阶段时，他就参与在硬件层面让 Doom 3 支持Oculus Rift。</p><p>　　2013年底再次获得7500万美元的B轮融资，领投方为Oculus VR的天使投资方A16Z。此轮融资之后，A16Z 的创始人Mark Andreessen也加入了Oculus VR的董事会。</p><p>　　沉浸体验+可穿戴=？</p><p>　　虚拟现实游戏是电子游戏的一种分支，它利用头盔显示器将用户对外界的视觉、听觉封闭，引导其产生一种身在虚拟环境中的感觉。其显示原理是左右眼屏幕分别显示左右眼的图像，人眼获取这种带有差异的信息后在脑海中产生立体感。</p><p>　　头盔显示器作为虚拟现实的显示设备，具有小巧和封闭性强的特点，在军事训练、虚拟驾驶和虚拟城市等项目中具有广泛的应用。但是在消费级市场上，一直没有特别好的产品出现，尽管索尼和其他厂商都曾针对这一市场推出过产品，但均未能引起反响。</p><p>　　在Oculus Rift出现之前，这类外设的价格非常高昂，平均价格在2万美元左右，主要用于科研或军事训练，并不是为电脑游戏设计的。尽管人们对VR设备有种种设想，但实际发展速度受到很多因素的制约：</p><p>　　第一是价格高，几年前，索尼的HMZT1虚拟现实设备卖799美元，在Oculus Rift 出现之前，大多数虚拟现实设备受制于高价无法得到广泛的应用。第二是硬件条件比较差，显示设备的分辨率很低、过于笨重，在游戏、软件方面，大多数开发者不熟悉如何使用运动感知元件。</p><p>　　这几年，由于硬件技术的飞速发展，最终令 Oculus Rift 可以做到支持高分辨率（1080P），并将价格控制在 299 美元这个大多数普通人都可以接受的价位。同时，Oculus Rift也赶上了智能手机和平板电脑大普及大爆发的时候。经过手机和平板的普及，很多游戏开发者已经懂得如何使用三轴加速计和三轴陀螺仪这样的运动感知元件，再转战Oculus Rift等新一代智能硬件就得心应手了。</p><p>　　总总因素利好之下，Oculus VR成功用低成本的解决方案激活了这一市场，当这一技术与游戏结合后，影响力更大，因为这意味着未来游戏行业将有一场巨变，因为体验越真实或越精彩，游戏（或引擎、主机、平台）的成就就越高。</p><p>　　Oculus VR的未来</p><p>　　Oculus Rift的核心硬件架构非常简单：一个平面LCD显示器、一套镜片、一个电子陀螺仪。核心技术仅在于镜片之于屏幕的结构和软件SDK。这意味着在这一领域将面临更多的竞争对手和挑战。</p><p>　　Kopin公司就是Oculus VR强有力的对手之一，这家公司是美国军方头戴显示系统的主要供应商之一，其虚拟现实游戏头盔Trimersion无论从专利储备还是行业经验和资源，都非常丰富。</p><p>　　索尼公司也是VR眼睛类产品最早的切入者之一，甚至同时出现了2个以上的部门开发不同的产品，前几天刚刚公布的PS4 Project Morpheus就和之前的头戴式3D显示器分属不同的开发团队。</p><p>　　现在PS4 Project Morpheus已经能够达到1080p分辨率，视野则达到90度。在动态感应部分，则融合了PlayStation Move体感控制器与PlayStation 4专用DualShock 4手柄控制器的技术。</p><p>　　好在Oculus VR自己也意识到了这一问题，正如领投方A16Z的创始人Mark Andreessen在加入Oculus VR的董事会后所说的，Oculus不单会革新游戏体验，同时在教育、电影、设计和建筑等方面都有很大的潜力。</p><p>　　在被Facebook收购后，Facebook希望将Oculus在游戏领域中的现有优势扩大至新的垂直领域，如通信、媒体和娱乐、教育及其他领域等，甚至有机会成为下一代社交和通信平台。</p><p></p>', 'Oculus创始人Palmer Luckey是一名90后，如今他成了硅谷亿万富翁俱乐部里的最新最小的成员。', '1396246616', '1', '1475767507', '1', '1');
INSERT INTO `t_news` VALUES ('16', '微软要让Windows Phone成为中国手游一线战场', '#00a650', '', '', '<p>　　坐在旧金山Westin酒店的会议室中，面对微软大中华区副总裁兼市场战略部总经理谢恩伟与其他國內手游厂商与合作伙伴，手游公司完美世界副总裁张云帆(微博)提出了一个大家心中的疑问：“微软的Windows会妥协，会坚持Windows Phone的系统吗？”</p><p><img src=\"/xyhcms2/uploads/img1/201403/53391ad0dbbbc.jpg\"/></p><p>　　张云帆的顾虑不是没有道理。目前全球手机操作系统市占率排名第三的Windows Phone，虽然仍与Android、苹果iOS两大龙头的差距甚远，但新CEO萨提亚．纳德拉（Satya Nadella）上任后抛出”移动优先，云计算优先”的口号，加上强推”服务加设备”的战略。微软想跨平台的企图心越来越强，也更将业务重心放在设备上。</p><p>　　会不会哪一天微软为了想卖出更多设备，两手一摊，就放弃了这个操作系统？张云帆点出了手游厂商的顾虑，” 对于开发公司来说，要投入的话，就会犹豫，万一哪天Windows说我不玩了，我们Office卖得非常好，比如苹果上的前十是来自于Office，这是很有可能的，也许就不用一定要坚持那个系统。但是对于所有跟着进来玩的小伙伴们就很苦了。”</p><p>　　微软大中华区副总裁兼市场战略部总经理谢恩伟解释，微软内部有两个非常核心的平台，一个平台是桌面平台或者客户端平台，那就是Windows，它的走向更多的是把跨手机、跨平板、跨Xbox的一些核心的操作系统作更好的整合。</p><p>　　另外一个在线的平台Windows Azure微软也会加强力度。谢恩伟说，他反而觉得，终端有越来越多的Windows平台，Windows Azure这个平台在后台上能做更好的整合。”这两个平台从微软的角度来说，肯定会坚持，起码在我这个层面上去看的话，没有感觉到是要放弃这样一个点，”谢恩伟说。</p><p>　　他同时也澄清，微软不会放弃高端市场，因为本来微软做的生意就是以量取胜。谢恩伟认为按照用户的不同用途，会用不同价格做市场区隔，他以Windows作为一个案例说明。”如果去看现在的桌面机或者笔记本，要做高端，真正玩游戏的，的确是非常高端的这种机子；要做平常使用的，有可能是一些低端的机子，肯定会有这样的策略，因为从量的角度，必须要有不同的价位。”</p><p>　　他强调微软绝对不会放弃高端市场，”从Xbox，甚至我们自家的Surface，到Lumia1520，高端的机肯定会有，更多的是通过这些设备的价格差异或者配置差异，有可能给一些游戏的开发者或者应用开发者，任何的开发者，也会在他的游戏或者创意里制造出更多的不同点，有可能你使用的一些商业模式，广告的商业模式或者支付的商业模式，会按照价位的不同点，而有一定程度的差异。”</p><p>　　谢恩伟强调，在中国的手游市场，Windows Phone相较于iOS与Android来说，由于竞争较小，更容易被用户发现，同时在营利能力上，已经与中国移动(微博)和中国联通(微博)相继达成协议，透过运营商短信支付以及第三方支付平台，帮助开发者更顺畅地实现在线支付功能。同时也加强与跨平台游戏引擎，如Unity 3D和cocos2dx等公司合作，希望帮助开发者实现跨平台开发。</p><p>　　微软的Xbox将进入中国，谢恩伟在这个节点上并不愿多提。许多游戏开发者却已经跃跃欲试。Unity大中华区的CEO符国新看到的趋势是，全亚洲在游戏机上开发的游戏已有超过50%，都是采用Unity作为游戏引擎。连他自己也感到惊讶，因为传统的游戏机是用竞争对手的引擎。他分析，因为现在跨平台的趋势，开发游戏是既开发游戏机，又要到PC，到手机上，因此开发者需要的是一条龙服务。</p><p>　　微软在桌面、平板与手机等跨平台加强力度，会不会加快Windows Phone市占增长率？完美世界的张云帆很直白地点出选择踏入Windows的理由：”无论是先进还是后进，得熬十年、二十年，微软是属于反正我不会倒，我肯定会坚持下去。”</p><p><br/></p>', '在中国的手游市场，WP占比较小，由于竞争较小更容易被用户发现。', '1396246685', '1', '1475827743', '1', '1');
INSERT INTO `t_news` VALUES ('29', 'aaa', '', '', '', '', '', '1475827799', '1', '1475827804', '1', '1');
INSERT INTO `t_news` VALUES ('30', 'sssss', '#f7977a', '', '', '<p>sssssssssss<img src=\"/cms/uploads/img/201610/57f1b8030f295.png\"/></p>', '', '1475828062', '1', '1475828076', '1', '1');
INSERT INTO `t_news` VALUES ('31', 'afasfasfasf', '', '', '', '', '', '1476432379', '1', '1476432397', '1', '1');
INSERT INTO `t_news` VALUES ('32', 'safafdafdsa阿德发放', '', '', '', '', '', '1476538752', '1', '1476538775', '1', '1');
INSERT INTO `t_news` VALUES ('33', 'adfd第三方', '#fff799', '第三方', '似懂非懂', '<p>的说法都是</p>', '水电费', '1507875600', '1', '1509171648', '1', '1');
INSERT INTO `t_news` VALUES ('34', '发顺丰', '#fff799', '', '大师傅', '<p>的萨法第三方第三方第三方大师傅多撒</p>', '第三方多三', '1507270860', '1', '1509171702', '1', '1');
INSERT INTO `t_news` VALUES ('35', '大师傅', '#37b44a', '', '多撒', '<p>啊士大夫大师傅</p><table><tbody><tr class=\"firstRow\"><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">订单</td><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">的</td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td></tr><tr><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">的</td><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">ad</td><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">的</td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td></tr><tr><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">的</td><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">地方</td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td></tr><tr><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\" style=\"word-break: break-all;\">似懂非懂</td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td></tr><tr><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td><td width=\"95\" valign=\"top\"><br/></td></tr></tbody></table><p>大大</p>', '大师傅', '1507357320', '0', '1509171758', '1', '1');
INSERT INTO `t_news` VALUES ('36', '大师傅得得得', '#fbaf5a', '的', '的', '<p>的说法都是<img src=\"/Report/uploads/image/20171028/1509171722684065941.png\" alt=\"1509171722684065941.png\"/></p>', '大师傅', '1507875780', '1', '1509171818', '1', '1');
INSERT INTO `t_news` VALUES ('37', 'sdf', '#fff467', '的说法都是', 'dsf', '<p>第三方第三方第三方的说法都是似懂非懂</p><p>水电费</p><p>大师傅</p><p>水电费</p><p>是的范德萨范德萨</p><p>大师傅大师傅<img src=\"/Report/uploads/image/20171028/1509172239421035878.png\" title=\"1509172239421035878.png\" alt=\"logo.png\"/></p>', '胜多负少的', '1508394600', '1', '1509172245', '1', '1');
INSERT INTO `t_news` VALUES ('38', '订单', '', '', '', '', '', '0', '0', '1509173492', '1', '1');
INSERT INTO `t_news` VALUES ('40', 'dasf', '', '', '', '<p>dsf</p>', '', null, '1', '1509174146', '1', '1');
INSERT INTO `t_news` VALUES ('41', 'sdf', '#0ff', '', '', '', '', null, '1', '1509175670', '1', '1');
INSERT INTO `t_news` VALUES ('42', 'adsf', '', '', '', '', '', '1509002940', '1', '1509175778', '1', '1');
INSERT INTO `t_news` VALUES ('43', '顶顶顶顶的的发生的的', '#0f0', '的顶顶顶顶顶', '大师傅订单', '<p>撒地方的萨芬的的说法都是水电费水电费</p><p>撒地方的萨芬是的范德萨</p><p>水电费是<img src=\"/Report/uploads/image/20171028/1509179987431032321.png\" title=\"1509179987431032321.png\" alt=\"logo.png\"/></p>', '大师傅大师傅大师傅毒贩夫妇', '1506757080', '1', '1509179990', '1', '1');
INSERT INTO `t_news` VALUES ('44', '双方都三伏', '#00aeef', '水电费是2', '大师傅', '<p>是打发第三方</p><p><table><tbody><tr class=\"firstRow\"><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">水电费</td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td></tr><tr><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">大师傅</td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">的</td><td width=\"43\" valign=\"top\"><br/></td></tr><tr><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">速度</td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">多少</td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td></tr><tr><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">水电费</td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td></tr><tr><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\" style=\"word-break: break-all;\">多少</td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td></tr><tr><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td><td width=\"43\" valign=\"top\"><br/></td></tr></tbody></table><br/></p><p><img src=\"/Report/uploads/image/20171028/1509180646973082122.png\" title=\"1509180646973082122.png\" alt=\"logo.png\"/></p><p>水电费大师傅</p><p><br/></p><p>大师傅</p><p>多少</p><p></p><p>2222</p><p><br/></p>', '大师傅多撒范德萨发的', '1509180540', '1', '1509180660', '1', '1');
INSERT INTO `t_news` VALUES ('45', '阿道夫', '', '大师傅', '大师傅', '<p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:9005/Report/manage/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/Report/uploads/file/20171028/1509180928754021241.txt\" title=\"1111.txt\">1111.txt</a></p><p>范德萨发<br/></p>', '大师傅', '1509180840', '1', '1509180999', '1', '1');
INSERT INTO `t_news` VALUES ('46', 'fds ', '', '', '', '', '', null, '1', '1509248651', '1', '1');
INSERT INTO `t_news` VALUES ('47', 'dsfd', '', '', '', '', '', null, '1', '1509248794', '1', '1');
INSERT INTO `t_news` VALUES ('48', 'sdfds', '', '', '', '<p>sdf<br/></p>', '', '1509248820', '1', '1509248890', '1', '1');
INSERT INTO `t_news` VALUES ('49', 'adsfds', '#a4d49d', '', '', '<p>adfdsafadsfdsafadsf<br style=\"text-align: left;\"/></p><p style=\"display:none;\" data-background=\"background-repeat:no-repeat; background-position:center center; background-color:#8DB3E2;\"><br/></p>', 'dasfds', '1508560320', '1', '1509251599', '1', '1');
INSERT INTO `t_news` VALUES ('50', '阿德是非得失', '', '', '', '<p>啊士大夫大师傅</p><p style=\"display:none;\" data-background=\"background-repeat:no-repeat; background-position:center center; background-color:#8DB3E2;\"><br/></p>', '', '1509252060', '1', '1509252101', '1', '1');
INSERT INTO `t_news` VALUES ('51', '大师傅', '', '', '', '<p>爱的色放单锁</p><p style=\"display:none;\" data-background=\"background-repeat:no-repeat; background-position:center center; background-color:#D8D8D8;\"><br/></p>', '', '1509252120', '1', '1509252147', '1', '1');

-- ----------------------------
-- Table structure for `t_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `updatetime` int(10) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `userid` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('9', '<p>阿的飞洒地方</p><p>大丰收大是非得失</p><p>的撒范德萨范德萨范德萨</p><p>胜多负少大丰收大发的撒范德萨范德萨发送到</p><p><img src=\"/Report/uploads/image/20171101/1509504343769023219.jpg\" title=\"1509504343769023219.jpg\" alt=\"QQ图片20170925180334.jpg\"/></p>', '1509504346', '1');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `roletype` tinyint(1) DEFAULT '0',
  `isvalid` tinyint(1) unsigned DEFAULT '1',
  `isdisabled` tinyint(1) DEFAULT '0',
  `updatetime` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `status` (`isvalid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '超级管理员', '9', '1', '0', null);
INSERT INTO `t_role` VALUES ('2', '测试角色11', '啊地方的萨芬的萨法的啊的说法的萨芬222', '0', '1', '0', '1478339421');
INSERT INTO `t_role` VALUES ('3', '顶顶顶顶222', '第三方第三方第三方333333', '0', '0', '0', '1509461633');
INSERT INTO `t_role` VALUES ('4', '测试岗位', '222', '0', '1', '0', null);

-- ----------------------------
-- Table structure for `t_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user` (
  `roleid` int(10) unsigned DEFAULT NULL,
  `userid` int(10) DEFAULT NULL,
  KEY `group_id` (`roleid`),
  KEY `user_id` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_user
-- ----------------------------
INSERT INTO `t_role_user` VALUES ('1', '1');
INSERT INTO `t_role_user` VALUES ('1', '3');
INSERT INTO `t_role_user` VALUES ('1', '2');
INSERT INTO `t_role_user` VALUES ('1', '4');
INSERT INTO `t_role_user` VALUES ('1', '5');
INSERT INTO `t_role_user` VALUES ('1', '6');
INSERT INTO `t_role_user` VALUES ('2', '7');

-- ----------------------------
-- Table structure for `t_siteconfig`
-- ----------------------------
DROP TABLE IF EXISTS `t_siteconfig`;
CREATE TABLE `t_siteconfig` (
  `cfg_webname` varchar(100) DEFAULT NULL COMMENT '网站名称',
  `cfg_webtitle` varchar(100) DEFAULT NULL COMMENT '主题样式',
  `cfg_themestyle` varchar(100) DEFAULT NULL COMMENT '主题样式',
  `cfg_keywords` varchar(200) DEFAULT NULL COMMENT '站点关键词',
  `cfg_description` varchar(200) DEFAULT NULL COMMENT '站点描述',
  `cfg_powerby` varchar(200) DEFAULT NULL COMMENT '网站版权信息',
  `cfg_recordno` varchar(200) DEFAULT NULL COMMENT '网站备案号',
  `cfg_address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `cfg_phone` varchar(200) DEFAULT NULL COMMENT '联系电话',
  `cfg_qq` varchar(200) DEFAULT NULL COMMENT '客服QQ',
  `cfg_email` varchar(200) DEFAULT NULL COMMENT '客服邮箱',
  `cfg_website_close` tinyint(1) DEFAULT NULL COMMENT '关闭网站',
  `cfg_website_close_info` varchar(200) DEFAULT NULL COMMENT '关站提示'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站参数';

-- ----------------------------
-- Records of t_siteconfig
-- ----------------------------
INSERT INTO `t_siteconfig` VALUES ('我的网站22334', '我的网站11133', null, '我的网站1133', '我的网站1113', 'Copyright © 2009 - 2016 HCH. All Rights Reserved113', '12121233', '石家庄市新华区113', '15176190900113', '584059628113', 'hechiheng@qq.com113', '0', '站点维护中，请稍等一会...11133');

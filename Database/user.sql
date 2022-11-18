/*
MySQL Data Transfer
Source Host: localhost
Source Database: ehealthcare
Target Host: localhost
Target Database: ehealthcare
Date: 26-01-2022 15:09:04
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `utype` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'abcc', 'abcc', '111', 'Doctor');
INSERT INTO `user` VALUES ('3', 'aaa', 'a', '123', 'Receptionist');
INSERT INTO `user` VALUES ('4', 'aaaa', 'a', '123456', 'Receptionist');
INSERT INTO `user` VALUES ('5', 'def', 'def', '111', 'Receptionist');
INSERT INTO `user` VALUES ('6', 'xyz', 'xyz', '111', 'Pharmacist');
INSERT INTO `user` VALUES ('7', 'John', 'John', '123', 'Doctor');
INSERT INTO `user` VALUES ('8', 'Ram', 'Ram', '123', 'Pharmacist');
INSERT INTO `user` VALUES ('9', 'Sita', 'Sita', '123', 'Receptionist');
INSERT INTO `user` VALUES ('13', 'abc', 'abc', '123', 'Pharmacist');
INSERT INTO `user` VALUES ('14', 'def', 'def', '123', 'Pharmacist');
INSERT INTO `user` VALUES ('15', 'xyz', 'xyz', '123', 'Pharmacist');
INSERT INTO `user` VALUES ('16', 'prs', 'prs', '123', 'Pharmacist');

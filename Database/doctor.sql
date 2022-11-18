/*
MySQL Data Transfer
Source Host: localhost
Source Database: ehealthcare
Target Host: localhost
Target Database: ehealthcare
Date: 26-01-2022 15:07:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorno` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `special` varchar(255) NOT NULL,
  `qualification` varchar(255) NOT NULL,
  `channelfee` int(11) NOT NULL,
  `phone` int(11) NOT NULL,
  `room` int(11) NOT NULL,
  `log_id` int(11) NOT NULL,
  PRIMARY KEY  (`doctorno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `doctor` VALUES ('DS001', 'John', 'DS001', 'John', '123', '1234567890', '2', '2');
INSERT INTO `doctor` VALUES ('DS002', 'abc', 'DS002', 'abc', '123', '1234', '1', '2');
INSERT INTO `doctor` VALUES ('DS003', 'John', 'Neurologist', 'MBBS,MD', '800', '1234567890', '2', '7');

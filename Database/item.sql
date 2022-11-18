/*
MySQL Data Transfer
Source Host: localhost
Source Database: ehealthcare
Target Host: localhost
Target Database: ehealthcare
Date: 26-01-2022 15:08:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemid` varchar(255) NOT NULL,
  `itemname` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY  (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `item` VALUES ('IU001', 'Dolo ', 'Tablet', '50', '3');
INSERT INTO `item` VALUES ('IU002', 'Bresol', 'Syrup', '80', '1');

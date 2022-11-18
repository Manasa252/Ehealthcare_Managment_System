/*
MySQL Data Transfer
Source Host: localhost
Source Database: ehealthcare
Target Host: localhost
Target Database: ehealthcare
Date: 26-01-2022 15:08:58
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patientno` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY  (`patientno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `patient` VALUES ('PS001', 'Ravi', '1234567899', 'JP Nagar,Bangalore');
INSERT INTO `patient` VALUES ('PS002', 'Anand', '1234567890', 'Mangalore');
INSERT INTO `patient` VALUES ('PS003', 'Chaitra', '1234567890', 'Mysore');

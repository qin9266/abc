DROP DATABASE IF EXISTS jiaowu ;
CREATE DATABASE jiaowu CHARACTER SET utf8;
use jiaowu ;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO `admin` VALUES ('admin', '123456');


DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cno`) USING BTREE,
  INDEX `class_ibfk_1`(`tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO `course` VALUES ('001', '数据库', '20110101', '仇老师', '3');
INSERT INTO `course` VALUES ('002', '计算机网络', '20024106', '张老师', '4.5');

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `exam_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `property` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `get_credit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `GPA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credit_GPA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`, `cno`) USING BTREE,
  INDEX `score_ibfk_2`(`cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO score(sno, sname, cno, cname, credit, type, exam_method, property, grade, get_credit, GPA, gredit_GPA, note, tno)
VALUES
('2020200094', '秦德霖', '001', '数据库', 4, '专业限选课', '考查', '初修', 92, 3, 3.7, 14.8, NULL, '20110101'),
('2020200094', '秦德霖', '002', '计算机网络', 4, '专业课/必修课', '考试', '初修', 84, 4.5, 3.4, 13.6, NULL, '20024106'),
('2020200094', '秦德霖', '003', '概率论', 3, '公共课/必修课', '考试', '初修', 83, 3, 3.3, 9.9, NULL, NULL),
('2020200094', '秦德霖', '005', '软件工程', 3, '专业课/必修课', '考查', '初修', 81, 3, 3.1, 9.3, NULL, NULL),
('2020200094', '秦德霖', '006', 'Web前端开发', 3, '专业课/必修课', '考查', '初修', 90, 3, 4, 12, NULL, NULL),
('2020200094', '秦德霖', '007', '高等数学', 4, '课程设计', NULL, '初修', 1, 3.5, 3.5, NULL, NULL, NULL),
('2020200094', '秦德霖', '008', '操作系统课程设计', 1, '课程设计', NULL, '初修', 70, 1, 2, 2, NULL, NULL),
('2020200094', '秦德霖', '010', '物联网', 4, '专业课/必修课', '考试', '初修', 90, 4, 4, 16, NULL, NULL),
('2020200094', '秦德霖', '011', '线性代数', 4, '公共课/必修课', '考试', '初修', 90, 4, 4, 4, NULL, NULL),
('2021203939', '李凌云', '002', '计算机网络', 4, '专业课/必修课', '考试', '初修', 80, 4.5, 3.2, 12.8, NULL, '20024106'),
('2021204310', '宋健', '001', '数据库', 4, '专业限选课', '考查', '初修', 1, 3, 3.6, 12, NULL, '20110101');


DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO student (sno, sname, password, sex, major, department, sclass)
VALUES
('2020200094', '秦德霖', '123456', '男', '软件工程', '计算机学院', '软件03'),
('2021203939', '李凌云', '123456', '男', '软件工程', '计算机学院', '软件03'),
('2021204310', '宋健', '123456', '男', '软件工程', '计算机学院', '软件03'),
('2021204369', '杨泽绪', '123456', '男', '软件工程', '计算机学院', '软件03');

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `degree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO teacher (tno, tname, password, sex, department, degree, title)
VALUES
('20003001', '邹澜', '123456', '女', '计算机学院', '博士', '讲师'),
('20024106', '张老师', '123456', '男', '计算机学院', '博士', '副教授'),
('20042301', '杜娜', '123456', '女', '计算机学院', '博士', '讲师'),
('20110101', '仇培明', '123456', '男', '计算机学院', '博士', '副教授');

SET FOREIGN_KEY_CHECKS = 1;

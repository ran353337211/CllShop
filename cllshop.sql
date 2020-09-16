/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : cllshop

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 14/09/2020 14:50:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `money` double NULL DEFAULT NULL,
  `paymoney` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `supname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, '辣条', 52, 2.5, '是', '王婆辣条', '狠辣的辣条', '2020-09-03');
INSERT INTO `bill` VALUES (2, '方便面', 100, 4, '是', '康师傅', '老坛酸菜牛肉面', '2020-09-02');
INSERT INTO `bill` VALUES (3, '乳酸菌', 9999, 2.5, '是', '哇哈哈', '全世界最好喝的乳酸菌', '2020-09-03');
INSERT INTO `bill` VALUES (4, '小面包', 66, 3, '否', '那么大有限公司', '就是小面包而已', '2020-08-25');
INSERT INTO `bill` VALUES (5, '薯片', 66, 6.5, '否', '乐事', '香香脆脆，我的最爱', '2020-09-07');
INSERT INTO `bill` VALUES (6, '程序员掉的头发', 999999, 10, '否', '小苗独家', '裹上鸡蛋液和面包糠，下锅一炸，隔壁小孩都馋哭了！', '2020-09-07');
INSERT INTO `bill` VALUES (7, '纯牛奶', 120, 3.5, '是', '伊利有限公司', '多喝牛奶长身体', '2020-09-07');
INSERT INTO `bill` VALUES (8, '鼠标', 30, 129, '否', '罗技', '给你最好的体验', '2020-09-05');
INSERT INTO `bill` VALUES (9, '陈雷雷', 1, 99999, '否', '小苗独家', '世上仅此一个！先到先得', '2020-09-05');
INSERT INTO `bill` VALUES (10, '可口可乐', 555, 2.5, '是', '可口可乐有限公司', '快乐肥仔水，快乐挡不住', '2020-09-09');
INSERT INTO `bill` VALUES (11, '耳机', 22, 199, '否', '小苗独家', '好用的一', '2020-09-10');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `notice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` bigint(20) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '小苗独家有限公司', '小苗独家，啥都能卖', '小苗', 13999999999, '四川绵阳', '1152686508@qq.com');
INSERT INTO `supplier` VALUES (2, '王婆辣条', '专为辣条而生', '王婆', 13888888888, '四川成都', '123456@qq.com');
INSERT INTO `supplier` VALUES (3, '康师傅有限公司', '瓜子花生矿泉水咯~还有泡面！', '康师傅', 13777777777, '四川成都', '15644897@qq.com');
INSERT INTO `supplier` VALUES (4, '哇哈哈有限公司', '哇哈哈呀 哇哈哈呀 小朋友们都笑开颜呀~', '小强', 13988888888, '贵州贵阳', '85498921@qq.com');
INSERT INTO `supplier` VALUES (5, '那么大有限公司', '虽然叫那么大，其实卖的东西都很小', '大大', 13299999999, '四川绵阳', '84962613@qq.com');
INSERT INTO `supplier` VALUES (6, '乐事有限公司', '不会吧不会吧，不会真有人不知道乐事吧？', '小徐', 13966666666, '四川泸州', '15489658@qq.com');
INSERT INTO `supplier` VALUES (7, '伊利有限公司', '我们不生产奶，我们只是大自然的搬运工', '小小', 13899999999, '四川绵阳', '56695621@qq.com');
INSERT INTO `supplier` VALUES (8, '罗技有限公司', '。。。', '小罗', 15666666666, '黑龙江', '9986684@qq.com');
INSERT INTO `supplier` VALUES (9, '大城小爱', '这是个啥呀', '小陈', 15988888888, '贵州贵阳', '45819657@qq.com');
INSERT INTO `supplier` VALUES (10, '可口可乐有限公司', '专为快乐而生', '小罗', 15988886666, '四川成都', '586985662@qq.com');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `tel` bigint(255) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '徐苗', '女', 18, 12345678910, '四川成都', '经理', '123456');
INSERT INTO `users` VALUES (2, '曾丽', '女', 22, 19982701531, '四川绵阳', '普通用户', '123');
INSERT INTO `users` VALUES (3, '白敬亭', '男', 26, 19982701531, '云南昆明', '普通用户', '123');
INSERT INTO `users` VALUES (4, '薛之谦', '男', 26, 19982701531, '四川德阳', '普通用户', '123');
INSERT INTO `users` VALUES (5, '小罗', '男', 24, 12333333333, '四川达州', '普通用户', '123');
INSERT INTO `users` VALUES (6, '小米', '男', 30, 12566666666, '贵州贵阳', '普通用户', '123');
INSERT INTO `users` VALUES (10, '小丁', '男', 23, 15849657777, '四川达州', '经理', '123');

SET FOREIGN_KEY_CHECKS = 1;

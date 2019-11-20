CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `permission` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限内容',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限描述',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_sys_permissions_permission` (`permission`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `sys_permission`(`id`, `permission`, `description`, `available`) VALUES (1, 'user:add', '用户添加', 1);
INSERT INTO `sys_permission`(`id`, `permission`, `description`, `available`) VALUES (2, 'user:select', '用户查询', 1);
INSERT INTO `sys_permission`(`id`, `permission`, `description`, `available`) VALUES (3, 'user:update', '用户修改', 1);
INSERT INTO `sys_permission`(`id`, `permission`, `description`, `available`) VALUES (4, 'user:delete', '用户删除', 1);

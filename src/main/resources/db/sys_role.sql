CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `pid` bigint(20) DEFAULT NULL COMMENT '父节点',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否锁定',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_sys_roles_role` (`role`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `sys_role`(`id`, `role`, `description`, `pid`, `available`) VALUES (1, 'xadmin', '超级管理员', 0, 0);
INSERT INTO `sys_role`(`id`, `role`, `description`, `pid`, `available`) VALUES (2, 'admin', '管理员', 1, 1);
INSERT INTO `sys_role`(`id`, `role`, `description`, `pid`, `available`) VALUES (3, 'user', '普通用户', 0, 1);

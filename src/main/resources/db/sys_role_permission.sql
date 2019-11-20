CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (1, 1, 1);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (2, 1, 2);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (3, 1, 3);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (4, 1, 4);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (5, 2, 1);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (6, 2, 2);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (7, 2, 3);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (8, 3, 2);
INSERT INTO `sys_role_permission`(`id`, `role_id`, `permission_id`) VALUES (9, 3, 3);

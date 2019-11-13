package com.hui.entity;

import lombok.Data;

@Data
public class SysRolePermission {
    /**
    * 编号
    */
    private Long id;

    /**
    * 角色编号
    */
    private Long roleId;

    /**
    * 权限编号
    */
    private Long permissionId;
}
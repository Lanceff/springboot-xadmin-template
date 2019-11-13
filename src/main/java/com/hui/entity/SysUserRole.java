package com.hui.entity;

import lombok.Data;

@Data
public class SysUserRole {
    /**
    * 编号
    */
    private Long id;

    /**
    * 用户编号
    */
    private Long userId;

    /**
    * 角色编号
    */
    private Long roleId;
}
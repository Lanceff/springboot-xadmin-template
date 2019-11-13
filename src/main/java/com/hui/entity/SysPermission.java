package com.hui.entity;

import lombok.Data;

@Data
public class SysPermission {
    /**
    * 编号
    */
    private Long id;

    /**
    * 权限编号
    */
    private String permission;

    /**
    * 权限描述
    */
    private String description;

    /**
    * 此权限关联角色的id
    */
    private Long rid;

    /**
    * 是否锁定
    */
    private Boolean available;
}
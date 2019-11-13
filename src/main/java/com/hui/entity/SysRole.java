package com.hui.entity;

import lombok.Data;

@Data
public class SysRole {
    /**
    * 角色编号
    */
    private Long id;

    /**
    * 角色名称
    */
    private String role;

    /**
    * 角色描述
    */
    private String description;

    /**
    * 父节点
    */
    private Long pid;

    /**
    * 是否锁定
    */
    private Boolean available;
}
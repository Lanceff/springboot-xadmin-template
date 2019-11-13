package com.hui.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUser {
    /**
     * 编号
     */
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 是否锁定
     */
    private Boolean locked;
}
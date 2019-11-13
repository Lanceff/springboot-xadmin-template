package com.hui.controller;

import com.hui.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/checkLogin")
    public String checkLogin(@Validated SysUser sysUser, BindingResult bindingResult, ModelMap modelMap) {
        //校验前端传来的变淡数据合法性
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                modelMap.addAttribute("err", fieldError.getDefaultMessage());
                return "login";
            }
        }
        //shiro校验
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
        try {
            subject.login(token);
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            modelMap.addAttribute("err", "账号不存在");
        } catch (LockedAccountException e) {
            modelMap.addAttribute("err", "账号被锁定");
        } catch (DisabledAccountException e) {
            modelMap.addAttribute("err", "账号未启用");
        } catch (IncorrectCredentialsException e) {
            modelMap.addAttribute("err", "密码错误");
        } catch (Throwable e) {
            modelMap.addAttribute("err", "未知错误:(" + e.toString() + ")");
        }
        return "login";
    }

    @RequestMapping("/loginout")
    public String logout() {
       /* Subject subject = SecurityUtils.getSubject();
        subject.logout();*/
        return "redirect:/login";
    }
}

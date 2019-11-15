package com.hui.controller;

import com.hui.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/loginout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping("/checkLogin")
    public Map checkLogin(SysUser sysUser, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
        try {
            subject.login(token);
            session.setAttribute("username", sysUser.getUsername());
            map.put("code", 200);
        } catch (UnknownAccountException e) {
            map.put("code", 300);
            //账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
            map.put("err", "账号不存在");
        } catch (LockedAccountException e) {
            map.put("code", 300);
            map.put("err", "账号被锁定");
        } catch (DisabledAccountException e) {
            map.put("code", 300);
            map.put("err", "账号未启用");
        } catch (IncorrectCredentialsException e) {
            map.put("code", 300);
            map.put("err", "密码错误");
        } catch (Throwable e) {
            map.put("code", 300);
            map.put("err", "未知错误:(" + e.toString() + ")");
        }
        return map;
    }
}

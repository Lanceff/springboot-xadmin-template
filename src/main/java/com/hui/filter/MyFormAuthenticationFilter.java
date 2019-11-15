package com.hui.filter;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 解决验证成功页面跳转原来页面(采用ajax异步提交验证信息)
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 异步判断（Ajax）
     */
    private Boolean isAjax(ServletRequest request) {
        return ("XMLHttpRequest").equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    /**
     * 验证成功处理逻辑
     *
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        if (!isAjax(request)) {
            issueSuccessRedirect(request, response);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("text/json");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 200);
            map.put("message", "校验成功");
            String resStr = JSON.toJSONString(map);
            PrintWriter out = httpServletResponse.getWriter();
            out.print(resStr);
            out.flush();
            out.close();
        }
        return false;
    }

    /**
     * 登录失败处理逻辑
     *
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        if (!isAjax(request)) {// 不是ajax请求
            setFailureAttribute(request, e);
            return true;
        }
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("text/json");

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code",300);

            PrintWriter out = httpServletResponse.getWriter();
            String message = e.getClass().getSimpleName();
            if ("IncorrectCredentialsException".equals(message)) {
                map.put("msg","密码错误");
            } else if ("UnknownAccountException".equals(message)) {
                map.put("msg","账号不存在");
            } else if ("LockedAccountException".equals(message)) {
                map.put("msg","账号被锁定");
            } else {
                map.put("msg","未知错误");
            }
            out.print(JSON.toJSONString(map));
            out.flush();
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

}


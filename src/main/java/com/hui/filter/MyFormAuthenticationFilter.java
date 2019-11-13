package com.hui.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 解决验证成功页面跳转原来页面
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        if (!StringUtils.isEmpty(getSuccessUrl())) {
            Session session = subject.getSession(false);
            if (session != null) {
                session.removeAttribute("shiroSavedRequest");
            }
        }
        return super.onLoginSuccess(token, subject, request, response);
    }
}


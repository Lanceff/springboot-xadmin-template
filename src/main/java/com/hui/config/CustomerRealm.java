package com.hui.config;

import com.hui.entity.SysPermission;
import com.hui.entity.SysRole;
import com.hui.entity.SysUser;
import com.hui.service.SysPermissionService;
import com.hui.service.SysRoleService;
import com.hui.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 权限验证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName = (String) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles = sysRoleService.selectByUserName(userName);
        for (SysRole role : roles) {
            authorizationInfo.addRole(role.getRole());
            List<SysPermission> permiss = sysPermissionService.findPermissionsByRoleId(role.getId());
            for (SysPermission perm : permiss) {
                authorizationInfo.addStringPermission(perm.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证用户
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // token是用户输入的相关信息,获取用户名
        String username = (String) authenticationToken.getPrincipal();
        // 根据用户名username从数据库查询密码password,如果查询不到返回null
        SysUser user = sysUserService.selectByUserName(username);
        /**检测是否有此用户 **/
        if (user == null) {
            throw new UnknownAccountException();//没有找到账号异常
        }
        /**检验账号是否被锁定 **/
        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException();//抛出账号锁定异常
        }
        /**AuthenticatingRealm使用CredentialsMatcher进行密码匹配**/
        if (user.getUsername()!=null && user.getPassword()!=null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), "myrealm");
            return authcInfo;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        SimpleHash hash = new Md5Hash("12345","user", 2);
        System.out.println(hash.toString());
    }
}

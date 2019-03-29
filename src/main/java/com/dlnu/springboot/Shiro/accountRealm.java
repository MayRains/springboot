package com.dlnu.springboot.Shiro;

import com.dlnu.springboot.pojo.account;
import com.dlnu.springboot.service.accountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/*自定义Realm*/
public class accountRealm extends AuthorizingRealm {
    @Autowired
    private accountService service;
    /*
     *执行授权逻辑
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = service.getRole(username);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

    /*
     * 执行认证逻辑
     * */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //编写认证逻辑
        String username = authenticationToken.getPrincipal().toString();
        account acc = service.findByName(username);
        String password = new String((char[]) authenticationToken.getCredentials());
        if (acc == null) {
            return null;
        } else {
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
            return info;
        }
    }
}

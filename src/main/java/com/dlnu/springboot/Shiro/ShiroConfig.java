package com.dlnu.springboot.Shiro;
/*
 * Shiro 配置类*/

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /*创建三个bean
     * 1.ShiroFilterFactoryBean
     * 2.DefaultWebSecurityManager
     * 3.Realm
     * */
    @Bean("accountrealm")
    public accountRealm getRealm() {
        return new accountRealm();
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("accountrealm") accountRealm accountrealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountrealm);//关联Realm
        return securityManager;

    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /*Shiro内置过滤器，可以实现权限相关的拦截器
        常用的：
        anon:无需认证（登录）可以访问
        authc:必须认证才可以访问
        user:如果受用rememberMe的功能可以访问
        perms：该资源必须得到资源权限才可以访问
        role：该资源必须得到角色权限才可以访问
        * */

        //授权过滤器

        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/delete", "roles[admin]");
        filterMap.put("/update", "authc");
        filterMap.put("/shirovalidate", "anon");
        //通配符 filterMap.put('/*'.'authc);
        factoryBean.setFilterChainDefinitionMap(filterMap);
        //修改默认的登陆界面（login.jsp）== index.html
        factoryBean.setLoginUrl("/shiroLogin");
        factoryBean.setUnauthorizedUrl("/hello");
        return factoryBean;
    }

}

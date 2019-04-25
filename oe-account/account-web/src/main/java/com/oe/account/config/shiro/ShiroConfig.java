package com.oe.account.config.shiro;

import com.oe.account.config.realm.MyRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangwj
 * @data 2019/3/29
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm getRealm() {
        return new MyRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        Map<String, String> map = new HashMap<>(2);
        map.put("/oe/admin/**", "roles[admin]");
        map.put("/oe/student/**", "roles[student]");
        map.put("/oe/teacher/**", "roles[teacher]");
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/oe/account/login");
        factoryBean.setSecurityManager(defaultWebSecurityManager());
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(getRealm());
        return defaultSecurityManager;
    }
}

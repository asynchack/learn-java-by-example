package org.example.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.scopes
 * @date 2024/3/7 08:53
 */

@Configuration
public class ScopesConfig {
    @Bean
    @Scope("singleton")
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    @Scope("prototype")
    public Person PersonPrototype() {
        return new Person();
    }

    @Bean
    @RequestScope // 2个注解的合并简写
    public HelloMessageGenerator requestScope() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScope() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope
    public HelloMessageGenerator applicationScope() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator webSocketScope() {
        return new HelloMessageGenerator();
    }

}



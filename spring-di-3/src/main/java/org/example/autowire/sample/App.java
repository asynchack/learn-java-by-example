package org.example.autowire.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bo.wang
 * @version V1.0®
 * @Package org.example.autowire.sample®
 * @date 2024/3/10 08:31
 */


@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        // 入口类，从自己读配置（configuration ，然后autoscan，scan之后再自动装配（根据autowire定义的关联关系）；还支持参数

    }
}



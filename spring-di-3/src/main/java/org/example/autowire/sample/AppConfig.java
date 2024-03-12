package org.example.autowire.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.autowire.sample
 * @date 2024/3/10 08:25
 */

@Configuration // 依赖的spring-boot-starter-test 一开始是test scope，编码阶段就不可用哦
@ComponentScan("org.example.autowire.sample")
public class AppConfig {

}



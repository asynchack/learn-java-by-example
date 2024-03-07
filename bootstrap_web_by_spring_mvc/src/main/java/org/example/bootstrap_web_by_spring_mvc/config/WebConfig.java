package org.example.bootstrap_web_by_spring_mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.bootstrap_web_by_spring_mvc.config
 * @date 2024/2/7 07:52
 */

@Configuration
@EnableWebMvc
@Configuration(basePackages = "org.example.bootstrap_web_by_spring_mvc")
public class WebConfig {
}



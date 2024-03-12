package org.example.properteis.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.properteis.spring
 * @date 2024/3/10 12:44
 */

/*
@PropertySource({
  "classpath:persistence-${envTarget:mysql}.properties"
})
...

 */
@Configuration
@PropertySource("classpath:foo.properties") // 配置类，加上PropertySource注解，指明用哪个配置文件
@PropertySource("classpath:bar.properties")
public class BasicPropertiesWithJavaConfig {
    public BasicPropertiesWithJavaConfig() {
        super();
    }
}



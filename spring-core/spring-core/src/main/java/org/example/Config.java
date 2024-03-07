package org.example;

import org.example.domain.Address;
import org.example.domain.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example
 * @date 2024/3/6 08:35
 */

@Configuration
@ComponentScan(basePackageClasses = Company.class) // 扫描Company.class所在的包
public class Config {

    @Bean
    public Address getAddress() {
        return new Address("北京", 100);
    }
}



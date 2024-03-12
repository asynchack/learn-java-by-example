package org.example.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.annotations
 * @date 2024/3/9 08:41
 */


@Configuration
@ComponentScan(basePackages = "org.example.annotations")
@ComponentScan(basePackageClasses = VehicleFactoryConfig.class)
@ImportResource("classpath:annotations.properties")
public class VehicleFactoryConfig {

    @Bean
    public Engine engine() {
        return new Engine();
    }
}



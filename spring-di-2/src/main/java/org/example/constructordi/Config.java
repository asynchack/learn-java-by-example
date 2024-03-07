package org.example.constructordi;

import org.example.constructordi.domain.Car;
import org.example.constructordi.domain.Engine;
import org.example.constructordi.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.constructordi
 * @date 2024/3/5 08:29
 */

@Configuration
@ComponentScan("org.example.constructordi")
public class Config {

    @Bean
    public Engine engine() {
        return new Engine("v8", 5);
    }

    @Bean
    public Transmission transmission() {
        return new Transmission("sliding");
    }
}



package org.example.wiring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration
 * @date 2024/3/10 11:24
 */
@Configuration
public class ApplicationContextTestInjectName {

    @Bean
    public ArbitraryDependency yetAnotherFieldInjectDependency2() {
        ArbitraryDependency yetAnotherFieldInjectDependency =
                new YetAnotherArbitraryDependency();
        return yetAnotherFieldInjectDependency;
    }
}


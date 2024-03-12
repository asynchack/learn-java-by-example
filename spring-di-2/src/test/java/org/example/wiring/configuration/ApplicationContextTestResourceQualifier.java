package org.example.wiring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration.resource
 * @date 2024/3/10 10:27
 */


@Configuration
public class ApplicationContextTestResourceQualifier {
    @Bean(name = "defaultFile")
    public File defaultFile() {
        return new File("defaultFile.txt");
    }

    @Bean(name = "namedFile")
    public File namedFile() {
        return new File("namedFile.txt");
    }
}



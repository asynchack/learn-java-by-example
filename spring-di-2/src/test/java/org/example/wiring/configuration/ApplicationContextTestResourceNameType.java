package org.example.wiring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration.resource
 * @date 2024/3/10 10:15
 */

@Configuration
public class ApplicationContextTestResourceNameType {

    @Bean(name = "namedFile")
    public File namedFile() {
        File namedFile = new File("namedFile.txt");
        return namedFile;
    }
}



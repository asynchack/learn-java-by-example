package org.example.properteis.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.properteis.spring
 * @date 2024/3/10 16:22
 */

@Component
@ConfigurationProperties(prefix = "database")
public class Database {
    String url;
    String username;
    String password;

    // standard getters and setters
}
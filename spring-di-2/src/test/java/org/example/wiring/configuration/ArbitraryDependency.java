package org.example.wiring.configuration;

import org.springframework.stereotype.Component;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration
 * @date 2024/3/10 10:45
 */

@Component
public class ArbitraryDependency {
    private final String label = "Arbitrary Dependency";

    public String toString() {
        return label;
    }
}
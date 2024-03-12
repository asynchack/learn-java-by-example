package org.example.wiring.configuration;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration
 * @date 2024/3/10 11:24
 */
public class YetAnotherArbitraryDependency extends ArbitraryDependency {

    private final String label = "Yet Another Arbitrary Dependency";

    public String toString() {
        return label;
    }
}


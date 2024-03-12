package org.example.autowire.sample;

import org.springframework.stereotype.Component;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.autowire.sample
 * @date 2024/3/10 08:46
 */
@Component
@FormartterType("bar2")
public class Bar2Formatter implements BarFormarter{
    public String format() {
        return "bar2";
    }
}



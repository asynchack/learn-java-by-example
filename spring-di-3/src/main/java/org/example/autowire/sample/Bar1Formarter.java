package org.example.autowire.sample;

import org.springframework.stereotype.Component;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.autowire.sample
 * @date 2024/3/10 08:45
 */


@Component
@FormartterType("bar1")
public class Bar1Formarter implements BarFormarter{
    public String format() {
        return "bar1";
    }
}



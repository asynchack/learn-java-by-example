package org.example.constructordi.domain;

import org.springframework.stereotype.Component;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.constructordi.domain
 * @date 2024/3/5 08:28
 */

@Component
public class Car {
    private final Engine engine;
    private final Transmission transmission;

    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return String.format("Engine: %s, Transmission: %s", engine, transmission);
    }
}



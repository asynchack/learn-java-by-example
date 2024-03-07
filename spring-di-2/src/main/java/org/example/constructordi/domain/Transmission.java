package org.example.constructordi.domain;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.constructordi.domain
 * @date 2024/3/5 08:33
 */
public class Transmission {
    private final String type;
    public Transmission(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s", type);
    }
}



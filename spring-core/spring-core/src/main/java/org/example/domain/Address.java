package org.example.domain;

import lombok.Data;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.domain
 * @date 2024/3/6 08:30
 */

@Data
public class Address {
    private String street;
    private  int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
}



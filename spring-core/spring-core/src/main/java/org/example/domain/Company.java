package org.example.domain;

import lombok.Data;
import org.springframework.stereotype.Component;
/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.domain
 * @date 2024/3/6 08:31
 */

@Component
@Data
public class Company {
    private Address address;

    public Company (Address address){
        this.address = address;
    }
}



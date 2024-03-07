package org.example;

import org.example.domain.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example
 * @date 2024/3/6 08:38
 */


public class SpringRunner {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Company company = context.getBean(Company.class);
        System.out.println(company.toString());
    }


}



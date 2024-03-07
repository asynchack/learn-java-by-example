package org.example.constructordi;

import org.example.constructordi.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.constructordi
 * @date 2024/3/5 08:29
 */

/**
 * 构造器注入、字段注入对比：
 * 结论：优选构造器注入
 * pros：
 * 1、方便单元测试
 * 2、更符合oop思想
 * 3、封装性强
 * cons：
 * 1、如果构造器依赖的字段多，就比较繁琐，需要传入很多字段去构造一个对象
 * 字段注入
 * 1、破坏了封装性、本质靠反射api去进行的注入
 * 2、肯能不被正常初始化，导致空指针
 */
public class SpringRunner {
    public static void main(String[] args) {
        Car toyota = getCarFromJavaConfig();
        System.out.println(toyota.toString());

    }

    private static Car getCarFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        return context.getBean(Car.class);
    }
}



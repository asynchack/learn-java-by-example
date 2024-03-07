package org.example.scopes;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.scopes
 * @date 2024/3/7 08:25
 */
public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person("张三", 20);
        System.out.println(person);
        person.setName("li");
        System.out.println(person);
        System.out.println(person);
    }
}



package org.example.scopes;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.scopes
 * @date 2024/3/7 08:20
 */
public class Person {
    private String name;
    private int age;

    public Person() {}

    public Person(final String name, final int age) { // final的作用？测试是构造之后，也是可以修改的；这里的name只修饰了行参！只在构造函数调用栈期间短暂存在！TODO

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}



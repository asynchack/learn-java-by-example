package org.example.autowire.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.autowire.sample
 * @date 2024/3/10 08:35
 */


@Component
public class FooService {

    @Autowired(required = false)
    private FooDao dataAccessor;
    /*
     Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'fooService': Unsatisfied dependency expressed through field 'dataAccessor': No qualifying bean of type 'org.example.autowire.sample.FooDao' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}

     */

    @Autowired
    private FooFormarter fooFormarter2; // 自动注入，字段注入（利用反射）


    @Autowired // setter方法注入，调用该方法，向FooService注入依赖（当然，需要FooFormarter实例先创建出来）
    public void setFooFormarter(FooFormarter formarter) {
        this.fooFormarter2 = formarter;
    }


    @Autowired
    public FooService(FooFormarter formarter) {
        this.fooFormarter2 = formarter; // 构造器注入了，推荐！
    }


    // 限定优先级
    @Autowired
    @Qualifier("bar1Formarter")
    private BarFormarter barFormarter;
    /*
    Description:

Field barFormarter in org.example.autowire.sample.FooService required a single bean, but 2 were found:
	- bar1Formarter: defined in file [/Users/bo/learn/learn-java-by-example/spring-di-3/target/classes/org/example/autowire/sample/Bar1Formarter.class]
	- bar2Formatter: defined in file [/Users/bo/learn/learn-java-by-example/spring-di-3/target/classes/org/example/autowire/sample/Bar2Formatter.class]


Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
     */


    @Autowired
    @FormartterType("bar2")
    private BarFormarter barFormarter2;

}



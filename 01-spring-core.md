# construcotor injection



# bean scopes

1. application级别？跨多个context？
2. junit使用
3. import 和pom的作用
4. ​    <dependencyManagement> dependencies的作用（在类型为pom的moudle中）

# annotataion

1. compentScan 注解，配置的信息是告诉spring 从哪里扫描组件，并注册它们（通常指定顶层包目录即可，也可指定某个类，mean扫描这个类所在的包）
2. 扫描会扫描所有标记了component的类（包括compoent的包装注解；restcontroller、controller、service、repository)
3. Stereotype annotations and aop
   1. 可以方便的给某类使用了相同steretype注解的类，添加切点pointcut

```java
@Aspect
@Component
public class PerformanceAspect {
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryClassMethods() {};

    @Around("repositoryClassMethods()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) 
      throws Throwable {
        long start = System.nanoTime();
        Object returnValue = joinPoint.proceed();
        long end = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(
          "Execution of " + methodName + " took " + 
          TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return returnValue;
    }
}
```

# autowire

1. 为什么有autowire？
   1. spring需要解决2个问题：1、类的实例化；2类直接依赖的注入管理；
   2. 不管是xml、还是java 配置类，都需要提供这些元数据信息才可以让spring知道如何管理类创建、及其依赖
   3. 用了autowire只需简单注解，spring就可以知道类之间：谁依赖谁
2. SpringBootApplication注解：是configuration componentscan enableAutoConfiguration的集合
   1. 先把入口类标记为配置类（通过自己的Class对象获取自己的信息，进而获取所需要的元数据信息）
   2. 然后扫描类（约定大于配置，入口类所在包及其子包，当然也可以修改默认配置）
   3. 初始化类、自动装配类的依赖关系
3. @Autowired
   1. 字段上
   2. setter方法上
   3. 构造器上
4. 可选注入参数@Autowired（required=false）当不需要一定注入的时候（解决MissingBean异常，bean不存在，且并是不是必需时）
5. 消除歧义：@Qualifier 
   1. 一般用于注入的接口类型有多个实现时，通过该注解标记优先使用哪个实现，一般是类名
6. 自定义@Qualifier

```java
@Qualifier
@Target({
  ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FormatterType {  
    String value();
}
```

# resource inject autowired

[wiring in spring](https://www.baeldung.com/spring-annotations-resource-inject-autowire)

依赖注入的3个注解：前2个是javaee自带的；后一个是spring提供的

1. resource
2. inject
3. autowired

每个注解都可以用于：字段注入、setter注入（都可以构造器注入吗？）

不同注解的找到匹配的依赖类的路径：

resouce：

1. 优先找名称匹配的
2. 然后根据类型找
3. 然后根据Qualifier匹配

inject：

1. 优先根据类型找（一般一个类型就一个就ok；但是一个接口多个实现；一个类多个子类情况下，spring就无法确定用哪个，需要根据qualifier或者名称，进一步限定范围，直到找到唯一一个）
2. 然后根据Qualifier匹配
3. 最后根据名称找

autowired：（同inject）

1. 优先根据类型找
2. 然后根据Qualifier匹配
3. 最后根据名称找



使用场景：

1. 如果app是需要依赖接口、抽象类抽象的，优先使用inject、autowired（这2者，可以优先匹配类型，可以通过切换子类实现，更改具体行为，从而不影响上层调用接口的代码）
2. 如果app依赖具体实现，那就用resouce（靠name匹配优先，固定依赖的底层代码的行为，不受影响）
3. 只是javaee环境那就是resource和inject选
4. 只是spring框架，那就是auwowired

# qualifier

**why?**

1. autowired遇到接口有多个实现、或者父类有多个子类的时候，需要qualifier做进一步的限定

**和primary的区别**

1. primary注解，标识某个bean是被默认选择的
2. 其他需要使用其他类的地方，可以用qualiffier指定

# 注解：component、repository、service

1. compoent是代表被spring管理的组件
2. repository、service是对component注解的包装，代表更具体的层次的组件
3. repository，是dao层组件，负责数据库接入的，会把数据库的抛出的异常，封装为**one of Spring’s unified unchecked exceptions**.（通过切面实现的，所有加了repository注解的组件都被影响到）
   1. 是通过 org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor 类实现的，如果是spring需要声明到context中；spring-boot则已经默认加了
4. 类似的controller、restcontroller也是包装的component注解，the latter 是包装的controller注解

# profiles in spring 、spring boot

**what?**

1. profile用来指定程序所需配置文件，so spring就需要知道哪里读这个配置文件
2. 一般是在配置类上，通过`PropertySource` 注解配置路径，是在classpath下的某个文件名（resource目录下）
3. 之后就可以用@value注解注入配置文件中的参数了

**spring boot 简化了什么**

1. boot采用约定大于配置，默认找resource下的application.properties配置文件，对应的profiles是default
2. 所以只需讲需要的参数写入到 resource下的application.properties配置文件，即可@value注入配置文件中的参数

**boot的环境 profile**

1. 例如test、dev、prod，只需命名为application-{test|dev|prod}.profiles；然后在default版本即application.propertes中指定`spring.profiles.active=dev` 即可选择不同环境的版本；这些在打包成jar之后就固定了
2. 所以：可以在jar同级目录外面写一个application.properties，临时配置server.port，`spring.profiles.active=dev` 用来改变端口、激活的环境配置即可
3. 当然，命令行临时指定也可：jar -jar app.jar --spring.profiles.active=env-name **都需要在resource下定义好配置，然后打包到jar后，才能识别到**
4. **配置优先级**
   1. jar目录下的application.properties
   2. jar里面classpath下的配置文件
   3. spring默认的default配置（端口8080，profile对应default）

**更改默认的配置文件名：**

```shell
java -jar app.jar --spring.config.location=./config/*/
在jar包外面，当前目录下的config目录下找配置文件，名称还是默认的application-xx.properties

java -jar app.jar --spring.config.location=classpath:/another-location.properties
读配置时，搜索指定的配置文件名（需要在jar里存在，打进去了）

```

**test程序的配置profile**

1. test程序可以在自己的resource目录下，指定自己的profile文件（也可使用main源码目录下的）
2. @TestPropertySource(properties = {"foo=bar"}) 还可以指定键值对的形式指定配置

**有层级的配置**

```java
database.url=jdbc:postgresql:/localhost:5432/instance
database.username=foo
database.password=bar
  
  @ConfigurationProperties(prefix = "database")
public class Database {
    String url;
    String username;
    String password;

    // standard getters and setters
}
```

# @value注解

https://www.baeldung.com/spring-value-annotation



1. value注解用来注入配置文件中的值
   1. 配置文件来自spring-boot默认的application.properties， or， PropertySouce指定的配置文件路径（都要在classpath路径下）

2. 可以注入系统变量的值
3. 可以Spel表达式，注入map、list，不仅仅是string（利用Spel做一些计算，比如过滤等）
4. 注入的位置：
   1. 字段
   2. setter方法
   3. 构造器方法





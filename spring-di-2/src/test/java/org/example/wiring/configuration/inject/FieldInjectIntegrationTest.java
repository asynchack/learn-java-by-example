package org.example.wiring.configuration.inject;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import org.example.wiring.configuration.ApplicationContextTestInjectType;
import org.example.wiring.configuration.ArbitraryDependency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;
/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration.inject
 * @date 2024/3/10 10:46
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = ApplicationContextTestInjectType.class
)
public class FieldInjectIntegrationTest {

    /*
    Unlike the @Resource annotation, which resolves dependencies by name first, the default behavior of the @Inject annotation is to resolve dependencies by type.

This means that even if the class reference variable name differs from the bean name, the dependency will still be resolved, provided that the bean is defined in the application context. Note how the reference variable name in the following test:
TODO 文章意思：Resource注解，需要字段名和bean的名称一致，才可以；而Inject不需要（它优先是靠类型分辨的）；但测试发现，Resource也可以不同名
     */
    @Inject
    private ArbitraryDependency fieldInjectDependency;

    @Test
    public void givenInjectAnnotation_WhenOnField_ThenValidDependency(){
        assertNotNull(fieldInjectDependency);
        assertEquals("Arbitrary Dependency",
                fieldInjectDependency.toString());
    }
}



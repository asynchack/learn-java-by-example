package org.example.wiring.configuration.inject;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.example.wiring.configuration.ApplicationContextTestInjectName;
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
 * @date 2024/3/10 11:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader= AnnotationConfigContextLoader.class,
        classes= ApplicationContextTestInjectName.class)
public class FieldByNameInjectIntegrationTest {

    @Inject
    @Named("yetAnotherFieldInjectDependency2") // 这个名字和配置类中，定义bean的方法名完全一致才可以
    private ArbitraryDependency yetAnotherFieldInjectDependency;

    @Test
    public void givenInjectQualifier_WhenSetOnField_ThenDependencyValid(){
        assertNotNull(yetAnotherFieldInjectDependency);
        assertEquals("Yet Another Arbitrary Dependency",
                yetAnotherFieldInjectDependency.toString());
    }
}
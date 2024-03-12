package org.example.wiring.configuration.resource;

import jakarta.annotation.Resource;
import org.example.wiring.configuration.ApplicationContextTestResourceQualifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.File;

import static org.junit.Assert.*;
/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration.resource
 * @date 2024/3/10 10:28
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = ApplicationContextTestResourceQualifier.class
)
public class QualifierResourceInjectionIntegrationTest {
// Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'java.io.File' available: expected single matching bean but found 2: defaultFile,namedFile

    @Resource
    @Qualifier("defaultFile")
    private File dp1;

    @Resource
    @Qualifier("namedFile")
    private File dp2;

    @Test
    public void givenResourceAnnotation_WhenField_ThenDependency1Valid() {
    assertNotNull(dp1);
    assertEquals("defaultFile.txt", dp1.getName());
    }

    @Test
    public void givenResourceQualifier_WhenField_ThenDependency2Valid() {
        assertNotNull(dp2);
        assertEquals("namedFile.txt", dp2.getName());
    }
}



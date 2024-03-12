package org.example.wiring.configuration.resource;

import jakarta.annotation.Resource;
import org.example.wiring.configuration.ApplicationContextTestResourceNameType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.File;
import static  org.junit.Assert.*;
/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration.resource
 * @date 2024/3/10 10:36
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader= AnnotationConfigContextLoader.class,
        classes= ApplicationContextTestResourceNameType.class)
public class MethodResourceInjectionIntegrationTest {

    private File defaultFile;
    @Resource(name = "namedFile")
    public void setDefaultFile(File defaultFile) {
        this.defaultFile = defaultFile;
    }

    @Test
    public void givenResourceAnnotation_WhenSetter_ThenDependencyValid(){
       assertNotNull(defaultFile);
        assertEquals("namedFile.txt", defaultFile.getName());
    }
}



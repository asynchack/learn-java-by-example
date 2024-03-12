package org.example.wiring.configuration.resource;

import jakarta.annotation.Resource;
import org.example.wiring.configuration.ApplicationContextTestResourceNameType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author bo.wang
 * @version V1.0
 * @Package org.example.wiring.configuration.resource
 * @date 2024/3/10 10:00
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = ApplicationContextTestResourceNameType.class)
public class FieldResourceInjectionTest {

//    @Resource(name = "namedFile") //名称
//    private File defaultFile;

    @Resource
    private File defaultFile; // 靠类型注入

    @Test
    public void givenResourceAnnotation_WhenOnField_ThenDependencyValid() {
        assertNotNull(defaultFile);
        assertEquals("namedFile.txt", defaultFile.getName());
    }
}



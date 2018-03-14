package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * 5.4.2 节 引用其他 Bean
 */
public class TestBeanAttrDI {
    private ApplicationContext context = null;
    private static String[] CONFIG_FILES = {"com/smart/attr/beans.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBoss() {
        Boss boss = context.getBean("boss", Boss.class);
        assertNotNull(boss);
        System.out.println(boss);
    }
}

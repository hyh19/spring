package com.smart.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * 5.2.1 节 第 120 页
 */
public class TestBeanRetrieve {
    public ApplicationContext context = null;
    private static String[] CONFIG_FILES = {"com/smart/simple/beans.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBeanRetrieve() {
        Car car = context.getBean("car", Car.class);
        assertNotNull(car);
    }
}

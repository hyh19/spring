package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * 5.4.3 内部 Bean
 */
public class MyTest {
    private ApplicationContext context = null;
    private static String[] CONFIG_FILES = {"com/smart/attr/beans.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void test() {
        Boss boss = context.getBean("boss", Boss.class);
        assertNotNull(boss);
        System.out.println(boss.getCar());
    }
}

package com.smart.ditype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * 5.3.1 节
 */
public class TestDiType {
    public ApplicationContext context = null;
    private static String[] CONFIG_FILES = {"com/smart/ditype/beans.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCar() {
        Car car = context.getBean("car", Car.class);
        assertNotNull(car);
        System.out.println(car);
    }
}

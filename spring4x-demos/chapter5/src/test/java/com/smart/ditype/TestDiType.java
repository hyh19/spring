package com.smart.ditype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * 5.3.3 节 工厂方法注入
 */
public class TestDiType {
    private ApplicationContext context = null;
    private static String[] CONFIG_FILES = {"com/smart/ditype/beans.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCar() {
        Car car1 = context.getBean("car1", Car.class);
        assertNotNull(car1);
        System.out.println(car1);

        Car car2 = context.getBean("car2", Car.class);
        assertNotNull(car2);
        System.out.println(car2);
    }
}

package com.smart.context;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 4.5.2 节
 */
public class TestBeanFactoryPostProcessor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/smart/context/beans.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }
}
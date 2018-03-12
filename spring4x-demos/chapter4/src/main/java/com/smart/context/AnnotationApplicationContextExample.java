package com.smart.context;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 4.4.2 节示例 第 97 页
 */
public class AnnotationApplicationContextExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car car = context.getBean("car", Car.class);
        System.out.println(car.toString());
    }
}

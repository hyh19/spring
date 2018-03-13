package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 4.5.1 节 第 110 页
 */
public class BeanLifeCycleExample {

    public static void main(String[] args) {

        Resource resource = new ClassPathResource("com/smart/beanfactory/beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) factory);
        reader.loadBeanDefinitions(resource);

        // ((DefaultListableBeanFactory) factory).addBeanPostProcessor(new MyBeanPostProcessor());
        // ((DefaultListableBeanFactory) factory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = factory.getBean("car", Car.class);
        Car car2 = factory.getBean("car", Car.class);
        System.out.println(car1);
        System.out.println(car2);
        // 查看 car1 和 car2 是否指向同一引用
        System.out.println("car1 == car2: " + (car1 == car2));

        ((DefaultListableBeanFactory) factory).destroySingletons();
        System.out.println(car1);
        System.out.println(car2);
    }
}

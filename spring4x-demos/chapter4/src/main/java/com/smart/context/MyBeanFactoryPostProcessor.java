package com.smart.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 4.5.2 节 第 113 页
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("car");
        beanDefinition.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！");
    }
}

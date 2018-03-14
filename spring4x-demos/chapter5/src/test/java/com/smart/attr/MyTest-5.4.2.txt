package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * 5.4.2 子容器对父容器中 Bean 的引用
 */
public class ParentContainerBeanTest {
    @Test
    public void parent() {
        ApplicationContext parentContext = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans-parent.xml"});
        ApplicationContext childContext = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans-child.xml"}, parentContext);
        Boss boss = childContext.getBean("boss", Boss.class);
        assertNotNull(boss);
        System.out.println(boss.getCar().toString());
    }
}

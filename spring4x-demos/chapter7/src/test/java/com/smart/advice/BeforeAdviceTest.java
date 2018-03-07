package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {

    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory factory = new ProxyFactory();
        // 指定对接口进行代理
        factory.setInterfaces(target.getClass().getInterfaces());
        // 启用优化，也就是使用 CGLib 动态代理技术。
        factory.setOptimize(true);
        factory.setTarget(target);
        factory.addAdvice(advice);

        Waiter proxy = (Waiter) factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}

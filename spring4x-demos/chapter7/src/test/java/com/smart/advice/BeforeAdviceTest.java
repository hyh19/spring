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
        factory.setTarget(target);
        factory.addAdvice(advice);

        Waiter proxy = (Waiter) factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}

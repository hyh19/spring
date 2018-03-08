package com.smart.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformaceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object obj = null;
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            PerformanceMonitor.begin(methodInvocation.getClass().getName() + "." + methodInvocation.getMethod().getName());
            obj = super.invoke(methodInvocation);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(methodInvocation);
        }
        return obj;
    }
}

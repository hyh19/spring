package com.smart.attr;

import java.util.HashMap;
import java.util.Map;

/**
 * 5.4.6 集合类型属性 强类型集合
 */
public class Boss {
    private Map<String, Integer> jobTime = new HashMap<>();

    public Map<String, Integer> getJobTime() {
        return jobTime;
    }

    public void setJobTime(Map<String, Integer> jobTime) {
        this.jobTime = jobTime;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "jobTime=" + jobTime +
                '}';
    }
}

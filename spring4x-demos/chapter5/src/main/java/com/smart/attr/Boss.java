package com.smart.attr;

/**
 * 5.4.2 节 引用其他 Bean
 */
public class Boss {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}

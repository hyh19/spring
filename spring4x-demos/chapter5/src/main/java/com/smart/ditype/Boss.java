package com.smart.ditype;

/**
 * 5.4.7 使用 p 命名空间
 */
public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }

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

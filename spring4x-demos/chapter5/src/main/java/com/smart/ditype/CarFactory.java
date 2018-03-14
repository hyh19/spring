package com.smart.ditype;

/**
 * 5.3.3 节 工厂方法注入
 */
public class CarFactory {
    public Car createHongQiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }

    public static Car createQiRuiCar() {
        Car car = new Car();
        car.setBrand("奇瑞");
        return car;
    }
}

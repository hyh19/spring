package com.smart.ditype;

/**
 * 5.3.3 节 工厂方法注入
 */
public class Car {
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}

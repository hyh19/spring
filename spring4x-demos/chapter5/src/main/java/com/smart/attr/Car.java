package com.smart.attr;

/**
 * 5.4.1 节 字面值
 * 5.4.2 节 引用其他 Bean
 */
public class Car {
    private String brand;
    private int maxSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

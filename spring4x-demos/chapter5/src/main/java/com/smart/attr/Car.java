package com.smart.attr;

/**
 * 5.4.1 节 字面值
 * 5.4.2 节 引用其他 Bean
 */
public class Car {
    private String brand;
    private int maxSpeed;
    private double price;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", price=" + price +
                '}';
    }
}

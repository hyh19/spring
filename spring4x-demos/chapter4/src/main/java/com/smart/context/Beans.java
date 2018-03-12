package com.smart.context;

import com.smart.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 4.4.2 节示例 第 96 页
 */

@Configuration
public class Beans {
    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setColor("黑色");
        car.setMaxSpeed(200);
        return car;
    }
}

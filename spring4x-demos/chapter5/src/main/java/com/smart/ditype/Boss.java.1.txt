package com.smart.ditype;

/**
 * 5.3.2 节 通过自身类型反射匹配入参
 */
public class Boss {
    private String name;
    private Car car;
    private Office office;

    public Boss() {
    }

    public Boss(String name, Car car, Office office) {
        this.name = name;
        this.car = car;
        this.office = office;
    }

    public Boss(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", office=" + office +
                '}';
    }
}

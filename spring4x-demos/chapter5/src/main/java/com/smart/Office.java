package com.smart;

/**
 * 5.4.8 自动装配
 */
public class Office {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Office{" +
                "city='" + city + '\'' +
                '}';
    }
}

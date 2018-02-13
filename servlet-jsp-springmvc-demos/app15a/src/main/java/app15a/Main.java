package app15a;

import app15a.bean.Employee;
import app15a.bean.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});

        Product product1 = context.getBean("product", Product.class);
        product1.setName("Excellent snake oil");
        System.out.println("product1: " + product1.getName());

        Product product2 = context.getBean("product", Product.class);
        System.out.println("product2: " + product2.getName());

        // 两个对象是同一个，说明对象被重用了。
        System.out.println(product1 == product2);

        Product featuredProduct = context.getBean("featuredProduct", Product.class);
        System.out.println(featuredProduct.getName() + ", " + featuredProduct.getDescription()
                + ", " + featuredProduct.getPrice());

        Calendar calendar = context.getBean("calendar", java.util.Calendar.class);
        System.out.println(calendar.getTime());

        Employee employee1 = context.getBean("employee1", Employee.class);
        System.out.println(employee1.getFirstName() + " " + employee1.getLastName());
        System.out.println(employee1.getHomeAddress());

        Employee employee2 = context.getBean("employee2", Employee.class);
        System.out.println(employee2.getFirstName() + " " + employee2.getLastName());
        System.out.println(employee2.getHomeAddress());
    }
}

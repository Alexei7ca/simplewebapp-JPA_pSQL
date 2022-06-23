package com.mastery.java.task;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mastery.java.task.rest")
public class EmployeeService implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static void main(String... args) {
        SpringApplication.run(EmployeeService.class, args);

        String[] beans = {"employeeController"};
        for (String beanName : beans) {
            System.out.println("Is " + beanName + " in ApplicationContext: " +
                    applicationContext.containsBean(beanName));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext _applicationContext) throws BeansException {
        applicationContext = _applicationContext;
    }
}
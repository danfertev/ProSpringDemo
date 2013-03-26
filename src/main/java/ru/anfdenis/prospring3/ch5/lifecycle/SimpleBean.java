package ru.anfdenis.prospring3.ch5.lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 01.03.13 15:09
 */
public class SimpleBean {
    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name = null;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age of any beans of type " + SimpleBean.class);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/initMethod.xml");

        SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBean simpleBean3 = getBean("simpleBean3", ctx);
    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException e) {
            System.out.println("An error occurred in bean configuration: " + e.getMessage());
            return null;
        }
    }
}

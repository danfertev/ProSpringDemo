package ru.anfdenis.prospring3.ch4.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 13.02.13 11:48
 */
public class SimpleBean {
    public String name;
    public int age;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");

        SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
        SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");

        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Age: " + age;
    }
}
package ru.anfdenis.prospring3.ch4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 12.02.13 12:08
 */
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    public ConstructorConfusion(int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number: " + Integer.toString(someValue);
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        ConstructorConfusion cc = ctx.getBean("constructorConfusion", ConstructorConfusion.class);
        System.out.println(cc);
    }

    @Override
    public String toString() {
        return someValue;
    }
}

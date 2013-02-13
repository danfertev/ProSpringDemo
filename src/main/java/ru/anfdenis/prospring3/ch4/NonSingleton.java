package ru.anfdenis.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 13.02.13 11:21
 */
public class NonSingleton {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        String s1 = ctx.getBean("nonSingleton", String.class);
        String s2 = ctx.getBean("nonSingleton", String.class);

        System.out.println("Identity Equal?: " + (s1 == s2));
        System.out.println("Value Equal?: " + s1.equals(s2));
        System.out.println(s1);
        System.out.println(s2);
    }
}

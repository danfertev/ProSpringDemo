package ru.anfdenis.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 12.02.13 11:22
 */
public class DeclareSpringConponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
    }
}

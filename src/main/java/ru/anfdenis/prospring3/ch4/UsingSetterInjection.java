package ru.anfdenis.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 12.02.13 11:49
 */
public class UsingSetterInjection {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        messageRenderer.render();
    }
}

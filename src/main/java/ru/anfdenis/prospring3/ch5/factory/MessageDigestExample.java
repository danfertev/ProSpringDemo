package ru.anfdenis.prospring3.ch5.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 04.03.13 14:26
 */
public class MessageDigestExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/ch5/factory/factory.xml");

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
    }
}

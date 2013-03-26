package ru.anfdenis.prospring3.ch5.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * Denis Anfertev
 * 04.03.13 14:29
 */
public class AccessingFactoryBeans {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/ch5/factory/factory.xml");

        MessageDigest digest = (MessageDigest) ctx.getBean("shaDigest");
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("Hello World!".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

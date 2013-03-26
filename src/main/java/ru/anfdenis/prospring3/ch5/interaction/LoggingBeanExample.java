package ru.anfdenis.prospring3.ch5.interaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 04.03.13 11:05
 */
public class LoggingBeanExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/ch5/interaction/logging.xml");

        LoggingBean bean = (LoggingBean) ctx.getBean("loggingBean");
        bean.someOperation();
    }
}

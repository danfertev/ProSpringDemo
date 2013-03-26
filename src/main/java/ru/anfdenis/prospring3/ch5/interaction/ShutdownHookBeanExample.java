package ru.anfdenis.prospring3.ch5.interaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.anfdenis.prospring3.ch5.lifecycle.DestructiveBeanWithInterface;

/**
 * Denis Anfertev
 * 04.03.13 11:21
 */
public class ShutdownHookBeanExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/ch5/interaction/shutdownHook.xml");
        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
    }
}

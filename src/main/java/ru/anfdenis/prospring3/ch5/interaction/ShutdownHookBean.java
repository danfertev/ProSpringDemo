package ru.anfdenis.prospring3.ch5.interaction;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 04.03.13 11:16
 */
public class ShutdownHookBean implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof GenericXmlApplicationContext) {
            ((GenericXmlApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}

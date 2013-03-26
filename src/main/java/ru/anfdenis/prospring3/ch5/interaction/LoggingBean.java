package ru.anfdenis.prospring3.ch5.interaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * Denis Anfertev
 * 04.03.13 11:01
 */
public class LoggingBean implements BeanNameAware {
    private static final Log log = LogFactory.getLog(LoggingBean.class);
    private String beanName = null;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public void someOperation() {
        if (log.isInfoEnabled()) {
            log.info("Bean [" + beanName + "] - someOperation()");
        }
    }
}

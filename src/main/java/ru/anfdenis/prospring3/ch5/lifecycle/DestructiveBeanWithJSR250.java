package ru.anfdenis.prospring3.ch5.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Denis Anfertev
 * 01.03.13 16:04
 */
public class DestructiveBeanWithJSR250 {
    private InputStream is = null;
    public String filePath = null;

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithJSR250.class);
        }
        is = new FileInputStream(filePath);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");
        if (is != null) {
            try {
                is.close();
                is = null;
            } catch (IOException e) {
                System.err.println("WARN: An IOException occurred trying to close the InputStream");
            }
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/destroyJSR250.xml");

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}

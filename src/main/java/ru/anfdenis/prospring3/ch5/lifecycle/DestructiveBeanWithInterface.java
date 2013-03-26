package ru.anfdenis.prospring3.ch5.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Denis Anfertev
 * 01.03.13 16:04
 */
public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {
    private InputStream is = null;
    public String filePath = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithInterface.class);
        }
        is = new FileInputStream(filePath);
    }

    @Override
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
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/destroyInterface.xml");
        ctx.registerShutdownHook();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
        /*System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");*/
    }
}

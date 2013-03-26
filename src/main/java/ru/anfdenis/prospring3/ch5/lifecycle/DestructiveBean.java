package ru.anfdenis.prospring3.ch5.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Denis Anfertev
 * 01.03.13 16:04
 */
public class DestructiveBean {
    private InputStream is = null;
    public String filePath = null;

    public void init() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
        }
        is = new FileInputStream(filePath);
    }

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
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/destroyMethod.xml");

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}

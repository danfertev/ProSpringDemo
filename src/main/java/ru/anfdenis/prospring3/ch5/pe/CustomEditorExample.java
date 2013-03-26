package ru.anfdenis.prospring3.ch5.pe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 05.03.13 10:42
 */
public class CustomEditorExample {
    private Name name;

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:META-INF/spring/ch5/pe/custom.xml");

        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}

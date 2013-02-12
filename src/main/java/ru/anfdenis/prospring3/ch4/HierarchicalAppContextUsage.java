package ru.anfdenis.prospring3.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 12.02.13 14:40
 */
public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:META-INF/spring/parent.xml");
        parent.refresh();

        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("classpath:META-INF/spring/app-context-xml.xml");
        child.setParent(parent);
        child.refresh();

        SimpleTarget target1 = child.getBean("target1", SimpleTarget.class);
        SimpleTarget target2 = child.getBean("target2", SimpleTarget.class);
        SimpleTarget target3 = child.getBean("target3", SimpleTarget.class);

        System.out.println(target1.getVal());
        System.out.println(target2.getVal());
        System.out.println(target3.getVal());
    }
}

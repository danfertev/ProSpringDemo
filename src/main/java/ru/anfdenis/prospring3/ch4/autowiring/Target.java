package ru.anfdenis.prospring3.ch4.autowiring;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Denis Anfertev
 * 13.02.13 11:33
 */
public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
    }

    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        System.out.println("Property foo2 set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/autowiring.xml");
        ctx.refresh();

        Target t = null;
        System.out.println("Using byName:\n");
        t = ctx.getBean("targetByName", Target.class);
        System.out.println("\nUsing byType:\n");
        t = ctx.getBean("targetByType", Target.class);
        System.out.println("\nUsing constructor:\n");
        t = ctx.getBean("targetConstructor", Target.class);

    }
}

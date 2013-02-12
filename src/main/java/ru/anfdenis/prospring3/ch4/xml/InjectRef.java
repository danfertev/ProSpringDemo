package ru.anfdenis.prospring3.ch4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.anfdenis.prospring3.ch4.Oracle;

/**
 * Denis Anfertev
 * 12.02.13 14:32
 */
public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle) {
        this.oracle = oracle;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        InjectRef injectRef = ctx.getBean("injectRef", InjectRef.class);
        System.out.println(injectRef);
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}

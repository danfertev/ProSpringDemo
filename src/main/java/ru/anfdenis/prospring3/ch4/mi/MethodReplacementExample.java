package ru.anfdenis.prospring3.ch4.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Denis Anfertev
 * 12.02.13 16:57
 */
public class MethodReplacementExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/replacement.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = ctx.getBean("replacementTarget", ReplacementTarget.class);
        ReplacementTarget standardTarget = ctx.getBean("standardTarget", ReplacementTarget.class);

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    public static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");

        for (int i = 0; i < 1000000; i++) {
            String out = target.formatMessage("foo");
        }

        stopWatch.stop();

        System.out.println("1000000 invocation took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}

package ru.anfdenis.prospring3.ch4.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Denis Anfertev
 * 12.02.13 16:27
 */
public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/lookup.xml");
        ctx.refresh();

        DemoBean abstractBean = ctx.getBean("abstractLookupDemoBean", DemoBean.class);
        DemoBean standardBean = ctx.getBean("standardLookupDemoBean", DemoBean.class);

        displayInfo(standardBean);
        displayInfo(abstractBean);
    }

    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();
        System.out.println("Helper Instances the Same?: " + (helper1 == helper2));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int i = 0; i < 100000; i++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}

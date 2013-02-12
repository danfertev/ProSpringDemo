package ru.anfdenis.prospring3.ch4.mi;

/**
 * Denis Anfertev
 * 12.02.13 16:22
 */
public abstract class AbstractLookupDemoBean implements DemoBean {
    @Override
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}

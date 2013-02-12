package ru.anfdenis.prospring3.ch4.mi;

/**
 * Denis Anfertev
 * 12.02.13 16:21
 */
public class StandardLookupDemoBean implements DemoBean {
    private MyHelper myHelper;

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }
}

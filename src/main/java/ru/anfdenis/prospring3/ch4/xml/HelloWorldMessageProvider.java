package ru.anfdenis.prospring3.ch4.xml;

import ru.anfdenis.prospring3.ch4.MessageProvider;

/**
 * Denis Anfertev
 * 05.02.13 11:03
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }

    public void setMessageRenderer(StandartOutMessageRenderer messageRenderer) {
    }
}

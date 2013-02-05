package ru.anfdenis.prospring3.ch2;

/**
 * Denis Anfertev
 * 05.02.13 11:03
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}

package ru.anfdenis.prospring3.ch4.xml;

import ru.anfdenis.prospring3.ch4.MessageProvider;

/**
 * Denis Anfertev
 * 12.02.13 11:52
 */
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

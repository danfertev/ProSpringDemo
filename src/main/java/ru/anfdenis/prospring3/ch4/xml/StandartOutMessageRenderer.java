package ru.anfdenis.prospring3.ch4.xml;

import ru.anfdenis.prospring3.ch4.MessageProvider;
import ru.anfdenis.prospring3.ch4.MessageRenderer;

/**
 * Denis Anfertev
 * 05.02.13 11:04
 */
public class StandartOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if (this.messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class: " + StandartOutMessageRenderer.class.getName());
        }
        System.out.println(this.messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}

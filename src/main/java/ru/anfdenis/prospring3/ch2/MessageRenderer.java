package ru.anfdenis.prospring3.ch2;

/**
 * Denis Anfertev
 * 05.02.13 11:00
 */
public interface MessageRenderer {
    public void render();

    public void setMessageProvider(MessageProvider provider);

    public MessageProvider getMessageProvider();
}

package ru.anfdenis.prospring3.ch2;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Denis Anfertev
 * 05.02.13 11:12
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance = null;
    private Properties props = null;
    private MessageRenderer renderer = null;
    private MessageProvider provider = null;

    public MessageSupportFactory() {
        props = new Properties();

        try {
            props.load(new FileInputStream("/src/main/resources/msf.properties"));

            //Get class instance
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");
            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider) Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }

    public MessageProvider getProvider() {
        return provider;
    }

}


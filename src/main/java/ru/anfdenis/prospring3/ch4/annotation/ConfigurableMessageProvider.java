package ru.anfdenis.prospring3.ch4.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anfdenis.prospring3.ch4.MessageProvider;

/**
 * Denis Anfertev
 * 12.02.13 11:52
 */
@Service("configurableMessageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

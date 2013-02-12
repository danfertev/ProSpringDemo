package ru.anfdenis.prospring3.ch4.annotation;

import org.springframework.stereotype.Service;
import ru.anfdenis.prospring3.ch4.MessageProvider;

/**
 * Denis Anfertev
 * 05.02.13 11:03
 */
@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}

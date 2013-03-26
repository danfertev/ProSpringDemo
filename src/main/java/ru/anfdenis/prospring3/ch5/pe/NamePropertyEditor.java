package ru.anfdenis.prospring3.ch5.pe;

import java.beans.PropertyEditorSupport;

/**
 * Denis Anfertev
 * 05.03.13 10:33
 */
public class NamePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");
        Name results = new Name(name[0], name[1]);
        setValue(results);
    }
}

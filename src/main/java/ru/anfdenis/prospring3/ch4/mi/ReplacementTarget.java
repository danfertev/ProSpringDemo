package ru.anfdenis.prospring3.ch4.mi;

/**
 * Denis Anfertev
 * 12.02.13 16:43
 */
public class ReplacementTarget {
    public String formatMessage(String msg) {
        return "<h1>" + msg + "</h1>";
    }

    public String formatMessage(Object msg) {
        return "<h1>" + msg + "</h1>";
    }
}

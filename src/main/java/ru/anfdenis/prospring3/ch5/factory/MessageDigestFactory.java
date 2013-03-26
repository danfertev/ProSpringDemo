package ru.anfdenis.prospring3.ch5.factory;

import java.security.MessageDigest;

/**
 * Denis Anfertev
 * 04.03.13 14:34
 */
public class MessageDigestFactory {
    private String algorithmName = "MD5";

    public MessageDigest createInstance() throws Exception {
        return MessageDigest.getInstance(algorithmName);
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
}

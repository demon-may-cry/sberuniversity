package ru.sberuniversity.encryptedclassloader;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class KeyGenerator {
    public Key getKeyFromKeyGenerator() throws NoSuchAlgorithmException {
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
}

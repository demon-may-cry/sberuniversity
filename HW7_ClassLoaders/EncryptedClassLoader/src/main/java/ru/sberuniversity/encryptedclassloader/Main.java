package ru.sberuniversity.encryptedclassloader;

import java.io.File;
import java.security.Key;

import static ru.sberuniversity.encryptedclassloader.Encrypted.encryptClassFile;

public class Main {
    public static void main(String[] args) throws Exception {
        File rootDir = new File("src/main/java/ru/sberuniversity/encryptedclassloader/target");
        KeyGenerator keyGenerator = new KeyGenerator();
        Key key = keyGenerator.getKeyFromKeyGenerator();
        FileEncrypted fileEncrypted = new FileEncrypted();
        
        encryptClassFile(fileEncrypted.input("Sample.class"), fileEncrypted.output("Sample.class"), key);

        EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(Main.class.getClassLoader(), key, rootDir);

        Class<?> sample = encryptedClassLoader.findClass("Sample");
        Object sampleInstance = sample.getDeclaredConstructor().newInstance();
        sample.getMethod("encryptMe").invoke(sampleInstance);
    }
}
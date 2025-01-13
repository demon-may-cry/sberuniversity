package ru.sberuniversity.encryptedclassloader;

import javax.crypto.Cipher;
import java.io.File;
import java.nio.file.Files;
import java.security.Key;

public class Encrypted {
    public static void encryptClassFile(File inputFile, File outputFile, Key key) throws Exception {
        byte[] byteClass = Files.readAllBytes(inputFile.toPath());
        byte[] byteEncrypted = encrypt(byteClass, key);
        Files.write(outputFile.toPath(), byteEncrypted);
        System.out.println("Файл успешно зашифрован: " + outputFile.getPath());
    }

    private static byte[] encrypt(byte[] data, Key key) throws Exception {
        Cipher encrypted = Cipher.getInstance("AES");
        encrypted.init(Cipher.ENCRYPT_MODE, key);
        return encrypted.doFinal(data);
    }
}

package ru.sberuniversity.encryptedclassloader;

import javax.crypto.Cipher;
import java.io.File;
import java.nio.file.Files;
import java.security.Key;

public class EncryptedClassLoader extends ClassLoader {
    private final Key key;
    private final File dir;

    public EncryptedClassLoader(ClassLoader parent, Key key, File dir) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    private static byte[] decrypt(byte[] data, Key key) throws Exception {
        Cipher decrypted = Cipher.getInstance("AES");
        decrypted.init(Cipher.DECRYPT_MODE, key);
        return decrypted.doFinal(data);
    }

    @Override
    protected Class<?> findClass(String name) {
        File file = new File(dir, name.replace('\\', '.') + ".class");
        try {
            byte[] byteEncrypted = Files.readAllBytes(file.toPath());
            byte[] byteDecrypted = decrypt(byteEncrypted, key);
            System.out.println("Файл успешно расшифрован!");
            return defineClass(byteDecrypted, 0, byteDecrypted.length);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

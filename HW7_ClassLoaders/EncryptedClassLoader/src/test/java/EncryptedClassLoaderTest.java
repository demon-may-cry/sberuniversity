import org.junit.jupiter.api.*;
import ru.sberuniversity.encryptedclassloader.EncryptedClassLoader;
import ru.sberuniversity.encryptedclassloader.KeyGenerator;

import java.io.File;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.sberuniversity.encryptedclassloader.Encrypted.encryptClassFile;

public class EncryptedClassLoaderTest {

    static KeyGenerator keyGenerator = new KeyGenerator();
    static Key key;

    @BeforeAll
    public static void setUp() throws Exception {
        key = keyGenerator.getKeyFromKeyGenerator();
        File input = new File("target/test-classes/EncryptionTestClass.class");
        File output = new File("src/test/java/EncryptionTestClass.class");
        encryptClassFile(input, output, key);
    }
    @Test
    @DisplayName("Тест валидного ключа")
    public void testValidKey() {
        EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(ClassLoader.getSystemClassLoader(),
                key,
                new File("src/test/java"));

        Class<?> clazz = encryptedClassLoader.findClass("EncryptionTestClass");
        assertEquals("EncryptionTestClass", clazz.getName());
    }

    @Test
    @DisplayName("Тест не валидного ключа")
    public void testInvalidKey() throws NoSuchAlgorithmException {
        Key newKey = keyGenerator.getKeyFromKeyGenerator();
        EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(ClassLoader.getSystemClassLoader(),
                newKey,
                new File("src/test/java"));
        assertThrows(RuntimeException.class, () -> encryptedClassLoader.findClass("EncryptionTestClass"));
    }
}

package ru.sberuniversity.encryptedclassloader;

import java.io.File;

public class FileEncrypted {
    String pathSource = "target/classes/ru/sberuniversity/encryptedclassloader/source";
    String pathTarget = "src/main/java/ru/sberuniversity/encryptedclassloader/target";

    public File input(String fileName) {
        return new File(pathSource, fileName);
    }

    public File output(String fileName) {
        return new File(pathTarget, fileName);
    }
}

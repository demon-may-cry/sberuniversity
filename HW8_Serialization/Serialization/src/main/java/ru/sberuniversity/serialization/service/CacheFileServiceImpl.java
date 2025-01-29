package ru.sberuniversity.serialization.service;

import ru.sberuniversity.serialization.annotation.Cache;
import ru.sberuniversity.serialization.proxy.ArgsKey;

import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CacheFileServiceImpl implements CacheService {
    private static final String fileExtension = ".sav";
    private static final String fileExtensionZip = ".zip";
    private static String fileName;
    private static String fileNameZip;
    private final boolean zipFile;
    private final int countArgs;
    private Map<ArgsKey, Object> argsMap;

    public CacheFileServiceImpl(int countArgs, Method method, boolean zipFile) {
        this.zipFile = zipFile;
        this.countArgs = countArgs;
        argsMap = new HashMap<>();
        initName(method);
        initNameZip(method);
        deserialization();
    }

    private void initName(Method method) {
        Cache namePrefix = method.getAnnotation(Cache.class);
        fileName = namePrefix.fileNamePrefix().isEmpty() ?
                method.getName() + fileExtension : namePrefix.fileNamePrefix() + fileExtension;
    }

    private void initNameZip(Method method) {
        if (zipFile) {
            Cache namePrefix = method.getAnnotation(Cache.class);
            fileNameZip = namePrefix.fileNamePrefix().isEmpty() ?
                    method.getName() + fileExtensionZip : namePrefix.fileNamePrefix() + fileExtensionZip;
        }
    }

    private void serialization() {
        try {
            if (zipFile) {
                ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(fileNameZip));
                zipOut.putNextEntry(new ZipEntry(fileName));
                ObjectOutputStream objectOut = new ObjectOutputStream(zipOut);
                objectOut.writeObject(argsMap);
                zipOut.closeEntry();
                System.out.println("Кэш был заархивирован в " + fileNameZip);

            } else {
                FileOutputStream outputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
                objectOut.writeObject(argsMap);
                System.out.println("Кэш был сохранен в " + fileName);
                objectOut.close();
            }
        } catch (IOException ex) {
            System.err.println("Ошибка сериализации: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void deserialization() {
        try {
            if (new File(fileName).exists() || new File(fileNameZip).exists()) {
                if (zipFile) {
                    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(fileNameZip));
                    ZipEntry entry;
                    while ((entry = zipIn.getNextEntry()) != null) {
                        if (entry.getName().equals(fileName)) {
                            ObjectInputStream objectIn = new ObjectInputStream(zipIn);
                            argsMap = (HashMap<ArgsKey, Object>) objectIn.readObject();
                            System.out.println("Кэш был загружен из архива " + fileNameZip);
                            argsMap.forEach((k, v) -> System.out.println(k.getArgs() + " -> загружено из архива"));
                            objectIn.close();
                            break;
                        }
                    }
                    zipIn.close();
                } else {
                    FileInputStream inputStream = new FileInputStream(fileName);
                    ObjectInputStream objectIn = new ObjectInputStream(inputStream);
                    argsMap = (HashMap<ArgsKey, Object>) objectIn.readObject();
                    System.out.println("Кэш был загружен из файла " + fileName);
                    argsMap.forEach((k, v) -> System.out.println(k.getArgs() + " -> загружено из файла"));
                    objectIn.close();
                }
            }
        } catch (NullPointerException ex) {
            System.err.println("Файл не найден");
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Ошибка десериализации: " + ex.getMessage());
        }
    }

    @Override
    public ArgsKey getValueArgs(Object[] args) {
        return switch (countArgs) {
            case 1 -> new ArgsKey(new Object[]{args[0]});
            case 2 -> new ArgsKey(new Object[]{args[1]});
            default -> new ArgsKey(args);
        };
    }

    @Override
    public Object get(Object[] args) {
        return getValueArgs(args).getArgs();
    }

    @Override
    public void put(Object[] args, Object value) {
        if (countArgs == 0) {
            argsMap.put(getValueArgs(args), args[1]);
        } else {
            argsMap.put(getValueArgs(args), value);
        }
        serialization();
    }

    @Override
    public boolean contains(Object[] args) {
        return argsMap.containsKey(getValueArgs(args));
    }
}

package ru.sberuniversity.multithreadingpart1;

import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FileRandomNumbers {
    private final String path;

    public void createAndWritingFile(String fileName, List<Integer> numbers) {
        try {
            File file = new File(path + fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for(Integer num : numbers) {
                fileOutputStream.write(num.toString().getBytes());
                fileOutputStream.write("\n".getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public List<Integer> readFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(path + fileName);
            if (!file.exists()) {
                throw new FileNotFoundException("Файл не найден: " + file.getAbsolutePath());
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine())!= null) {
                    numbers.add(Integer.parseInt(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        return numbers;
    }
}

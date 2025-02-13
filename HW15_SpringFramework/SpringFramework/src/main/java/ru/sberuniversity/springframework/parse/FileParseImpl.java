package ru.sberuniversity.springframework.parse;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileParseImpl implements FileParse{

    @Override
    @SneakyThrows
    public List<String> parseFile(String file) {
        return Files.readAllLines(Paths.get(file));
    }
}

package ru.sberuniversity.springframework;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.sberuniversity.springframework.config.PropertiesConfig;
import ru.sberuniversity.springframework.parse.FileParse;
import ru.sberuniversity.springframework.service.DownloadService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final DownloadService downloadService;
    private final PropertiesConfig propertiesConfig;
    private final FileParse fileParse;

    @Override
    public void run(String... args) throws IOException {
        downloadService.download(fileParse.parseFile(propertiesConfig.getSource()), propertiesConfig.getTarget());
    }
}

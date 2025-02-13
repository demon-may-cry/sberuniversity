package ru.sberuniversity.springframework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.sberuniversity.springframework.config.PropertiesConfig;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class DownloadServiceImpl implements DownloadService {
    private final PropertiesConfig propertiesConfig;

    public void download(List<String> listURL, String target) {
        ExecutorService executorService = Executors.newFixedThreadPool(propertiesConfig.getThreadsCount());
        for (String url : listURL) {
            executorService.execute(new DownloadServiceRun(url, target, propertiesConfig));
        }
        executorService.shutdown();
    }
}

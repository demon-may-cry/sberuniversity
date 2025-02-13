package ru.sberuniversity.springframework.service;

import java.io.IOException;
import java.util.List;

public interface DownloadService {
    void download(List<String> listURL, String target) throws IOException;
}

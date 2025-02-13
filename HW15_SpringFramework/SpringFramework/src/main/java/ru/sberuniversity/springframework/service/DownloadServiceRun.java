package ru.sberuniversity.springframework.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sberuniversity.springframework.config.PropertiesConfig;

import java.io.*;
import java.net.URL;

@RequiredArgsConstructor
public class DownloadServiceRun implements Runnable {
    Logger log = LogManager.getLogger(DownloadServiceRun.class);

    private final String url;
    private final String target;
    private final PropertiesConfig propertiesConfig;

    @Override
    public void run() {
        if (!new File(target).exists()) {
            new File(target).mkdirs();
        }
        try {
            InputStream inputStream = new BufferedInputStream(new URL(url).openStream());
            OutputStream outStream = new FileOutputStream(target + url.substring(url.lastIndexOf("/")));

            byte[] buffer = new byte[1024];
            int bytesRead;
            long startTime = System.nanoTime();

            long totalBytesWritten = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
                totalBytesWritten += bytesRead;
                downloadRate(totalBytesWritten, startTime);
            }

            long totalDownloadTimeMs = (System.nanoTime() - startTime) / 1_000_000;
            double downloadSpeedKBps = (totalBytesWritten / 1024.0) / (totalDownloadTimeMs / 1000.0);

            log.info("Downloaded: {} / {} KB", url, String.format("%.2f", totalBytesWritten/1000D));
            log.info("Download speed: {} KBps", String.format("%.2f", downloadSpeedKBps));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private void downloadRate(long totalBytesWritten, long startTime) {
        long elapsedTimeNs = System.nanoTime() - startTime;
        long elapsedSeconds = elapsedTimeNs / 1_000_000_000;

        if (elapsedSeconds * 1024 * propertiesConfig.getDownloadSpeed() < totalBytesWritten) {
            long desiredTimeNs = (totalBytesWritten * 1_000_000_000L) / (propertiesConfig.getDownloadSpeed() * 1024L);
            long sleepTime = desiredTimeNs - elapsedTimeNs;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1_000_000, (int) (sleepTime % 1_000_000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

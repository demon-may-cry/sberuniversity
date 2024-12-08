package ru.sberuniversity.exception;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadContent {

    public void readContent(String url) {
        try {
            if (checkFormatUrl(url)) {
                Document doc = Jsoup.connect(url)
                        .ignoreContentType(true)
                        .ignoreHttpErrors(true)
                        .timeout(1000)
                        .get();
                System.out.println(doc.body());
            } else {
                System.out.println("URL неверного формата. Пример: https://ya.ru");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private boolean checkFormatUrl(String url) {
        String regex = "https?://([a-zA-Z0-9]+.)?[a-zA-Z0-9]+.[a-z]{2,3}/?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}

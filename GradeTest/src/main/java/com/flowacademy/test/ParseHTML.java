package com.flowacademy.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class ParseHTML {

    public void parseHTML() throws IOException {
        File input = new File("index.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        String title = doc.title();
        String body = doc.body().text();
        System.out.printf("Title: %s%n", title);
        System.out.printf("Body: %s", body);
    }
}

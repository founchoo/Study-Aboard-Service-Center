package com.wt6.sasc.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {

    public static Document getResponseBodyAsDocument(String uri) throws IOException, InterruptedException, URISyntaxException {
        return Jsoup.parse(getResponseBody(uri));
    }

    public static String getResponseBody(String uri) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/87.0.4280.88 Safari/537.36")
                .build();

        HttpResponse<String> response = client.send(req,HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        System.out.println(body);

        return body;
    }

}

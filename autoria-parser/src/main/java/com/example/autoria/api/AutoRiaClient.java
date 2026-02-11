package com.example.autoria.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AutoRiaClient {

    private static final String API_URL =
            "https://developers.ria.com/auto/search?api_key=YOUR_API_KEY";

    public String fetchJson() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch AutoRia data", e);
        }
    }
}

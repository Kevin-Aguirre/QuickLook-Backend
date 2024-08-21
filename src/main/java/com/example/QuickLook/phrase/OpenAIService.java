package com.example.QuickLook.phrase;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONArray;


@Service
public class OpenAIService {

    @Value("${openai.service.api.key}")
    private String apiKey;

    @Value("${openai.service.api.url}")
    private String apiUrl;

    @Value("${openai.service.chatgpt.model}")
    private String chatGptModel;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @RequestMapping(value = "/generateSummary", method = RequestMethod.POST, produces = "application/json")
    public String generateSummary(@RequestParam String term) throws Exception {
        String requestBody = "{"
                + "  \"model\": \"" + chatGptModel + "\","
                + "  \"messages\": ["
                + "    {\"role\": \"user\", \"content\": \"Please provide a summary for: " + term + "\"}"
                + "  ],"
                + "  \"max_tokens\": " + 400
                + "}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(apiUrl)) // Adjust the endpoint as necessary
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .timeout(Duration.ofSeconds(10))
                .build();

        System.out.println("made it here");

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        JSONObject jsonResponse = new JSONObject(response.body());
        JSONArray jsonArray = jsonResponse.getJSONArray("choices");
        JSONObject element = jsonArray.getJSONObject(0);
        JSONObject message = element.getJSONObject("message");
        String summary = message.getString("content");

        return summary;
    }
}

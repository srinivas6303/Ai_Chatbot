package com.ai.ai_chatbot_backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    @Value("${gemini_api_key}")
    private String API_KEY;

    public String getResponse(String userMessage) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent?key=" + API_KEY;

        String requestBody = "{\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"parts\": [\n" +
                "        { \"text\": \"" + userMessage + "\" }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, entity, String.class);

        String raw= response.getBody();

        return extractText(raw);
    }


    public String extractText(String jsonResponse) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);

            return root
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

        } catch (Exception e) {
            return "Error parsing response";
        }
    }
}
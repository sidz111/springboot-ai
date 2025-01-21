package com.example.aiintegration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class AIService {

    private static final String AI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=GEMINI_API_KEY";
    private static final String API_KEY = "AIzaSyD2v3MRK7gqst4dXIkvfsQXj-oCUe05z-I";

    public String getAIResponse(String prompt) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            // Construct request body
            String requestBody = "{\n" +
                    "  \"contents\": [{\n" +
                    "    \"parts\": [{\"text\": \"" + prompt + "\"}]\n" +
                    "  }]\n" +
                    "}";

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.exchange(AI_API_URL.replace("GEMINI_API_KEY", API_KEY), HttpMethod.POST, entity, String.class);

            return response.getBody(); // Return AI response
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while fetching the AI response.";
        }
    }
}

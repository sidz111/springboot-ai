package com.example.aiintegration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AIService {

    private static final String AI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=GEMINI_API_KEY";
    private static final String API_KEY = "Your_API_Key";

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

    public String formatAIResponse(String aiResponse) {
        try {
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseNode = objectMapper.readTree(aiResponse);

            // Extract the content from the response
            JsonNode candidates = responseNode.path("candidates");
            if (candidates.isArray() && candidates.size() > 0) {
                JsonNode contentNode = candidates.get(0).path("content").path("parts").get(0).path("text");
                String content = contentNode.asText();

                // Format the output properly
                StringBuilder formattedResponse = new StringBuilder();
                formattedResponse.append("<h3>AI Response:</h3>");
                formattedResponse.append("<p><strong>Response Content:</strong></p>");
                formattedResponse.append("<p>").append(content).append("</p>");

                return formattedResponse.toString();
            }

            return "No response available from AI.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error formatting AI response.";
        }
    }
}

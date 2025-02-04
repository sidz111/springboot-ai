package com.example.aiintegration.service;

public interface AIService {

    String getAIResponse(String prompt);

    String formatAIResponse(String aiResponse);
}

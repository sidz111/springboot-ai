package com.example.aiintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.aiintegration.service.AIService;

@Controller
public class AIController {

    @Autowired
    private AIService aiService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/get-response")
    public String getAIResponse(@RequestParam String prompt, Model model) {
        String aiResponse = aiService.getAIResponse(prompt);

        // Parse the AI response (JSON) to extract useful data
        String formattedResponse = aiService.formatAIResponse(aiResponse);

        model.addAttribute("response", formattedResponse);
        return "index";
    }
}

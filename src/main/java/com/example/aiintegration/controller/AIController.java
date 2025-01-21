package com.example.aiintegration.controller;

import com.example.aiintegration.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("response", aiResponse);
        return "index";
    }
}

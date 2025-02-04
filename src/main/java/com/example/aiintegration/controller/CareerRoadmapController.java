package com.example.aiintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.aiintegration.service.CareerRoadmapService;

@Controller
public class CareerRoadmapController {

    @Autowired
    private CareerRoadmapService careerRoadmapService;

    @GetMapping("/career-roadmap")
    public String showForm() {
        return "career-roadmap";
    }

    @PostMapping("/generate-roadmap")
    public String generateRoadmap(@RequestParam String name,
    		@RequestParam String age,
                                   @RequestParam String gender,
                                   @RequestParam String qualification,
                                   @RequestParam String careerGoal,
                                   @RequestParam String skills,
                                   @RequestParam String language,
                                   Model model) {
        String roadmap = careerRoadmapService.generateCareerRoadmap(name, age, gender, qualification, careerGoal, skills, language);
        model.addAttribute("roadmap", roadmap);
        return "career-roadmap-result";
    }
    
    
    // For Government module
    @GetMapping("/career-roadmap-gov")
    public String showFormGov() {
        return "career-roadmap-gov";
    }

    @PostMapping("/generate-roadmap-gov")
    public String generateRoadmapGov(@RequestParam String name,
    		@RequestParam String age,
                                   @RequestParam String gender,
                                   @RequestParam String qualification,
                                   @RequestParam String careerGoal,
                                   @RequestParam String skills,
                                   @RequestParam String caste,
                                   @RequestParam String language,
                                   Model model) {
        String roadmap = careerRoadmapService.generateCareerRoadmapForGov(name, age, gender, qualification, careerGoal, skills, caste, language);
        model.addAttribute("roadmap", roadmap);
        return "career-roadmap-result";
    }
}

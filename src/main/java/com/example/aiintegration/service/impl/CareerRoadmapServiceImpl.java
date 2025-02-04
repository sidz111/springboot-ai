package com.example.aiintegration.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aiintegration.service.AIService;
import com.example.aiintegration.service.CareerRoadmapService;

@Service
public class CareerRoadmapServiceImpl implements CareerRoadmapService {

    @Autowired
    private AIService aiService;

    @Override
    public String generateCareerRoadmap(String name, String age, String gender, String qualification, String careerGoal, String skills, String language) {
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("Generate User's Career Roadmap for user where: \n");
        promptBuilder.append("Name: ").append(name).append("\n");
        promptBuilder.append("Age: ").append(age).append("\n");
        promptBuilder.append("Gender: ").append(gender).append("\n");
        promptBuilder.append("Qualification: ").append(qualification).append("\n");
        promptBuilder.append("Career Goal: ").append(careerGoal).append("\n");
        promptBuilder.append("Skills: ").append(skills).append("\n");
        promptBuilder.append("I wanna whole response in: ").append(language).append(" language\n");
        promptBuilder.append("Please generate a detailed career roadmap for this user step by step i wanna detail roadp.");
        String aiResponse = aiService.getAIResponse(promptBuilder.toString());
        return aiService.formatAIResponse(aiResponse);
    }

	@Override
	public String generateCareerRoadmapForGov(String name, String age, String gender, String qualification, String careerGoal,
			String skills, String caste, String language) {
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("Generate User's Career Roadmap for government exams for user where: \n");
        promptBuilder.append("Name: ").append(name).append("\n");
        promptBuilder.append("Age: ").append(age).append("\n");
        promptBuilder.append("Gender: ").append(gender).append("\n");
        promptBuilder.append("Qualification: ").append(qualification).append("\n");
        promptBuilder.append("Career Goal: ").append(careerGoal).append("\n");
        promptBuilder.append("Skills: ").append(skills).append("\n");
        promptBuilder.append("Caste: ").append(caste).append("\n");
        promptBuilder.append("I wanna whole response in: ").append(language).append(" language\n");
        promptBuilder.append("Please generate a detailed career roadmap for this user step by step i wanna detail roadp.");
        String aiResponse = aiService.getAIResponse(promptBuilder.toString());
        return aiService.formatAIResponse(aiResponse);
	}
}

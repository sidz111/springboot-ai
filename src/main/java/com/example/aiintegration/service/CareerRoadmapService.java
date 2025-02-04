package com.example.aiintegration.service;

public interface CareerRoadmapService {

    String generateCareerRoadmap(String name, String age, String gender, String qualification, String careerGoal, String skills, String language);
    String generateCareerRoadmapForGov(String name, String age, String gender, String qualification, String careerGoal, String skills, String caste, String language);
}

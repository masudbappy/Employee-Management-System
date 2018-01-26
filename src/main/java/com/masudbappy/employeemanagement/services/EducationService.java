package com.masudbappy.employeemanagement.services;

import com.masudbappy.employeemanagement.entities.Education;
import com.masudbappy.employeemanagement.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

    private EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public Education createEducation(String university, String college, String school , long id){
        if (!educationRepository.exists(id)){
            educationRepository.save(new Education(university,college,school));
        }
        return null;
    }
}

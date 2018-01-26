package com.masudbappy.employeemanagement.services;

import com.masudbappy.employeemanagement.entities.Designation;
import com.masudbappy.employeemanagement.repositories.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationService {

    private DesignationRepository designationRepository;

    @Autowired
    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    public Designation createDesignation(String name, long id){
        if (!designationRepository.exists(id)){
            designationRepository.save(new Designation(name));
        }
        return null;
    }
}

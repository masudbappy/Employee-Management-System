package com.masudbappy.employeemanagement.services;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(String name, long id){
        if (!departmentRepository.exists(id)){
            departmentRepository.save(new Department(name));
        }
        return null;
    }
}

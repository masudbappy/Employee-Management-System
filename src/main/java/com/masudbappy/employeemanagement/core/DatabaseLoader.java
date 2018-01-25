package com.masudbappy.employeemanagement.core;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.entities.Designation;
import com.masudbappy.employeemanagement.entities.Education;
import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        Employee employee = new Employee();
        employee.setName("Masud");
        employee.addEducation(new Education("UAP","MMC","CSPHS"));
        employee.addDesignation(new Designation("Software Engineer"));
        employee.setDepartment(new Department("Software"));
        employeeRepository.save(employee);
    }
}

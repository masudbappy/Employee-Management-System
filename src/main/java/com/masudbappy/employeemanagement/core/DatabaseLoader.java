package com.masudbappy.employeemanagement.core;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.entities.Designation;
import com.masudbappy.employeemanagement.entities.Education;
import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.repositories.DepartmentRepository;
import com.masudbappy.employeemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner{

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

//        Employee employee = new Employee();
//        Department department = new Department();
//        employee.setName("Masud");
//        department.setDeparmentName("Software");
//        departmentRepository.save(department);
//        employee.setDepartment(department);
//        employee.addEducation(new Education("UAP","MMC","CSPHS"));
//        employee.addDesignation(new Designation("Software Engineer"));
//        employeeRepository.save(employee);
    }
}

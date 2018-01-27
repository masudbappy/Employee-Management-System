package com.masudbappy.employeemanagement.services;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.entities.Designation;
import com.masudbappy.employeemanagement.entities.Education;
import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.repositories.DepartmentRepository;
import com.masudbappy.employeemanagement.repositories.DesignationRepository;
import com.masudbappy.employeemanagement.repositories.EducationRepository;
import com.masudbappy.employeemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private EducationRepository educationRepository;
    private DesignationRepository designationRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EducationRepository educationRepository, DesignationRepository designationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.educationRepository = educationRepository;
        this.designationRepository = designationRepository;
    }

    public Employee createEmployee(Employee employee){
        if (employee==null) throw new IllegalArgumentException("Employee can't be null");
        if (employee.getDepartment()!=null && employee.getDepartment().getId()==null){
            Department department = this.departmentRepository.save(employee.getDepartment());
            employee.setDepartment(department);
        }
        return this.employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return (List<Employee>) employeeRepository.findAll();
    }


}

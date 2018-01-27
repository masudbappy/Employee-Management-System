package com.masudbappy.employeemanagement.services;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.repositories.DepartmentRepository;
import com.masudbappy.employeemanagement.repositories.DesignationRepository;
import com.masudbappy.employeemanagement.repositories.EducationRepository;
import com.masudbappy.employeemanagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Employee save(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Employee can't be null");
        if (employee.getDepartment() != null && employee.getDepartment().getId() == null) {
            Department department = this.departmentRepository.save(employee.getDepartment());
            employee.setDepartment(department);
        }
        return this.employeeRepository.save(employee);
    }

    public Employee findOne(Long id){
        if (id==null) throw new IllegalArgumentException("ID can't be null");
        return this.employeeRepository.findOne(id);
    }

    public Page<Employee> findAll(int page) {
        return employeeRepository.findAll(new PageRequest(page, 10, Sort.Direction.DESC, "id"));
    }

    public void delete(Long id){
        if (id==null) throw new IllegalArgumentException("ID can't be null");
        this.employeeRepository.delete(id);
    }

}

package com.masudbappy.employeemanagement.controllers;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.entities.Designation;
import com.masudbappy.employeemanagement.entities.Education;
import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.repositories.DepartmentRepository;
import com.masudbappy.employeemanagement.repositories.EmployeeRepository;
import com.masudbappy.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Employee getById(@RequestParam("id") Long id) {
        Employee e = employeeRepository.findOne(id);
        return e;
    }


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employee = this.employeeService.createEmployee(employee);
        return ResponseEntity.ok(employee);
    }

}

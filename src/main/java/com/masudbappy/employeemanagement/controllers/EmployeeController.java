package com.masudbappy.employeemanagement.controllers;

import com.masudbappy.employeemanagement.entities.Department;
import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.repositories.DepartmentRepository;
import com.masudbappy.employeemanagement.repositories.EmployeeRepository;
import com.masudbappy.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Employee> getAll(){
        return (List<Employee>) employeeService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee create(@RequestBody String name){

        return employeeService.saveEmployee(name);
    }
}

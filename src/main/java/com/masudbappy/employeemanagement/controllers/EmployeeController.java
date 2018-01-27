package com.masudbappy.employeemanagement.controllers;

import com.masudbappy.employeemanagement.entities.Employee;
import com.masudbappy.employeemanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public ResponseEntity getAll(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        return ResponseEntity.ok(this.employeeService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Employee employee = this.employeeService.findOne(id);
        if (employee == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employee);
    }


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employee = this.employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateEmployee(@PathVariable("id") Long id,
                                         @RequestBody Employee employee) {
        if (employee==null) return ResponseEntity.badRequest().build();
        employee.setId(id);
        employee = this.employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id){
        this.employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

}

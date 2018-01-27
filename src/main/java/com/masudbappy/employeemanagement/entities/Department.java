package com.masudbappy.employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.masudbappy.employeemanagement.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department extends BaseEntity{


    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    public Department() {

        super();
    }

    public Department(String deparmentName) {
        this();
        this.departmentName = deparmentName;
    }

    public String getDeparmentName() {
        return departmentName;
    }

    public void setDeparmentName(String deparmentName) {
        this.departmentName = deparmentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
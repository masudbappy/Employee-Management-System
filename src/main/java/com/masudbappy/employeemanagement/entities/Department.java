package com.masudbappy.employeemanagement.entities;

import com.masudbappy.employeemanagement.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department extends BaseEntity{


    private String deparmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Department() {

        super();
    }

    public Department(String deparmentName) {
        this();
        this.deparmentName = deparmentName;
    }

    public String getDeparmentName() {
        return deparmentName;
    }

    public void setDeparmentName(String deparmentName) {
        this.deparmentName = deparmentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
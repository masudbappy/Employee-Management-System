package com.masudbappy.employeemanagement.entities;

import com.masudbappy.employeemanagement.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Designation extends BaseEntity{

    private String designationName;

    @ManyToOne
    private Employee employee;

    public Designation() {

        super();
    }

    public Designation(String designationName) {
        this();
        this.designationName = designationName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

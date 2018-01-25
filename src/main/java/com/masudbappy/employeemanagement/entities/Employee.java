package com.masudbappy.employeemanagement.entities;

import com.masudbappy.employeemanagement.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Employee extends BaseEntity{

    private String name;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Education> educationList;

    @OneToMany(mappedBy = "employee")
    private List<Designation> designationList;

    public Employee() {
        super();
    }

    public Employee(Department department, List<Education> educationList, List<Designation> designationList) {
        this();
        this.department = department;
        this.educationList = educationList;
        this.designationList = designationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Designation> getDesignationList() {
        return designationList;
    }

    public void setDesignationList(List<Designation> designationList) {
        this.designationList = designationList;
    }
}

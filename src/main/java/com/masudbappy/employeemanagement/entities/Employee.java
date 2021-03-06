package com.masudbappy.employeemanagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.masudbappy.employeemanagement.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends BaseEntity{

    @JsonProperty("name")
    private String name;

    @ManyToOne
    @JsonProperty("department")
    private Department department;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("educationList")
    private List<Education> educationList;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("designationList")
    private List<Designation> designationList;

    public Employee() {
        super();
        educationList = new ArrayList<>();
        designationList = new ArrayList<>();
    }

    public Employee(Department department, List<Education> educationList, List<Designation> designationList) {
        this();
        this.department = department;
        this.educationList = educationList;
        this.designationList = designationList;
    }

    public Employee(String name) {
        this.name = name;
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

    public void addEducation(Education education){
        education.setEmployee(this);
        educationList.add(education);
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Designation> getDesignationList() {
        return designationList;
    }

    public void addDesignation(Designation designation){
        designation.setEmployee(this);
        designationList.add(designation);
    }

    public void setDesignationList(List<Designation> designationList) {
        this.designationList = designationList;
    }
}

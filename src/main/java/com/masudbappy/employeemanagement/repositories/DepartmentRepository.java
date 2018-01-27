package com.masudbappy.employeemanagement.repositories;

import com.masudbappy.employeemanagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

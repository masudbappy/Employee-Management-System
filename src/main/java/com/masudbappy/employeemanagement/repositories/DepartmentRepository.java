package com.masudbappy.employeemanagement.repositories;

import com.masudbappy.employeemanagement.entities.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}

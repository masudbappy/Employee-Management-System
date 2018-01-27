package com.masudbappy.employeemanagement.repositories;

import com.masudbappy.employeemanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String name);

}

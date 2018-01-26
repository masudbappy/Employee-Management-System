package com.masudbappy.employeemanagement.repositories;

import com.masudbappy.employeemanagement.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByName(String name);

}

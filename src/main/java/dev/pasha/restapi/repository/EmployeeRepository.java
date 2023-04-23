package dev.pasha.restapi.repository;

import dev.pasha.restapi.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}

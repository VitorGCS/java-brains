package io.javabrains.springbootjpaexample.repository;

import io.javabrains.springbootjpaexample.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    // fetching an emp

    // persist

    // updating(e)

    //find all emps

}

package com.techgeeknext.repository;

import com.techgeeknext.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(long empId);
}

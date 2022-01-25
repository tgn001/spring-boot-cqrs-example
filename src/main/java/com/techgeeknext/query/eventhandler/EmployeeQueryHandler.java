package com.techgeeknext.query.eventhandler;

import com.techgeeknext.entity.Employee;
import com.techgeeknext.query.controller.EmployeeResponse;
import com.techgeeknext.query.controller.GetEmployeeQuery;
import com.techgeeknext.repository.EmployeeRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EmployeeQueryHandler {
    @Autowired
    EmployeeRepository employeeRepository;

    @QueryHandler
    public List<EmployeeResponse> getEmployees(GetEmployeeQuery employeeQuery){

        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        Optional<List<Employee>> employees = Optional.ofNullable(employeeRepository.findAll());

        if(employees.isPresent()){
            for (Employee empObj: employees.get()){
                EmployeeResponse response = new EmployeeResponse();
                BeanUtils.copyProperties(empObj,response);
                employeeResponses.add(response);
            }
        }

        return employeeResponses;
    }
}

package com.techgeeknext.query.controller;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeQueryController {
    @Autowired
    QueryGateway queryGateway;

    @GetMapping("/employees")
    public List<EmployeeResponse> getEmployees() {
        GetEmployeeQuery employeeQuery = new GetEmployeeQuery();
        return  queryGateway.query
                (employeeQuery,
                ResponseTypes.multipleInstancesOf(EmployeeResponse.class))
                .join();
    }
}

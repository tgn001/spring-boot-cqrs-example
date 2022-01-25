package com.techgeeknext.command.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/employee")
        public String newEmployee(@Valid @RequestBody EmployeeRequest employee) {

        CreateEmployeeCommand newEmployee = CreateEmployeeCommand.builder()
                .uid(UUID.randomUUID().toString())
                .name(employee.getName())
                .address(employee.getAddress())
                .role(employee.getRole())
                .status("CREATED")
                .build();

        try {
            return commandGateway.sendAndWait(newEmployee);
        }catch (Exception exception){
            return exception.getMessage();
        }
    }
}

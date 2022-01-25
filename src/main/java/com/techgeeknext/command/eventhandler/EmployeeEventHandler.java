package com.techgeeknext.command.eventhandler;

import com.techgeeknext.command.event.EmployeeCreatedEvent;
import com.techgeeknext.entity.Employee;
import com.techgeeknext.repository.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void employeCretedEvent(EmployeeCreatedEvent employeeCreatedEvent){
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeCreatedEvent, emp);
        employeeRepository.save(emp);
    }
}

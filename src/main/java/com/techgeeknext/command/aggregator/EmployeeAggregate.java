package com.techgeeknext.command.aggregator;

import com.techgeeknext.command.controller.CreateEmployeeCommand;
import com.techgeeknext.command.event.EmployeeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class EmployeeAggregate {

    //Unique identifier to aggregate
    @AggregateIdentifier
    private String uid;
    private String name;
    private String address;
    private String role;

    public EmployeeAggregate() {
    }

    /**
     * Command Handler method to create employee object
     *
     * @param createEmployeeCommand
     */
    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand createEmployeeCommand) {
        //Here we can handle validation logic on createEmployeeCommand object
        EmployeeCreatedEvent employeeCreatedEvent = new EmployeeCreatedEvent();
        BeanUtils.copyProperties(createEmployeeCommand, employeeCreatedEvent);
        //it invokes event source handler method (employeeEvent) with employee created event
        AggregateLifecycle.apply(employeeCreatedEvent);
    }

    /**
     * Method to store the EmployeeCreatedEvent in the eventstore
     *
     * @param employeeCreatedEvent
     */
    @EventSourcingHandler
    public void employeeEvent(EmployeeCreatedEvent employeeCreatedEvent) {
        this.uid = employeeCreatedEvent.getUid();
        this.name = employeeCreatedEvent.getName();
        this.address = employeeCreatedEvent.getAddress();
        this.role = employeeCreatedEvent.getRole();

    }
}

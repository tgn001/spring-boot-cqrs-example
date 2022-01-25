package com.techgeeknext.query.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeResponse implements Serializable {

    private static final long serialVersionUID = 3490459292051533428L;
    private long employeeId;
    private String name;
    private String address;
    private String role;
}

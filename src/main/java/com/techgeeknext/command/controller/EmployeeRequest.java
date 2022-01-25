package com.techgeeknext.command.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeRequest {

    private String name;
    private String address;
    private String role;
}

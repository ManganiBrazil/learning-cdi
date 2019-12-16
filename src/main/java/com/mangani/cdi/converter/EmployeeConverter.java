package com.mangani.cdi.converter;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.EmployeeResponse;

import javax.enterprise.inject.Default;

@Default
public class EmployeeConverter {

    public EmployeeResponse convert(EmployeeRequest employeeReq) {

        EmployeeResponse employeeResp = new EmployeeResponse();
        employeeResp.setName(employeeReq.getName());

        return employeeResp;
    }
}

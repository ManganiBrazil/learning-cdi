package com.mangani.cdi.service;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.PayrollResponse;

import java.util.List;

public interface PayrollService {

    PayrollResponse calculate(List<EmployeeRequest> employees);

}

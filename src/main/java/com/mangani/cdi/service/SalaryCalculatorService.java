package com.mangani.cdi.service;

import com.mangani.cdi.request.EmployeeRequest;

import java.math.BigDecimal;

public interface SalaryCalculatorService {

    BigDecimal calculate(EmployeeRequest employee);

    void setSalaryReferenceService(SalaryReferenceService salaryReferenceService);
}

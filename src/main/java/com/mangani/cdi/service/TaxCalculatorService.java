package com.mangani.cdi.service;

import com.mangani.cdi.request.EmployeeRequest;
import com.mangani.cdi.response.IncomeRateResponse;

public interface TaxCalculatorService {

    IncomeRateResponse calculateIncomeTax(EmployeeRequest employee);
}
